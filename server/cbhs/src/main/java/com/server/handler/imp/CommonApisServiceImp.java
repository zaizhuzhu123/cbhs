package com.server.handler.imp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.server.common.BeanValidation;
import com.server.common.CbhsResUtils;
import com.server.common.CbhsTokenInfos;
import com.server.common.TokenUtils;
import com.server.exception.ExceptionResponse;
import com.server.exception.ServiceException;
import com.server.handler.CommonApisService;
import com.server.jpa.MyJPAQuery;
import com.server.jpa.MyJPAQuery.PagerResult;
import com.server.manager.PushManager;
import com.server.manager.TokenManager;
import com.server.jpa.MyQueryFactory;
import com.server.pojo.bean.CbhsAccount;
import com.server.pojo.bean.CbhsDept;
import com.server.pojo.bean.CbhsResource;
import com.server.pojo.bean.CbhsRole;
import com.server.pojo.bean.CbhsUser;
import com.server.pojo.bean.CbhsVersion;
import com.server.pojo.bean.QCbhsAccount;
import com.server.pojo.bean.QCbhsCailiao;
import com.server.pojo.bean.QCbhsCb;
import com.server.pojo.bean.QCbhsCbExaminer;
import com.server.pojo.bean.QCbhsCbExaminerRule;
import com.server.pojo.bean.QCbhsDaysFbGclTj;
import com.server.pojo.bean.QCbhsDaysFbLjxmCb;
import com.server.pojo.bean.QCbhsDaysGclSr;
import com.server.pojo.bean.QCbhsDaysGlfyYs;
import com.server.pojo.bean.QCbhsDaysJjcb;
import com.server.pojo.bean.QCbhsDept;
import com.server.pojo.bean.QCbhsResource;
import com.server.pojo.bean.QCbhsRole;
import com.server.pojo.bean.QCbhsUser;
import com.server.pojo.bean.QCbhsVersion;
import com.server.pojo.bean.uiGetUser;
import com.server.pojo.url.common.RequestDelUser;
import com.server.pojo.url.common.RequestDeptDel;
import com.server.pojo.url.common.RequestDeptFetch;
import com.server.pojo.url.common.RequestExit;
import com.server.pojo.url.common.RequestGetUser;
import com.server.pojo.url.common.RequestJPushRegID;
import com.server.pojo.url.common.RequestLogin;
import com.server.pojo.url.common.RequestModifyPwd;
import com.server.pojo.url.common.RequestRegAdmin;
import com.server.pojo.url.common.RequestRegUser;
import com.server.pojo.url.common.RequestRoleDel;
import com.server.pojo.url.common.RequestRoleFetch;
import com.server.pojo.url.common.RequestUploadAvatar;
import com.server.pojo.url.common.RequestVersionFetch;
import com.server.pojo.url.common.ResponseDeptFetch;
import com.server.pojo.url.common.ResponseGetUser;
import com.server.pojo.url.common.ResponseLogin;
import com.server.pojo.url.common.ResponseRoleFetch;
import com.server.pojo.url.common.ResponseVersionFetch;
import com.server.util.CollectionsUtils;
import com.server.util.ExceptionConstant;
import com.server.util.RandomCharUtils;

@SuppressWarnings({ "unchecked", "rawtypes" })
@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, timeout = 60)
public class CommonApisServiceImp implements CommonApisService {

	@Autowired
	private MyQueryFactory queryFactory;
	@Autowired
	private PushManager pushManager;

	@Override
	public ResponseLogin login(RequestLogin request) throws Exception {
		ResponseLogin response = new ResponseLogin();
		CbhsAccount account = null;
		// 1、验证登录方式
		switch (request.getLoginType()) {
		case "pwd":
			account = new CbhsAccount();
			// 使用QueryDsl 查询
			account = queryFactory.findOne(QCbhsAccount.cbhsAccount, QCbhsAccount.cbhsAccount.account.eq(request.getAccount()));
			if (account != null) {
				// 校验密码
				if (account.getPassword().equals(org.apache.commons.codec.digest.DigestUtils.md5Hex(request.getPassword()))) {

				} else {
					throw new ServiceException(new ExceptionResponse(ExceptionConstant.wrongPassword, "密码错误!"));
				}
			} else {
				throw new ServiceException(new ExceptionResponse(ExceptionConstant.accountNotFound, "账号不存在!"));
			}
			break;
		case "phone":
			throw new ServiceException(new ExceptionResponse(ExceptionConstant.notOpen, "未开放手机登录!"));
		default:
			throw new ServiceException(new ExceptionResponse(99999, "登录方式错误!"));
		}
		CbhsUser user = account.getUser();
		if (!user.getStatus()) {
			throw new ServiceException(new ExceptionResponse(99999, "账号被注销，需要恢复使用 请联系管理员!"));
		}
		response.setUser(user);
		response.setAccountKey(account.getAccountKey());
		// 2、生成token
		CbhsTokenInfos token = new CbhsTokenInfos();
		token.setAccountKey(account.getAccountKey());
		token.setUserOid(user.getOid());
		token.setTimestamp(System.currentTimeMillis());
		token.setUserName(user.getName());
		String autoToken = TokenUtils.createToken(token);
		account.setToken(autoToken);
		String platform = request.getPlatform();
		if (StringUtils.isNotBlank(request.getPlatform()) && platform.equals("web")) {
			queryFactory.update(QCbhsAccount.cbhsAccount).set(QCbhsAccount.cbhsAccount.webtoken, autoToken).where(QCbhsAccount.cbhsAccount.accountKey.eq(account.getAccountKey())).execute();
			TokenManager.getInstance().addToken(account.getAccountKey() + "_web", autoToken);
		} else {
			queryFactory.update(QCbhsAccount.cbhsAccount).set(QCbhsAccount.cbhsAccount.token, autoToken).where(QCbhsAccount.cbhsAccount.accountKey.eq(account.getAccountKey())).execute();
			TokenManager.getInstance().addToken(account.getAccountKey() + "_app", autoToken);
		}
		response.setTokenId(autoToken);
		// 3、查询可操作的部门集合
		if (user.getIsAdmin() || (user.getIsAllDept() != null && user.getIsAllDept())) {
			List<CbhsDept> depts = queryFactory.selectFrom(QCbhsDept.cbhsDept).where(QCbhsDept.cbhsDept.status.eq(true)).fetch();
			response.setDepts(depts);
		} else {
			if (user.getDeptOid() != null && user.getDeptOid() > 0) {
				List<CbhsDept> depts = Lists.newArrayList(queryFactory.findOne(CbhsDept.class, user.getDeptOid()));
				response.setDepts(depts);
			}
		}
		// 4、查询可操作的菜单权限
		if (StringUtils.isNotBlank(user.getMenuids()) || StringUtils.isNotBlank(user.getRoleids())) {
			List<String> roleMenuIds = Lists.newArrayList();
			List<String> strList = Splitter.on("|").trimResults().omitEmptyStrings().splitToList(user.getRoleids());
			List<Integer> roleOidList = CollectionsUtils.listStr2Int(strList);
			if (roleOidList.size() > 0) {
				roleMenuIds = queryFactory.select(QCbhsRole.cbhsRole.menuids).from(QCbhsRole.cbhsRole).where(QCbhsRole.cbhsRole.oid.in(roleOidList)).fetch();
			}
			Set<String> menuOids = Sets.newHashSet();
			// 将用户自定义的权限加入
			if (StringUtils.isNotBlank(user.getMenuids())) {
				menuOids = Sets.union(menuOids, new HashSet(Splitter.on("|").trimResults().omitEmptyStrings().splitToList(user.getMenuids())));
			}
			// 将角色附带的权限加入
			if (roleMenuIds.size() > 0) {
				for (String addMenuOids : roleMenuIds) {
					menuOids = Sets.union(menuOids, new HashSet(Splitter.on("|").trimResults().omitEmptyStrings().splitToList(addMenuOids)));
				}
			}
			String str = "";
			if (menuOids.size() > 0) {
				str = "|" + Joiner.on("|").skipNulls().join(menuOids).replace("|", "||") + "|";
			}
			response.setMenuids(str);
		}
		// 5、查询最新版本号
		CbhsVersion version = queryFactory.selectFrom(QCbhsVersion.cbhsVersion).orderBy(QCbhsVersion.cbhsVersion.oid.desc()).fetchFirst();
		response.setLastVersion(version);
		return response;
	}

	@Override
	public JSONObject exit(RequestExit request) throws Exception {
		// 根据AccountKey和token重新生成token
		QCbhsAccount upAcc = QCbhsAccount.cbhsAccount;
		String newToken = UUID.randomUUID().toString().replaceAll("-", "");
		String platform = request.getPlatform();
		if (StringUtils.isNotBlank(request.getPlatform()) && platform.equals("web")) {
			queryFactory.update(upAcc).set(upAcc.webtoken, newToken).where(upAcc.accountKey.eq(request.getAccountKey()).and(upAcc.token.eq(request.getToken()))).execute();
			TokenManager.getInstance().removeToken(request.getAccountKey() + "_web");
		} else {
			queryFactory.update(upAcc).set(upAcc.token, newToken).where(upAcc.accountKey.eq(request.getAccountKey()).and(upAcc.token.eq(request.getToken()))).execute();
			TokenManager.getInstance().removeToken(request.getAccountKey() + "_app");
		}
		return CbhsResUtils.suc();
	}

	@Override
	public JSONObject regAdmin(RequestRegAdmin request) throws Exception {
		// TODO Auto-generated method stub
		// 1、账号是否已注册
		Preconditions.checkArgument(!queryFactory.exists(QCbhsAccount.cbhsAccount, QCbhsAccount.cbhsAccount.account.eq(request.getAccount())), "账号已存在");
		// 2、添加数据
		CbhsUser user = new CbhsUser();
		if (StringUtils.isBlank(request.getName())) {
			user.setName("cbhs_" + RandomCharUtils.createRandomCharData(8));
		} else {
			user.setName(request.getName());
		}
		if (request.getSex() != null) {
			user.setSex(request.getSex());
		} else {
			user.setSex(true);
		}
		user.setPhoneNumber(request.getPhoneNumber());
		user.setIsAdmin(true);
		user.setSex(true);
		user.setStatus(true);
		user = queryFactory.saveOrUpdate(user);
		CbhsAccount account = new CbhsAccount();
		account.setAccount(request.getAccount());
		account.setPassword(org.apache.commons.codec.digest.DigestUtils.md5Hex(request.getPassword()));
		account.setUser(user);
		account = queryFactory.saveOrUpdate(account);
		// 4、生成token
		CbhsTokenInfos token = new CbhsTokenInfos();
		token.setAccountKey(account.getAccountKey());
		token.setUserOid(user.getOid());
		token.setUserName(user.getName());
		String autoToken = TokenUtils.createToken(token);
		account.setToken(autoToken);
		queryFactory.saveOrUpdate(account);
		return CbhsResUtils.suc();
	}

	@Override
	public CbhsUser regUser(RequestRegUser request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, request.getDeptOid());
		// 1、账号是否已注册
		Preconditions.checkArgument(!queryFactory.exists(QCbhsAccount.cbhsAccount, QCbhsAccount.cbhsAccount.account.eq(request.getAccount())), "账号已存在");
		// 2、添加数据
		CbhsUser user = new CbhsUser();
		user.setName(request.getName());
		user.setIsAdmin(false);
		user.setSex(request.getSex());
		user.setStatus(true);
		user.setMenuids(request.getMenuids());
		user.setPhoneNumber(request.getPhoneNumber());
		user.setRoleids(request.getRoleids());
		user.setDeptOid(request.getDeptOid());
		user.setDeptName(request.getDeptName());
		user.setRoleNames(request.getRoleNames());
		user.setIsAllDept(request.getIsAllDept() != null ? request.getIsAllDept() : false);
		user = queryFactory.saveOrUpdate(user);
		CbhsAccount account = new CbhsAccount();
		account.setAccount(request.getAccount());
		account.setPassword(org.apache.commons.codec.digest.DigestUtils.md5Hex(request.getPassword()));
		account.setUser(user);
		account = queryFactory.saveOrUpdate(account);
		return user;
	}

	@Override
	public ResponseGetUser getUser(RequestGetUser request, HttpServletRequest httpServletRequest) throws Exception {
		QCbhsUser query_ = QCbhsUser.cbhsUser;
		// 查询对象
		MyJPAQuery<uiGetUser> jpaquery = (MyJPAQuery<uiGetUser>) queryFactory.select(Projections.bean(uiGetUser.class, query_.oid, query_.name, query_.phoneNumber, query_.sex, query_.menuids, query_.roleids, query_.roleNames, query_.deptOid, query_.deptName, query_.isAdmin, query_.avatarOid, query_.avatar, QCbhsAccount.cbhsAccount.account)).from(query_, QCbhsAccount.cbhsAccount).where(QCbhsAccount.cbhsAccount.user.oid.eq(query_.oid));
		// 条件组合
		jpaquery.where(request.getAccount(), query_.oid.in(JPAExpressions.select(QCbhsAccount.cbhsAccount.user.oid).from(QCbhsAccount.cbhsAccount).where(QCbhsAccount.cbhsAccount.account.eq(request.getAccount()))));
		jpaquery.where(request.getName(), query_.name.containsIgnoreCase(request.getName()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		jpaquery.where(request.getRoleOid(), query_.roleids.contains("|" + request.getRoleOid() + "|"));
		jpaquery.where(request.getStatus(), query_.status.eq(request.getStatus()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseGetUser response = new ResponseGetUser();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		return response;
	}

	@Override
	public CbhsRole roleAdd(CbhsRole role, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(StringUtils.isNotBlank(role.getName()), "角色名称不能为空!");
		Preconditions.checkArgument(!queryFactory.exists(QCbhsRole.cbhsRole, QCbhsRole.cbhsRole.name.eq(role.getName().trim()).and(QCbhsRole.cbhsRole.status.eq(true))), "角色名称已存在!");
		role = queryFactory.saveOrUpdate(role);
		return role;
	}

	@Override
	public CbhsRole roleUpdate(CbhsRole role, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(role.getOid() > 0, "角色ID不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(role.getName()), "角色名称不能为空!");
		Preconditions.checkArgument(!queryFactory.exists(QCbhsRole.cbhsRole, QCbhsRole.cbhsRole.name.eq(role.getName().trim()).and(QCbhsRole.cbhsRole.oid.ne(role.getOid()))), "角色名称已存在!");
		queryFactory.saveOrUpdate(role);
		return role;
	}

	@Override
	public JSONObject roleDel(RequestRoleDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "角色ID不能为空!");
		queryFactory.update(QCbhsRole.cbhsRole).set(QCbhsRole.cbhsRole.status, false).where(QCbhsRole.cbhsRole.oid.in(request.getOids())).execute();
		return CbhsResUtils.suc();
	}

	@Override
	public ResponseRoleFetch roleFetch(RequestRoleFetch request, HttpServletRequest httpServletRequest) throws Exception {
		QCbhsRole query_ = QCbhsRole.cbhsRole;
		// 查询对象
		MyJPAQuery<CbhsRole> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getName(), query_.name.containsIgnoreCase(request.getName()));
		jpaquery.where(request.getStatus(), query_.status.eq(request.getStatus()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseRoleFetch response = new ResponseRoleFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		return response;
	}

	@Override
	public CbhsDept deptAdd(CbhsDept dept, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(StringUtils.isNotBlank(dept.getName()), "部门名称不能为空!");
		Preconditions.checkArgument(!queryFactory.exists(QCbhsDept.cbhsDept, QCbhsDept.cbhsDept.name.eq(dept.getName().trim()).and(QCbhsDept.cbhsDept.status.eq(true))), "部门名称已存在!");
		dept = queryFactory.saveOrUpdate(dept);
		return dept;
	}

	@Override
	public CbhsDept deptUpdate(CbhsDept dept, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(dept.getOid() > 0, "部门ID不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(dept.getName()), "部门名称不能为空!");
		Preconditions.checkArgument(!queryFactory.exists(QCbhsDept.cbhsDept, QCbhsDept.cbhsDept.name.eq(dept.getName().trim()).and(QCbhsDept.cbhsDept.oid.ne(dept.getOid()))), "部门名称已存在!");
		queryFactory.saveOrUpdate(dept);
		// 修改关联
		// queryFactory.update(QCbhsCb.cbhsCb).set(QCbhsCb.cbhsCb.deptName,
		// dept.getName()).where(QCbhsCb.cbhsCb.deptOid.eq(dept.getOid())).execute();
		// queryFactory.update(QCbhsCbExaminer.cbhsCbExaminer).set(QCbhsCbExaminer.cbhsCbExaminer.deptName,
		// dept.getName()).where(QCbhsCbExaminer.cbhsCbExaminer.deptOid.eq(dept.getOid())).execute();
		// queryFactory.update(QCbhsCbExaminerRule.cbhsCbExaminerRule).set(QCbhsCbExaminerRule.cbhsCbExaminerRule.deptNames,
		// dept.getName()).where(QCbhsCbExaminerRule.cbhsCbExaminerRule.deptOid.eq(dept.getOid())).execute();
		// queryFactory.update(QCbhsDaysJjcb.cbhsDaysJjcb).set(QCbhsDaysJjcb.cbhsDaysJjcb.deptName,
		// dept.getName()).where(QCbhsDaysJjcb.cbhsDaysJjcb.deptOid.eq(dept.getOid())).execute();
		// queryFactory.update(QCbhsDaysFbGclTj.cbhsDaysFbGclTj).set(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.deptName,
		// dept.getName()).where(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.deptOid.eq(dept.getOid())).execute();
		// queryFactory.update(QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb).set(QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb.deptName,
		// dept.getName()).where(QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb.deptOid.eq(dept.getOid())).execute();
		// queryFactory.update(QCbhsDaysGclSr.cbhsDaysGclSr).set(QCbhsDaysGclSr.cbhsDaysGclSr.deptName,
		// dept.getName()).where(QCbhsDaysGclSr.cbhsDaysGclSr.deptOid.eq(dept.getOid())).execute();
		// queryFactory.update(QCbhsDaysGlfyYs.cbhsDaysGlfyYs).set(QCbhsDaysGlfyYs.cbhsDaysGlfyYs.deptName,
		// dept.getName()).where(QCbhsDaysGlfyYs.cbhsDaysGlfyYs.deptOid.eq(dept.getOid())).execute();

		return dept;
	}

	@Override
	public JSONObject deptDel(RequestDeptDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "需要删除的部门ID不能为空!");
		queryFactory.update(QCbhsDept.cbhsDept).set(QCbhsDept.cbhsDept.status, false).where(QCbhsDept.cbhsDept.oid.in(request.getOids())).execute();
		return CbhsResUtils.suc();
	}

	@Override
	public ResponseDeptFetch deptFetch(RequestDeptFetch request, HttpServletRequest httpServletRequest) throws Exception {
		QCbhsDept query_ = QCbhsDept.cbhsDept;
		// 查询对象
		MyJPAQuery<CbhsDept> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getName(), query_.name.containsIgnoreCase(request.getName()));
		jpaquery.where(request.getStatus(), query_.status.eq(request.getStatus()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseDeptFetch response = new ResponseDeptFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		return response;
	}

	@Override
	public JSONObject modifyPwd(RequestModifyPwd request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		if (queryFactory.update(QCbhsAccount.cbhsAccount).set(QCbhsAccount.cbhsAccount.password, org.apache.commons.codec.digest.DigestUtils.md5Hex(request.getNewPwd())).where(QCbhsAccount.cbhsAccount.accountKey.eq(request.getAccountKey()).and(QCbhsAccount.cbhsAccount.password.eq(org.apache.commons.codec.digest.DigestUtils.md5Hex(request.getOldPwd())))).execute() > 0) {
			return CbhsResUtils.suc();
		} else {
			throw new ServiceException(new ExceptionResponse(-1, "修改密码失败,密码不正确!"));
		}
	}

	@Override
	public JSONObject jPushRegID(RequestJPushRegID request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		Preconditions.checkArgument(StringUtils.isNotBlank(request.getRegistrationID()), "设备ID不能为空!");
		CbhsTokenInfos infos = TokenUtils.getTokenInfo(httpServletRequest);
		String accountKey = infos.getAccountKey();
		queryFactory.update(QCbhsAccount.cbhsAccount).set(QCbhsAccount.cbhsAccount.ryToken, "").where(QCbhsAccount.cbhsAccount.ryToken.eq(request.getRegistrationID())).execute();
		queryFactory.update(QCbhsAccount.cbhsAccount).set(QCbhsAccount.cbhsAccount.ryToken, request.getRegistrationID()).where(QCbhsAccount.cbhsAccount.accountKey.eq(accountKey)).execute();
		return CbhsResUtils.suc();
	}

	@Override
	public JSONObject updateUser(CbhsUser user, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(user.getOid() > 0, "用户ID不能为空!");
		// CbhsUser user_ = queryFactory.findOne(CbhsUser.class, user.getOid());
		// if (user_ != null) {
		// user.setAvatarOid(user.getAvatarOid());
		// }
		queryFactory.saveOrUpdate(user);
		return CbhsResUtils.suc();
	}

	@Override
	public JSONObject uploadAvatar(RequestUploadAvatar request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		Preconditions.checkArgument(request.getAvatarOid() > 0, "资源ID不能为空!");
		CbhsResource resource = queryFactory.findOne(CbhsResource.class, request.getAvatarOid());
		Preconditions.checkArgument(resource != null, "资源不存在!");
		queryFactory.update(QCbhsUser.cbhsUser).set(QCbhsUser.cbhsUser.avatarOid, resource.getOid()).set(QCbhsUser.cbhsUser.avatar, resource.getUrl()).where(QCbhsUser.cbhsUser.oid.eq(TokenUtils.getTokenInfo(httpServletRequest).getUserOid())).execute();
		return CbhsResUtils.suc();
	}

	@Override
	public JSONObject delUser(RequestDelUser request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "用户ID不能为空!");
		queryFactory.update(QCbhsUser.cbhsUser).set(QCbhsUser.cbhsUser.status, false).where(QCbhsUser.cbhsUser.oid.in(request.getOids())).execute();
		return CbhsResUtils.suc();
	}

	@Override
	public ResponseVersionFetch versionFetch(RequestVersionFetch request, HttpServletRequest httpServletRequest) throws Exception {
		QCbhsVersion query_ = QCbhsVersion.cbhsVersion;
		// 查询对象
		MyJPAQuery<CbhsVersion> jpaquery = queryFactory.selectFrom(query_);
		jpaquery.orderBy(query_.oid.desc());
		// 查询总数
		ResponseVersionFetch response = new ResponseVersionFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		return response;
	}

	@Override
	public CbhsVersion versionUpdate(CbhsVersion version, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(version.getFileOid() > 0, "文件ID不能为空!");
		Preconditions.checkArgument(version.getVersionCode() > 0, "版本号必须大于0!");
		long time = System.currentTimeMillis();
		DateTime dt = new DateTime(time);
		version.setOpTimeStr(dt.toString("yyyy-MM-dd HH:mm:ss"));
		version.setOpTime(dt.getMillis());
		version = queryFactory.saveOrUpdate(version);
		return version;
	}

	@Override
	public CbhsVersion versionAdd(CbhsVersion version, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(version.getFileOid() > 0, "文件ID不能为空!");
		Preconditions.checkArgument(queryFactory.exists(QCbhsResource.cbhsResource, QCbhsResource.cbhsResource.oid.eq(version.getFileOid())), "资源不存在!请上传资源");
		Preconditions.checkArgument(version.getVersionCode() > 0, "版本号必须大于0!");
		version = queryFactory.saveOrUpdate(version);
		// 推送给所有用户
		pushManager.pushUpgradeMessage(version);
		return version;
	}
}
