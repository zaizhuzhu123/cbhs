package com.server.handler.imp;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.querydsl.jpa.JPAExpressions;
import com.server.common.BeanValidation;
import com.server.common.CbhsResUtils;
import com.server.exception.ExceptionResponse;
import com.server.exception.ServiceException;
import com.server.handler.BaseApisService;
import com.server.jpa.MyJPAQuery;
import com.server.jpa.MyJPAQuery.PagerResult;
import com.server.jpa.MyQueryFactory;
import com.server.pojo.bean.CbhsCailiao;
import com.server.pojo.bean.CbhsCailiaoKemu;
import com.server.pojo.bean.CbhsFbCompany;
import com.server.pojo.bean.CbhsGlfyRule;
import com.server.pojo.bean.CbhsGz;
import com.server.pojo.bean.CbhsHt;
import com.server.pojo.bean.CbhsMachinery;
import com.server.pojo.bean.CbhsMachineryType;
import com.server.pojo.bean.CbhsProject;
import com.server.pojo.bean.QCbhsCailiao;
import com.server.pojo.bean.QCbhsCailiaoKemu;
import com.server.pojo.bean.QCbhsFbCompany;
import com.server.pojo.bean.QCbhsGlfyRule;
import com.server.pojo.bean.QCbhsGz;
import com.server.pojo.bean.QCbhsHt;
import com.server.pojo.bean.QCbhsMachinery;
import com.server.pojo.bean.QCbhsMachineryType;
import com.server.pojo.bean.QCbhsProject;
import com.server.pojo.url.base.RequestCailiaoDel;
import com.server.pojo.url.base.RequestCailiaoFetch;
import com.server.pojo.url.base.RequestCailiaoKemuDel;
import com.server.pojo.url.base.RequestCailiaoKemuFetch;
import com.server.pojo.url.base.RequestCbhsGlfyRuleFetch;
import com.server.pojo.url.base.RequestFbCompanyDel;
import com.server.pojo.url.base.RequestFbCompanyFetch;
import com.server.pojo.url.base.RequestGzDel;
import com.server.pojo.url.base.RequestGzFetch;
import com.server.pojo.url.base.RequestHtDel;
import com.server.pojo.url.base.RequestHtFetch;
import com.server.pojo.url.base.RequestMachineryDel;
import com.server.pojo.url.base.RequestMachineryFetch;
import com.server.pojo.url.base.RequestMachineryTypeDel;
import com.server.pojo.url.base.RequestMachineryTypeFetch;
import com.server.pojo.url.base.RequestProjectFetch;
import com.server.pojo.url.base.ResponseCailiaoFetch;
import com.server.pojo.url.base.ResponseCailiaoKemuFetch;
import com.server.pojo.url.base.ResponseFbCompanyFetch;
import com.server.pojo.url.base.ResponseGzFetch;
import com.server.pojo.url.base.ResponseHtFetch;
import com.server.pojo.url.base.ResponseMachineryFetch;
import com.server.pojo.url.base.ResponseMachineryTypeFetch;
import com.server.pojo.url.base.ResponseProjectFetch;
import com.server.util.ExcelUtils;
import com.server.util.ExceptionConstant;
import com.server.util.FileFormatUtils;

@SuppressWarnings({ "unchecked", "rawtypes" })
@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, timeout = 60)
public class BaseApisServiceImp implements BaseApisService {

	@Autowired
	private MyQueryFactory queryFactory;

	@Override
	@CacheEvict(cacheNames = "CbhsProject", allEntries = true)
	public CbhsProject projectAdd(CbhsProject project, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(StringUtils.isNotBlank(project.getName()), "工程项目名称不能为空!");
		Preconditions.checkArgument(!queryFactory.exists(QCbhsProject.cbhsProject, QCbhsProject.cbhsProject.name.eq(project.getName().trim())), "工程项目名称已存在!");
		project = queryFactory.saveOrUpdate(project);
		return project;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsProject", allEntries = true)
	public CbhsProject projectUpdate(CbhsProject project, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(project.getOid() > 0, "工程项目ID不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(project.getName()), "工程项目名称不能为空!");
		Preconditions.checkArgument(!queryFactory.exists(QCbhsProject.cbhsProject, QCbhsProject.cbhsProject.name.eq(project.getName().trim()).and(QCbhsProject.cbhsProject.oid.ne(project.getOid()))),
				"工程项目名称已存在!");
		project = queryFactory.saveOrUpdate(project);
		return project;
	}

	@Override
	@Cacheable(cacheNames = "CbhsProject", keyGenerator = "myKeyGenerator")
	public ResponseProjectFetch projectFetch(RequestProjectFetch request, HttpServletRequest httpServletRequest) throws Exception {
		QCbhsProject query_ = QCbhsProject.cbhsProject;
		// 查询对象
		MyJPAQuery<CbhsProject> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getName(), query_.name.containsIgnoreCase(request.getName()));
		jpaquery.where(request.getStatus(), query_.status.eq(request.getStatus()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		jpaquery.where(request.getState(), query_.state.gt(request.getState()));
		// 查询总数
		ResponseProjectFetch response = new ResponseProjectFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		return response;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsCailiao", allEntries = true)
	public CbhsCailiao cailiaoAdd(CbhsCailiao cailiao, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(StringUtils.isNotBlank(cailiao.getName()), "材料名称不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.cailiaoKemu, BeanValidation.valiType.all, cailiao.getKemuOid());
		String kemuName = queryFactory.select(QCbhsCailiaoKemu.cbhsCailiaoKemu.name).from(QCbhsCailiaoKemu.cbhsCailiaoKemu).where(QCbhsCailiaoKemu.cbhsCailiaoKemu.oid.eq(cailiao.getKemuOid()))
				.fetchOne();
		cailiao.setKemuName(kemuName);
		Preconditions.checkArgument(
				!queryFactory.exists(QCbhsCailiao.cbhsCailiao,
						QCbhsCailiao.cbhsCailiao.name.eq(cailiao.getName().trim()).and(QCbhsCailiao.cbhsCailiao.style.eq(cailiao.getStyle()).and(QCbhsCailiao.cbhsCailiao.status.eq(true)))),
				"材料及规格已存在!");
		cailiao = queryFactory.saveOrUpdate(cailiao);
		return cailiao;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsCailiao", allEntries = true)
	public CbhsCailiao cailiaoUpdate(CbhsCailiao cailiao, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(cailiao.getOid() > 0, "材料ID不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(cailiao.getName()), "材料名称不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.cailiaoKemu, BeanValidation.valiType.all, cailiao.getKemuOid());
		Preconditions.checkArgument(
				!queryFactory.exists(QCbhsCailiao.cbhsCailiao,
						QCbhsCailiao.cbhsCailiao.name.eq(cailiao.getName().trim()).and(QCbhsCailiao.cbhsCailiao.style.eq(cailiao.getStyle()).and(QCbhsCailiao.cbhsCailiao.oid.ne(cailiao.getOid())))),
				"材料名称及规格已存在!");
		queryFactory.saveOrUpdate(cailiao);
		return cailiao;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsCailiao", allEntries = true)
	public JSONObject cailiaoDel(RequestCailiaoDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "材料ID不能为空!");
		queryFactory.update(QCbhsCailiao.cbhsCailiao).set(QCbhsCailiao.cbhsCailiao.status, false).where(QCbhsCailiao.cbhsCailiao.oid.in(request.getOids())).execute();
		return CbhsResUtils.suc();
	}

	@Override
	@Cacheable(cacheNames = "CbhsCailiao", keyGenerator = "myKeyGenerator")
	public ResponseCailiaoFetch cailiaoFetch(RequestCailiaoFetch request, HttpServletRequest httpServletRequest) throws Exception {
		QCbhsCailiao query_ = QCbhsCailiao.cbhsCailiao;
		// 查询对象
		MyJPAQuery<CbhsCailiao> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getName(), query_.name.containsIgnoreCase(request.getName()));
		jpaquery.where(request.getStatus(), query_.status.eq(request.getStatus()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		jpaquery.where(request.getStyle(), query_.style.eq(request.getStyle()));
		jpaquery.where(request.getKemuOid(), query_.kemuOid.eq(request.getKemuOid()));
		Integer isRy = request.getIsRy();
		if (isRy != null && isRy > 0) {
			jpaquery.where(
					isRy,
					query_.kemuOid.in(JPAExpressions.select(QCbhsCailiaoKemu.cbhsCailiaoKemu.oid).from(QCbhsCailiaoKemu.cbhsCailiaoKemu)
							.where(QCbhsCailiaoKemu.cbhsCailiaoKemu.isRy.eq(isRy == 1 ? true : false))));
		}
		// 查询总数
		ResponseCailiaoFetch response = new ResponseCailiaoFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		return response;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsCailiaoKemu", allEntries = true)
	public CbhsCailiaoKemu cailiaoKemuAdd(CbhsCailiaoKemu kemu, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(StringUtils.isNotBlank(kemu.getName()), "材料科目名称不能为空!");
		Preconditions.checkArgument(
				!queryFactory.exists(QCbhsCailiaoKemu.cbhsCailiaoKemu, QCbhsCailiaoKemu.cbhsCailiaoKemu.name.eq(kemu.getName().trim()).and(QCbhsCailiaoKemu.cbhsCailiaoKemu.status.eq(true))),
				"材料科目名称已存在!");
		kemu = queryFactory.saveOrUpdate(kemu);
		return kemu;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsCailiaoKemu", allEntries = true)
	public CbhsCailiaoKemu cailiaoKemuUpdate(CbhsCailiaoKemu kemu, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(kemu.getOid() > 0, "材料科目ID不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(kemu.getName()), "材料科目名称不能为空!");
		Preconditions.checkArgument(
				!queryFactory.exists(QCbhsCailiaoKemu.cbhsCailiaoKemu, QCbhsCailiaoKemu.cbhsCailiaoKemu.name.eq(kemu.getName().trim()).and(QCbhsCailiaoKemu.cbhsCailiaoKemu.oid.ne(kemu.getOid()))),
				"材料科目名称已存在!");
		queryFactory.saveOrUpdate(kemu);
		return kemu;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsCailiaoKemu", allEntries = true)
	public JSONObject cailiaoKemuDel(RequestCailiaoKemuDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "材料科目ID不能为空!");
		queryFactory.update(QCbhsCailiaoKemu.cbhsCailiaoKemu).set(QCbhsCailiaoKemu.cbhsCailiaoKemu.status, false).where(QCbhsCailiaoKemu.cbhsCailiaoKemu.oid.in(request.getOids())).execute();
		return CbhsResUtils.suc();
	}

	@Override
	@Cacheable(cacheNames = "CbhsCailiaoKemu", keyGenerator = "myKeyGenerator")
	public ResponseCailiaoKemuFetch cailiaoKemuFetch(RequestCailiaoKemuFetch request, HttpServletRequest httpServletRequest) throws Exception {
		QCbhsCailiaoKemu query_ = QCbhsCailiaoKemu.cbhsCailiaoKemu;
		// 查询对象
		MyJPAQuery<CbhsCailiaoKemu> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getName(), query_.name.containsIgnoreCase(request.getName()));
		jpaquery.where(request.getStatus(), query_.status.eq(request.getStatus()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseCailiaoKemuFetch response = new ResponseCailiaoKemuFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		return response;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsFbCompany", allEntries = true)
	public CbhsFbCompany fbCompanyAdd(CbhsFbCompany company, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(StringUtils.isNotBlank(company.getName()), "分包公司名称不能为空!");
		Preconditions.checkArgument(
				!queryFactory.exists(QCbhsFbCompany.cbhsFbCompany, QCbhsFbCompany.cbhsFbCompany.name.eq(company.getName().trim()).and(QCbhsFbCompany.cbhsFbCompany.status.eq(true))), "分包公司名称已存在!");
		company = queryFactory.saveOrUpdate(company);
		return company;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsFbCompany", allEntries = true)
	public CbhsFbCompany fbCompanyUpdate(CbhsFbCompany company, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(company.getOid() > 0, "分包公司ID不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(company.getName()), "分包公司名称不能为空!");
		Preconditions.checkArgument(
				!queryFactory.exists(QCbhsFbCompany.cbhsFbCompany,
						QCbhsFbCompany.cbhsFbCompany.name.eq(company.getName().trim()).and(QCbhsFbCompany.cbhsFbCompany.status.eq(true)).and(QCbhsFbCompany.cbhsFbCompany.oid.ne(company.getOid()))),
				"分包公司名称已存在!");
		queryFactory.saveOrUpdate(company);
		return company;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsFbCompany", allEntries = true)
	public JSONObject fbCompanyDel(RequestFbCompanyDel request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		Preconditions.checkArgument(request.getOids().size() > 0, "分包公司ID不能为空!");
		queryFactory.update(QCbhsFbCompany.cbhsFbCompany).set(QCbhsFbCompany.cbhsFbCompany.status, false).where(QCbhsFbCompany.cbhsFbCompany.oid.in(request.getOids())).execute();
		return CbhsResUtils.suc();
	}

	@Override
	@Cacheable(cacheNames = "CbhsFbCompany", keyGenerator = "myKeyGenerator")
	public ResponseFbCompanyFetch fbCompanyFetch(RequestFbCompanyFetch request, HttpServletRequest httpServletRequest) throws Exception {
		QCbhsFbCompany query_ = QCbhsFbCompany.cbhsFbCompany;
		// 查询对象
		MyJPAQuery<CbhsFbCompany> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getName(), query_.name.containsIgnoreCase(request.getName()));
		jpaquery.where(request.getStatus(), query_.status.eq(request.getStatus()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseFbCompanyFetch response = new ResponseFbCompanyFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		return response;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsMachineryType", allEntries = true)
	public CbhsMachineryType machineryTypeAdd(CbhsMachineryType machineryType, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(StringUtils.isNotBlank(machineryType.getName()), "机械设备种类名称不能为空!");
		Preconditions.checkArgument(
				!queryFactory.exists(QCbhsMachineryType.cbhsMachineryType,
						QCbhsMachineryType.cbhsMachineryType.name.eq(machineryType.getName().trim()).and(QCbhsMachineryType.cbhsMachineryType.status.eq(true))), "机械设备种类名称已存在!");
		machineryType = queryFactory.saveOrUpdate(machineryType);
		return machineryType;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsMachineryType", allEntries = true)
	public CbhsMachineryType machineryTypeUpdate(CbhsMachineryType machineryType, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(machineryType.getOid() > 0, "机械设备种类ID不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(machineryType.getName()), "机械设备种类名称不能为空!");
		Preconditions.checkArgument(
				!queryFactory.exists(QCbhsMachineryType.cbhsMachineryType,
						QCbhsMachineryType.cbhsMachineryType.name.eq(machineryType.getName().trim()).and(QCbhsMachineryType.cbhsMachineryType.oid.ne(machineryType.getOid()))), "机械设备种类名称已存在!");
		queryFactory.saveOrUpdate(machineryType);
		return machineryType;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsMachineryType", allEntries = true)
	public JSONObject machineryTypeDel(RequestMachineryTypeDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "需要删除的机械设备种类ID不能为空!");
		queryFactory.update(QCbhsMachineryType.cbhsMachineryType).set(QCbhsMachineryType.cbhsMachineryType.status, false).where(QCbhsMachineryType.cbhsMachineryType.oid.in(request.getOids()))
				.execute();
		return CbhsResUtils.suc();
	}

	@Override
	@Cacheable(cacheNames = "CbhsMachineryType", keyGenerator = "myKeyGenerator")
	public ResponseMachineryTypeFetch machineryTypeFetch(RequestMachineryTypeFetch request, HttpServletRequest httpServletRequest) throws Exception {
		QCbhsMachineryType query_ = QCbhsMachineryType.cbhsMachineryType;
		// 查询对象
		MyJPAQuery<CbhsMachineryType> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getName(), query_.name.containsIgnoreCase(request.getName()));
		jpaquery.where(request.getStatus(), query_.status.eq(request.getStatus()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseMachineryTypeFetch response = new ResponseMachineryTypeFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		return response;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsMachinery", allEntries = true)
	public CbhsMachinery machineryAdd(CbhsMachinery machinery, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(StringUtils.isNotBlank(machinery.getName()), "设备名称不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(machinery.getStyle()), "设备规格型号不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.machineryType, BeanValidation.valiType.all, machinery.getMachineryTypeOid());
		Preconditions.checkArgument(
				!queryFactory.exists(
						QCbhsMachinery.cbhsMachinery,
						QCbhsMachinery.cbhsMachinery.name.eq(machinery.getName().trim()).and(
								QCbhsMachinery.cbhsMachinery.style.eq(machinery.getStyle()).and(QCbhsMachinery.cbhsMachinery.status.eq(true)))), "设备规格型号已存在!");
		machinery = queryFactory.saveOrUpdate(machinery);
		return machinery;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsMachinery", allEntries = true)
	public CbhsMachinery machineryUpdate(CbhsMachinery machinery, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(machinery.getOid() > 0, "设备ID不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(machinery.getName()), "设备名称不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(machinery.getStyle()), "设备规格型号不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.machineryType, BeanValidation.valiType.all, machinery.getMachineryTypeOid());
		Preconditions.checkArgument(
				!queryFactory.exists(
						QCbhsMachinery.cbhsMachinery,
						QCbhsMachinery.cbhsMachinery.name.eq(machinery.getName().trim()).and(
								QCbhsMachinery.cbhsMachinery.style.eq(machinery.getStyle()).and(QCbhsMachinery.cbhsMachinery.oid.ne(machinery.getOid())))), "设备规格型号已存在!");
		machinery = queryFactory.saveOrUpdate(machinery);
		return machinery;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsMachinery", allEntries = true)
	public JSONObject machineryDel(RequestMachineryDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "设备ID不能为空!");
		queryFactory.update(QCbhsMachinery.cbhsMachinery).set(QCbhsMachinery.cbhsMachinery.status, false).where(QCbhsMachinery.cbhsMachinery.oid.in(request.getOids())).execute();
		return CbhsResUtils.suc();
	}

	@Override
	@Cacheable(cacheNames = "CbhsMachinery", keyGenerator = "myKeyGenerator")
	public ResponseMachineryFetch machineryFetch(RequestMachineryFetch request, HttpServletRequest httpServletRequest) throws Exception {
		QCbhsMachinery query_ = QCbhsMachinery.cbhsMachinery;
		// 查询对象
		MyJPAQuery<CbhsMachinery> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getName(), query_.name.containsIgnoreCase(request.getName()));
		jpaquery.where(request.getStatus(), query_.status.eq(request.getStatus()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		jpaquery.where(request.getTypeOid(), query_.machineryTypeOid.eq(request.getTypeOid()));
		jpaquery.where(request.getUsed(), query_.used.eq(request.getUsed()));
		// 查询总数
		ResponseMachineryFetch response = new ResponseMachineryFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		return response;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsGlfyRule", allEntries = true)
	public JSONObject cbhsGlfyRuleAdd(CbhsGlfyRule rule, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(!queryFactory.exists(QCbhsGlfyRule.cbhsGlfyRule, QCbhsGlfyRule.cbhsGlfyRule.projectOid.eq(rule.getProjectOid())), "项目已配置管理费用上缴公式，不能重复配置!");
		queryFactory.saveOrUpdate(rule);
		return CbhsResUtils.suc();
	}

	@Override
	@CacheEvict(cacheNames = "CbhsGlfyRule", allEntries = true)
	public JSONObject cbhsGlfyRuleUpdate(CbhsGlfyRule rule, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		Preconditions.checkArgument(queryFactory.exists(QCbhsGlfyRule.cbhsGlfyRule, QCbhsGlfyRule.cbhsGlfyRule.oid.eq(rule.getOid())), "管理费用公式不存在!");
		queryFactory.saveOrUpdate(rule);
		return CbhsResUtils.suc();
	}

	@Override
	@Cacheable(cacheNames = "CbhsGlfyRule", keyGenerator = "myKeyGenerator")
	public CbhsGlfyRule cbhsGlfyRuleFetch(RequestCbhsGlfyRuleFetch request, HttpServletRequest httpServletRequest) throws Exception {
		QCbhsGlfyRule query_ = QCbhsGlfyRule.cbhsGlfyRule;
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		// 查询对象
		MyJPAQuery<CbhsGlfyRule> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		// 查询总数
		CbhsGlfyRule rule = jpaquery.fetchFirst();
		return rule;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsGz", allEntries = true)
	public CbhsGz gzAdd(CbhsGz gz, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(StringUtils.isNotBlank(gz.getName()), "工种名称不能为空!");
		Preconditions.checkArgument(!queryFactory.exists(QCbhsGz.cbhsGz, QCbhsGz.cbhsGz.name.eq(gz.getName().trim()).and(QCbhsGz.cbhsGz.status.eq(true))), "工种名称已存在!");
		gz = queryFactory.saveOrUpdate(gz);
		return gz;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsGz", allEntries = true)
	public CbhsGz gzUpdate(CbhsGz gz, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(gz.getOid() > 0, "工种ID不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(gz.getName()), "工种名称不能为空!");
		Preconditions.checkArgument(!queryFactory.exists(QCbhsGz.cbhsGz, QCbhsGz.cbhsGz.name.eq(gz.getName().trim()).and(QCbhsGz.cbhsGz.oid.ne(gz.getOid()))), "工种名称已存在!");
		queryFactory.saveOrUpdate(gz);
		return gz;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsGz", allEntries = true)
	public JSONObject gzDel(RequestGzDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "工种ID不能为空!");
		queryFactory.update(QCbhsGz.cbhsGz).set(QCbhsGz.cbhsGz.status, false).where(QCbhsGz.cbhsGz.oid.in(request.getOids())).execute();
		return CbhsResUtils.suc();
	}

	@Override
	@Cacheable(cacheNames = "CbhsGz", keyGenerator = "myKeyGenerator")
	public ResponseGzFetch gzFetch(RequestGzFetch request, HttpServletRequest httpServletRequest) throws Exception {
		QCbhsGz query_ = QCbhsGz.cbhsGz;
		// 查询对象
		MyJPAQuery<CbhsGz> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getName(), query_.name.containsIgnoreCase(request.getName()));
		jpaquery.where(request.getStatus(), query_.status.eq(request.getStatus()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseGzFetch response = new ResponseGzFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		return response;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsCailiao", allEntries = true)
	public JSONObject cailiaoImport(MultipartFile request, Integer projectOid, HttpServletRequest httpServletRequest) throws Exception {
		// 判断文件是否为空
		if (request == null) {
			throw new ServiceException(new ExceptionResponse(ExceptionConstant.fileCannotBeEmpty, "文件不能为空!"));
		}
		// 获取文件名
		String fileName = request.getOriginalFilename();
		// 验证文件名是否合格
		if (!FileFormatUtils.format(FileFormatUtils.excelReg, fileName)) {
			throw new ServiceException(new ExceptionResponse(ExceptionConstant.fileFormatError, "文件格式错误!"));
		}
		// 进一步判断文件内容是否为空（即判断其大小是否为0或其名称是否为null）
		long size = request.getSize();
		if (StringUtils.isEmpty(fileName) || size == 0) {
			throw new ServiceException(new ExceptionResponse(ExceptionConstant.fileCannotBeEmpty, "文件不能为空!"));
		}
		BatchInsertCailiaoByExcel(request, httpServletRequest);
		return CbhsResUtils.suc();
	}

	public boolean BatchInsertCailiaoByExcel(MultipartFile file, HttpServletRequest httpServletRequest) {
		try {
			Workbook workbook = null;
			try {
				workbook = new XSSFWorkbook(file.getInputStream());
			} catch (Exception ex) {
				workbook = new HSSFWorkbook(file.getInputStream());
			}
			List<CbhsCailiao> cailiaos = Lists.newArrayList();
			Sheet sheet = workbook.getSheetAt(0);
			int physicalNumberOfRows = sheet.getPhysicalNumberOfRows(); // 获得该sheet总行数
			for (int j = 0; j < physicalNumberOfRows; j++) {
				if (j < 1) { // 前两行是标题行
					continue;
				}
				Row row = sheet.getRow(j);
				// 项目
				CbhsCailiao cailiao = new CbhsCailiao();
				Cell cell = row.getCell(0);
				Preconditions.checkArgument(cell != null, "材料科目ID不能为空!");
				String value = ExcelUtils.getCellValue(cell);
				Preconditions.checkArgument(StringUtils.isNumeric(value), "材料科目ID[" + value.trim() + "]必须为数字!");
				CbhsCailiaoKemu kemu = queryFactory.findOne(CbhsCailiaoKemu.class, Integer.parseInt(value.trim()));
				Preconditions.checkArgument(kemu != null, "材料科目ID[" + value.trim() + "],该材料科目不存在!");
				cailiao.setKemuOid(kemu.getOid());
				cailiao.setKemuName(kemu.getName());
				cell = row.getCell(1);
				Preconditions.checkArgument(cell != null, "材料名称不能为空!");
				value = ExcelUtils.getCellValue(cell);
				Preconditions.checkArgument(StringUtils.isNotBlank(value), "材料名称不能为空!");
				cailiao.setName(value);
				cell = row.getCell(2);
				Preconditions.checkArgument(cell != null, "材料规格不能为空!");
				value = ExcelUtils.getCellValue(cell);
				cailiao.setStyle(value);
				cell = row.getCell(3);
				Preconditions.checkArgument(cell != null, "材料规格不能为空!");
				value = ExcelUtils.getCellValue(cell);
				cailiao.setUnit(value);
				cell = row.getCell(4);
				Preconditions.checkArgument(cell != null, "单价不能为空!");
				value = ExcelUtils.getCellValue(cell);
				try {
					cailiao.setUnitPrice(new BigDecimal(value.trim()));
				} catch (Exception e) {
					throw new ServiceException(new ExceptionResponse(-1, "单价[" + value + "]必须为数字!"));
				}
				Preconditions.checkArgument(
						!queryFactory.exists(QCbhsCailiao.cbhsCailiao,
								QCbhsCailiao.cbhsCailiao.name.eq(cailiao.getName().trim()).and(QCbhsCailiao.cbhsCailiao.style.eq(cailiao.getStyle()).and(QCbhsCailiao.cbhsCailiao.status.eq(true)))),
						"[" + cailiao.getName() + "|" + cailiao.getStyle() + "],材料及规格已存在!");
				cailiao.setStatus(true);
				cailiaos.add(cailiao);
			}
			if (cailiaos.size() > 0) {
				queryFactory.batchSaveOrUpdate(cailiaos);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(new ExceptionResponse(-1, e.getMessage()));
		}

	}

	@Override
	public CbhsHt htAdd(CbhsHt ht, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(StringUtils.isNotBlank(ht.getHtName()), "合同名称不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.fbCompany, BeanValidation.valiType.all, ht.getFbCompanyOid());
		Preconditions.checkArgument(
				!queryFactory.exists(QCbhsHt.cbhsHt, QCbhsHt.cbhsHt.htName.eq(ht.getHtName().trim()).and(QCbhsHt.cbhsHt.status.eq(true).and(QCbhsHt.cbhsHt.fbCompanyOid.eq(ht.getFbCompanyOid())))),
				"该分包商合同名称已存在!");
		ht = queryFactory.saveOrUpdate(ht);
		return ht;
	}

	@Override
	public CbhsHt htUpdate(CbhsHt ht, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(ht.getOid() != null, "合同ID不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(ht.getHtName()), "合同名称不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.fbCompany, BeanValidation.valiType.all, ht.getFbCompanyOid());
		Preconditions.checkArgument(
				!queryFactory.exists(
						QCbhsHt.cbhsHt,
						QCbhsHt.cbhsHt.htName.eq(ht.getHtName().trim()).and(
								QCbhsHt.cbhsHt.status.eq(true).and(QCbhsHt.cbhsHt.fbCompanyOid.eq(ht.getFbCompanyOid()).and(QCbhsHt.cbhsHt.oid.ne(ht.getOid()))))), "该分包商合同名称已存在!");
		ht = queryFactory.saveOrUpdate(ht);
		return ht;
	}

	@Override
	public JSONObject htDel(RequestHtDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "合同ID不能为空!");
		queryFactory.update(QCbhsHt.cbhsHt).set(QCbhsHt.cbhsHt.status, false).where(QCbhsHt.cbhsHt.oid.in(request.getOids())).execute();
		return CbhsResUtils.suc();
	}

	@Override
	public ResponseHtFetch htFetch(RequestHtFetch request, HttpServletRequest httpServletRequest) throws Exception {
		QCbhsHt query_ = QCbhsHt.cbhsHt;
		// 查询对象
		MyJPAQuery<CbhsHt> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getName(), query_.htName.containsIgnoreCase(request.getName()));
		jpaquery.where(request.getStatus(), query_.status.eq(request.getStatus()));
		jpaquery.where(request.getFbCompanyId(), query_.fbCompanyOid.eq(request.getFbCompanyId()));
		jpaquery.where(request.getFbCompanyName(), query_.fbCompanyName.containsIgnoreCase(request.getFbCompanyName()));
		jpaquery.where(request.getHtId(), query_.htId.containsIgnoreCase(request.getHtId()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseHtFetch response = new ResponseHtFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		return response;
	}
}
