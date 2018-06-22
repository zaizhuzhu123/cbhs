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
import org.joda.time.DateTime;
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
import com.server.common.BeanValidation;
import com.server.common.CbhsResUtils;
import com.server.common.TokenUtils;
import com.server.exception.ExceptionResponse;
import com.server.exception.ServiceException;
import com.server.handler.GlobalYsApisService;
import com.server.jpa.MyJPAQuery;
import com.server.jpa.MyJPAQuery.PagerResult;
import com.server.jpa.MyQueryFactory;
import com.server.pojo.bean.CbhsGclQdXm;
import com.server.pojo.bean.CbhsGclQdYs;
import com.server.pojo.bean.CbhsGlobalFyzYs;
import com.server.pojo.bean.CbhsGlobalRcjzhlYs;
import com.server.pojo.bean.QCbhsGclQdXm;
import com.server.pojo.bean.QCbhsGclQdYs;
import com.server.pojo.bean.QCbhsGlobalFyzYs;
import com.server.pojo.bean.QCbhsGlobalRcjzhlYs;
import com.server.pojo.url.globalYs.RequestGlobalFyzYsDel;
import com.server.pojo.url.globalYs.RequestGlobalFyzYsFetch;
import com.server.pojo.url.globalYs.RequestGlobalGclYsDel;
import com.server.pojo.url.globalYs.RequestGlobalGclYsFetch;
import com.server.pojo.url.globalYs.RequestGlobalRcjzhlYsDel;
import com.server.pojo.url.globalYs.RequestGlobalRcjzhlYsFetch;
import com.server.pojo.url.globalYs.ResponseGlobalFyzYsFetch;
import com.server.pojo.url.globalYs.ResponseGlobalGclYsFetch;
import com.server.pojo.url.globalYs.ResponseGlobalRcjzhlYsFetch;
import com.server.util.ExcelUtils;
import com.server.util.ExceptionConstant;
import com.server.util.FileFormatUtils;

@SuppressWarnings({ "unchecked", "rawtypes" })
@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, timeout = 60)
public class GlobalYsApisServiceImp implements GlobalYsApisService {
	@Autowired
	private MyQueryFactory queryFactory;

	@Override
	@CacheEvict(cacheNames = "CbhsGclQdYs", allEntries = true)
	public CbhsGclQdYs globalGclYsAdd(CbhsGclQdYs ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(StringUtils.isNotBlank(ys.getName()), "预算项目名称不能为空!");
		Preconditions.checkArgument(StringUtils.isBlank(ys.getNodeId()), "预算项目序号不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		long time = System.currentTimeMillis();
		DateTime dt = new DateTime(time);
		ys.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
		ys.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
		ys.setOpTimeStr(dt.toString("yyyy-MM-dd HH:mm:ss"));
		ys.setOpTime(time);
		ys = queryFactory.saveOrUpdate(ys);
		return ys;
	}

	@Override
	@Cacheable(cacheNames = "CbhsGclQdYs", keyGenerator = "myKeyGenerator")
	public ResponseGlobalGclYsFetch globalGclYsFetch(RequestGlobalGclYsFetch request, HttpServletRequest httpServletRequest) throws Exception {
		QCbhsGclQdYs query_ = QCbhsGclQdYs.cbhsGclQdYs;
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		// 查询对象
		MyJPAQuery<CbhsGclQdYs> jpaquery = queryFactory.selectFrom(query_);
		MyJPAQuery<BigDecimal> jpaqueryPrice = (MyJPAQuery<BigDecimal>) queryFactory.select(query_.totaPrice.sum()).from(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getName(), query_.name.containsIgnoreCase(request.getName()));
		jpaquery.where(request.getNodeId(), query_.nodeId.eq(request.getNodeId()));
		jpaquery.where(query_.isGlobal.eq(true));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		if (request.getType() != null && request.getType().intValue() > 0) {
			switch (request.getType()) {
			case 1:
				jpaquery.where(query_.pNodeId.eq("0"));
				break;
			case 2:
				jpaquery.where(query_.unitPrice.gt(0.00));
				break;
			}
		}
		// ----------
		jpaqueryPrice.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaqueryPrice.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaqueryPrice.where(request.getName(), query_.name.containsIgnoreCase(request.getName()));
		jpaqueryPrice.where(request.getNodeId(), query_.nodeId.eq(request.getNodeId()));
		jpaqueryPrice.where(query_.isGlobal.eq(true));
		jpaqueryPrice.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		if (request.getType() != null && request.getType().intValue() > 0) {
			switch (request.getType()) {
			case 1:
				jpaqueryPrice.where(query_.pNodeId.eq("0"));
				break;
			case 2:
				jpaqueryPrice.where(query_.unitPrice.gt(0.00));
				break;
			}
		}
		// 查询总数
		ResponseGlobalGclYsFetch response = new ResponseGlobalGclYsFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		// 总费用
		BigDecimal priceTotal = jpaqueryPrice.fetchFirst();
		response.setPriceTotal(priceTotal);
		return response;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsGclQdYs", allEntries = true)
	public CbhsGclQdYs globalGclYsUpdate(CbhsGclQdYs ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(ys.getOid() > 0, "预算ID不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(ys.getName()), "预算名称不能为空!");
		ys.setIsGlobal(true);
		queryFactory.saveOrUpdate(ys);
		queryFactory.update(QCbhsGclQdXm.cbhsGclQdXm).set(QCbhsGclQdXm.cbhsGclQdXm.name, ys.getName()).set(QCbhsGclQdXm.cbhsGclQdXm.unit, ys.getUnit()).where(QCbhsGclQdXm.cbhsGclQdXm.nodeId.eq(ys.getNodeId()));
		return ys;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsGclQdYs", allEntries = true)
	public JSONObject globalGclYsDel(RequestGlobalGclYsDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "预算ID不能为空!");
		queryFactory.delete(QCbhsGclQdYs.cbhsGclQdYs, QCbhsGclQdYs.cbhsGclQdYs.oid.in(request.getOids()));
		return CbhsResUtils.suc();
	}

	@Override
	@CacheEvict(cacheNames = "CbhsGclQdYs", allEntries = true)
	public JSONObject globalGclYsImport(MultipartFile request, Integer projectOid, HttpServletRequest httpServletRequest) throws Exception {
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
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, projectOid);
		BatchInsertGclqdByExcel(request, projectOid, httpServletRequest);
		return CbhsResUtils.suc();
	}

	public boolean BatchInsertGclqdByExcel(MultipartFile file, Integer projectOid, HttpServletRequest httpServletRequest) {
		try {
			Workbook workbook = null;
			try {
				workbook = new XSSFWorkbook(file.getInputStream());
			} catch (Exception ex) {
				workbook = new HSSFWorkbook(file.getInputStream());
			}
			List<CbhsGclQdXm> globalXms = Lists.newArrayList();
			List<CbhsGclQdYs> globalyss = Lists.newArrayList();
			Sheet sheet = workbook.getSheetAt(0);
			int physicalNumberOfRows = sheet.getPhysicalNumberOfRows(); // 获得该sheet总行数
			for (int j = 0; j < physicalNumberOfRows; j++) {
				if (j < 2) { // 前两行是标题行
					continue;
				}
				Row row = sheet.getRow(j);
				// 项目
				CbhsGclQdXm globalXm = new CbhsGclQdXm();
				Cell cell = row.getCell(0);
				if (cell != null) {
					globalXm.setNodeId(ExcelUtils.getCellValue(cell));
				} else {
					globalXm.setNodeId("");
				}

				cell = row.getCell(1);
				if (cell != null) {
					globalXm.setName(ExcelUtils.getCellValue(cell));
				} else {
					globalXm.setName("");
				}

				if (StringUtils.isBlank(globalXm.getName()) || StringUtils.isBlank(globalXm.getNodeId())) {
					continue;
				}
				cell = row.getCell(2);
				if (cell != null) {

					globalXm.setUnit(ExcelUtils.getCellValue(cell));
				} else {
					globalXm.setUnit("");
				}
				if (StringUtils.isBlank(globalXm.getUnit())) {
					globalXm.setPNodeId("0");
				} else {
					int lastIndex = globalXm.getNodeId().lastIndexOf(".");
					if (lastIndex != -1) {
						globalXm.setPNodeId(globalXm.getNodeId().substring(0, lastIndex));
					}
				}
				globalXm.setStatus(true);
				globalXms.add(globalXm);
				// 预算
				CbhsGclQdYs globalys = new CbhsGclQdYs();
				long time = System.currentTimeMillis();
				DateTime dt = new DateTime(time);
				globalys.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
				globalys.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
				globalys.setOpTimeStr(dt.toString("yyyy-MM-dd HH:mm:ss"));
				globalys.setOpTime(time);
				globalys.setProjectOid(projectOid);
				globalys.setIsGlobal(true);
				globalys.setName(globalXm.getName());
				globalys.setNodeId(globalXm.getNodeId());
				globalys.setPNodeId(globalXm.getPNodeId());
				globalys.setUnit(globalXm.getUnit());

				cell = row.getCell(3);
				if (cell != null) {

					globalys.setCount(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					globalys.setCount(new BigDecimal(0.00));
				}
				cell = row.getCell(4);
				if (cell != null) {

					globalys.setUnitPrice(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					globalys.setUnitPrice(new BigDecimal(0.00));
				}
				cell = row.getCell(5);
				if (cell != null) {

					globalys.setTotaPrice(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					globalys.setTotaPrice(new BigDecimal(0.00));
				}
				Integer oid = queryFactory.select(QCbhsGclQdYs.cbhsGclQdYs.oid).from(QCbhsGclQdYs.cbhsGclQdYs).where(QCbhsGclQdYs.cbhsGclQdYs.nodeId.eq(globalys.getNodeId()).and(QCbhsGclQdYs.cbhsGclQdYs.projectOid.eq(projectOid))).fetchFirst();
				globalys.setOid(oid);
				globalyss.add(globalys);
			}
			// if (globalXms.size() > 0) {
			// queryFactory.batchSaveOrUpdate(globalXms);
			// }
			if (globalyss.size() > 0) {
				// 删除之前的所有清单
				// queryFactory.delete(QCbhsGclQdYs.cbhsGclQdYs).where(QCbhsGclQdYs.cbhsGclQdYs.projectOid.eq(projectOid).and(QCbhsGclQdYs.cbhsGclQdYs.isGlobal.eq(true))).execute();
				queryFactory.batchSaveOrUpdate(globalyss);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(new ExceptionResponse(-1, e.getMessage()));
		}

	}

	@Override
	@Cacheable(cacheNames = "CbhsGlobalRcjzhlYs", keyGenerator = "myKeyGenerator")
	public ResponseGlobalRcjzhlYsFetch globalRcjzhlYsFetch(RequestGlobalRcjzhlYsFetch request, HttpServletRequest httpServletRequest) throws Exception {
		QCbhsGlobalRcjzhlYs query_ = QCbhsGlobalRcjzhlYs.cbhsGlobalRcjzhlYs;
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		// 查询对象
		MyJPAQuery<CbhsGlobalRcjzhlYs> jpaquery = queryFactory.selectFrom(query_);
		MyJPAQuery<BigDecimal> jpaqueryPrice = (MyJPAQuery<BigDecimal>) queryFactory.select(query_.totaPrice.sum()).from(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getName(), query_.name.containsIgnoreCase(request.getName()));
		jpaquery.where(request.getNodeId(), query_.nodeId.eq(request.getNodeId()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// ------------
		jpaqueryPrice.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaqueryPrice.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaqueryPrice.where(request.getName(), query_.name.containsIgnoreCase(request.getName()));
		jpaqueryPrice.where(request.getNodeId(), query_.nodeId.eq(request.getNodeId()));
		jpaqueryPrice.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseGlobalRcjzhlYsFetch response = new ResponseGlobalRcjzhlYsFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		// 总费用
		BigDecimal priceTotal = jpaqueryPrice.fetchFirst();
		response.setPriceTotal(priceTotal);
		return response;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsGlobalRcjzhlYs", allEntries = true)
	public CbhsGlobalRcjzhlYs globalRcjzhlYsUpdate(CbhsGlobalRcjzhlYs ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(ys.getOid() > 0, "预算ID不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(ys.getName()), "预算名称不能为空!");
		queryFactory.saveOrUpdate(ys);
		return ys;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsGlobalRcjzhlYs", allEntries = true)
	public JSONObject globalRcjzhlYsDel(RequestGlobalRcjzhlYsDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "预算ID不能为空!");
		queryFactory.delete(QCbhsGlobalRcjzhlYs.cbhsGlobalRcjzhlYs, QCbhsGlobalRcjzhlYs.cbhsGlobalRcjzhlYs.oid.in(request.getOids()));
		return CbhsResUtils.suc();
	}

	@Override
	@CacheEvict(cacheNames = "CbhsGlobalRcjzhlYs", allEntries = true)
	public JSONObject globalRcjzhlYsImport(MultipartFile request, Integer projectOid, HttpServletRequest httpServletRequest) throws Exception {
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
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, projectOid);
		BatchInsertRcjzhlByExcel(request, projectOid, httpServletRequest);
		return CbhsResUtils.suc();
	}

	public boolean BatchInsertRcjzhlByExcel(MultipartFile file, Integer projectOid, HttpServletRequest httpServletRequest) {
		try {
			Workbook workbook = null;
			try {
				workbook = new XSSFWorkbook(file.getInputStream());
			} catch (Exception ex) {
				workbook = new HSSFWorkbook(file.getInputStream());
			}
			List<CbhsGlobalRcjzhlYs> zhlyss = Lists.newArrayList();
			Sheet sheet = workbook.getSheetAt(0);
			int physicalNumberOfRows = sheet.getPhysicalNumberOfRows(); // 获得该sheet总行数
			for (int j = 0; j < physicalNumberOfRows; j++) {
				if (j < 11) { // 前两行是标题行
					continue;
				}
				Row row = sheet.getRow(j);
				// 项目
				CbhsGlobalRcjzhlYs zhlys = new CbhsGlobalRcjzhlYs();
				long time = System.currentTimeMillis();
				DateTime dt = new DateTime(time);
				zhlys.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
				zhlys.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
				zhlys.setOpTimeStr(dt.toString("yyyy-MM-dd HH:mm:ss"));
				zhlys.setOpTime(time);
				zhlys.setProjectOid(projectOid);
				Cell cell = row.getCell(0);
				if (cell != null) {

					zhlys.setNodeId(ExcelUtils.getCellValue(cell));
				} else {
					zhlys.setNodeId("");
				}
				cell = row.getCell(1);
				if (cell != null) {

					zhlys.setName(ExcelUtils.getCellValue(cell));
				} else {
					zhlys.setName("");
				}
				cell = row.getCell(2);
				if (cell != null) {

					zhlys.setCount(ExcelUtils.getCellValue(cell));
				} else {
					zhlys.setCount("0.00");
				}
				cell = row.getCell(3);
				if (cell != null) {

					zhlys.setUnit(ExcelUtils.getCellValue(cell));
				} else {
					zhlys.setUnit("");
				}
				cell = row.getCell(4);
				if (cell != null) {

					zhlys.setTong(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					zhlys.setTong(new BigDecimal(0.00));
				}

				cell = row.getCell(5);
				if (cell != null) {

					zhlys.setR_zc(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					zhlys.setR_zc(new BigDecimal(0.00));
				}

				cell = row.getCell(6);
				if (cell != null) {

					zhlys.setR_rg(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					zhlys.setR_rg(new BigDecimal(0.00));
				}

				cell = row.getCell(7);
				if (cell != null) {

					zhlys.setR_jx(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					zhlys.setR_jx(new BigDecimal(0.00));
				}

				cell = row.getCell(8);
				if (cell != null) {

					zhlys.setR_qt(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					zhlys.setR_qt(new BigDecimal(0.00));
				}

				cell = row.getCell(9);
				if (cell != null) {

					zhlys.setR_unitHj(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					zhlys.setR_unitHj(new BigDecimal(0.00));
				}

				cell = row.getCell(10);
				if (cell != null) {

					zhlys.setTotaPrice(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					zhlys.setTotaPrice(new BigDecimal(0.00));
				}

				cell = row.getCell(12);
				if (cell != null) {

					zhlys.setC_cy(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					zhlys.setC_cy(new BigDecimal(0.00));
				}

				cell = row.getCell(13);
				if (cell != null) {

					zhlys.setC_zy(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					zhlys.setC_zy(new BigDecimal(0.00));
				}

				cell = row.getCell(14);
				if (cell != null) {

					zhlys.setC_fdlg(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					zhlys.setC_fdlg(new BigDecimal(0.00));
				}

				cell = row.getCell(15);
				if (cell != null) {

					zhlys.setC_tpzs(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					zhlys.setC_tpzs(new BigDecimal(0.00));
				}

				cell = row.getCell(16);
				if (cell != null) {

					zhlys.setC_gksn(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					zhlys.setC_gksn(new BigDecimal(0.00));
				}

				cell = row.getCell(17);
				if (cell != null) {

					zhlys.setC_sn(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					zhlys.setC_sn(new BigDecimal(0.00));
				}

				cell = row.getCell(18);
				if (cell != null) {

					zhlys.setC_fmh(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					zhlys.setC_fmh(new BigDecimal(0.00));
				}

				cell = row.getCell(19);
				if (cell != null) {

					zhlys.setC_sha(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					zhlys.setC_sha(new BigDecimal(0.00));
				}

				cell = row.getCell(20);
				if (cell != null) {

					zhlys.setC_shi(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					zhlys.setC_shi(new BigDecimal(0.00));
				}

				cell = row.getCell(21);
				if (cell != null) {

					zhlys.setC_shui(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					zhlys.setC_shui(new BigDecimal(0.00));
				}

				cell = row.getCell(22);
				if (cell != null) {

					zhlys.setC_wjj(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					zhlys.setC_wjj(new BigDecimal(0.00));
				}

				cell = row.getCell(23);
				if (cell != null) {

					zhlys.setC_nq(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					zhlys.setC_nq(new BigDecimal(0.00));
				}

				cell = row.getCell(24);
				if (cell != null) {

					zhlys.setC_gj(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					zhlys.setC_gj(new BigDecimal(0.00));
				}

				cell = row.getCell(25);
				if (cell != null) {

					zhlys.setRg_count(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					zhlys.setRg_count(new BigDecimal(0.00));
				}

				cell = row.getCell(26);
				if (cell != null) {

					zhlys.setJ_yyldz(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					zhlys.setJ_yyldz(new BigDecimal(0.00));
				}

				cell = row.getCell(27);
				if (cell != null) {

					zhlys.setJ_zxqc(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					zhlys.setJ_zxqc(new BigDecimal(0.00));
				}

				cell = row.getCell(28);
				if (cell != null) {

					zhlys.setJ_wjjyy(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					zhlys.setJ_wjjyy(new BigDecimal(0.00));
				}
				Integer oid = queryFactory.select(QCbhsGlobalRcjzhlYs.cbhsGlobalRcjzhlYs.oid).from(QCbhsGlobalRcjzhlYs.cbhsGlobalRcjzhlYs).where(QCbhsGlobalRcjzhlYs.cbhsGlobalRcjzhlYs.nodeId.eq(zhlys.getNodeId()).and(QCbhsGlobalRcjzhlYs.cbhsGlobalRcjzhlYs.projectOid.eq(projectOid))).fetchFirst();
				zhlys.setOid(oid);
				zhlyss.add(zhlys);
			}
			if (zhlyss.size() > 0) {
				// queryFactory.delete(QCbhsGlobalRcjzhlYs.cbhsGlobalRcjzhlYs).where(QCbhsGlobalRcjzhlYs.cbhsGlobalRcjzhlYs.projectOid.eq(projectOid)).execute();
				queryFactory.batchSaveOrUpdate(zhlyss);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(new ExceptionResponse(-1, e.getMessage()));
		}

	}

	@CacheEvict(cacheNames = "CbhsGlobalRcjzhlYs", allEntries = true)
	@Override
	public CbhsGlobalRcjzhlYs globalRcjzhlYsAdd(CbhsGlobalRcjzhlYs ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(StringUtils.isNotBlank(ys.getName()), "预算项目名称不能为空!");
		Preconditions.checkArgument(StringUtils.isBlank(ys.getNodeId()), "预算项目序号不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		long time = System.currentTimeMillis();
		DateTime dt = new DateTime(time);
		ys.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
		ys.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
		ys.setOpTimeStr(dt.toString("yyyy-MM-dd HH:mm:ss"));
		ys.setOpTime(time);
		ys = queryFactory.saveOrUpdate(ys);
		return ys;
	}

	@Override
	@Cacheable(cacheNames = "CbhsGlobalFyzYs", keyGenerator = "myKeyGenerator")
	public ResponseGlobalFyzYsFetch globalFyzYsFetch(RequestGlobalFyzYsFetch request, HttpServletRequest httpServletRequest) throws Exception {
		QCbhsGlobalFyzYs query_ = QCbhsGlobalFyzYs.cbhsGlobalFyzYs;
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		// 查询对象
		MyJPAQuery<CbhsGlobalFyzYs> jpaquery = queryFactory.selectFrom(query_);
		MyJPAQuery<BigDecimal> jpaqueryPrice = (MyJPAQuery<BigDecimal>) queryFactory.select(query_.totaPrice.sum()).from(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getName(), query_.name.containsIgnoreCase(request.getName()));
		jpaquery.where(request.getNodeId(), query_.nodeId.eq(request.getNodeId()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// -------
		jpaqueryPrice.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaqueryPrice.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaqueryPrice.where(request.getName(), query_.name.containsIgnoreCase(request.getName()));
		jpaqueryPrice.where(request.getNodeId(), query_.nodeId.eq(request.getNodeId()));
		jpaqueryPrice.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseGlobalFyzYsFetch response = new ResponseGlobalFyzYsFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		// 总费用
		BigDecimal priceTotal = jpaqueryPrice.fetchFirst();
		response.setPriceTotal(priceTotal);
		return response;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsGlobalFyzYs", allEntries = true)
	public CbhsGlobalFyzYs globalFyzYsUpdate(CbhsGlobalFyzYs ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(ys.getOid() > 0, "预算ID不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(ys.getName()), "预算名称不能为空!");
		queryFactory.saveOrUpdate(ys);
		return ys;
	}

	@Override
	@CacheEvict(cacheNames = "CbhsGlobalFyzYs", allEntries = true)
	public JSONObject globalFyzYsDel(RequestGlobalFyzYsDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "预算ID不能为空!");
		queryFactory.delete(QCbhsGlobalFyzYs.cbhsGlobalFyzYs, QCbhsGlobalFyzYs.cbhsGlobalFyzYs.oid.in(request.getOids()));
		return CbhsResUtils.suc();
	}

	@Override
	@CacheEvict(cacheNames = "CbhsGlobalFyzYs", allEntries = true)
	public JSONObject globalFyzYsImport(MultipartFile request, Integer projectOid, HttpServletRequest httpServletRequest) throws Exception {
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
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, projectOid);
		// if (queryFactory.exists(QCbhsGlobalFyzYs.cbhsGlobalFyzYs,
		// QCbhsGlobalFyzYs.cbhsGlobalFyzYs.projectOid.eq(projectOid))) {
		// throw new ServiceException(new ExceptionResponse(-1,
		// "每个项目的总费用清单只能导入一次!"));
		// }
		BatchInsertFyzysByExcel(request, projectOid, httpServletRequest);
		return CbhsResUtils.suc();
	}

	@Override
	@CacheEvict(cacheNames = "CbhsGlobalFyzYs", allEntries = true)
	public CbhsGlobalFyzYs globalFyzYsAdd(CbhsGlobalFyzYs ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(StringUtils.isNotBlank(ys.getName()), "项目名称不能为空!");
		Preconditions.checkArgument(StringUtils.isBlank(ys.getNodeId()), "项目序号不能为空!");
		long time = System.currentTimeMillis();
		DateTime dt = new DateTime(time);
		ys.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
		ys.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
		ys.setOpTimeStr(dt.toString("yyyy-MM-dd HH:mm:ss"));
		ys.setOpTime(time);
		ys = queryFactory.saveOrUpdate(ys);
		return ys;
	}

	public boolean BatchInsertFyzysByExcel(MultipartFile file, Integer projectOid, HttpServletRequest httpServletRequest) {
		try {
			Workbook workbook = null;
			try {
				workbook = new XSSFWorkbook(file.getInputStream());
			} catch (Exception ex) {
				workbook = new HSSFWorkbook(file.getInputStream());
			}
			List<CbhsGlobalFyzYs> cbhsGlobalFyzYss = Lists.newArrayList();
			Sheet sheet = workbook.getSheetAt(0);
			int physicalNumberOfRows = sheet.getPhysicalNumberOfRows(); // 获得该sheet总行数
			for (int j = 0; j < physicalNumberOfRows; j++) {
				if (j < 4) { // 前两行是标题行
					continue;
				}
				Row row = sheet.getRow(j);
				// 项目
				CbhsGlobalFyzYs cbhsGlobalFyzYs = new CbhsGlobalFyzYs();
				cbhsGlobalFyzYs.setProjectOid(projectOid);

				long time = System.currentTimeMillis();
				DateTime dt = new DateTime(time);
				cbhsGlobalFyzYs.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
				cbhsGlobalFyzYs.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
				cbhsGlobalFyzYs.setOpTimeStr(dt.toString("yyyy-MM-dd HH:mm:ss"));
				cbhsGlobalFyzYs.setOpTime(time);
				Cell cell = row.getCell(0);
				if (cell != null) {

					cbhsGlobalFyzYs.setNodeId(ExcelUtils.getCellValue(cell));
				} else {
					cbhsGlobalFyzYs.setNodeId("");
				}

				cell = row.getCell(1);
				if (cell != null) {

					cbhsGlobalFyzYs.setName(ExcelUtils.getCellValue(cell));
				} else {
					cbhsGlobalFyzYs.setName("");
				}

				if (StringUtils.isBlank(cbhsGlobalFyzYs.getName()) || StringUtils.isBlank(cbhsGlobalFyzYs.getNodeId())) {
					continue;
				}
				cell = row.getCell(2);
				if (cell != null) {

					cbhsGlobalFyzYs.setTotaPrice(StringUtils.isNotBlank(ExcelUtils.getCellValue(cell)) ? new BigDecimal(ExcelUtils.getCellValue(cell)) : new BigDecimal(0.00));
				} else {
					cbhsGlobalFyzYs.setTotaPrice(new BigDecimal(0.00));
				}
				cell = row.getCell(3);
				if (cell != null) {

					cbhsGlobalFyzYs.setRemark(ExcelUtils.getCellValue(cell));
				} else {
					cbhsGlobalFyzYs.setRemark("");
				}
				Integer oid = queryFactory.select(QCbhsGlobalFyzYs.cbhsGlobalFyzYs.oid).from(QCbhsGlobalFyzYs.cbhsGlobalFyzYs).where(QCbhsGlobalFyzYs.cbhsGlobalFyzYs.nodeId.eq(cbhsGlobalFyzYs.getNodeId()).and(QCbhsGlobalFyzYs.cbhsGlobalFyzYs.projectOid.eq(projectOid))).fetchFirst();
				cbhsGlobalFyzYs.setOid(oid);
				cbhsGlobalFyzYss.add(cbhsGlobalFyzYs);
			}
			if (cbhsGlobalFyzYss.size() > 0) {
				// queryFactory.delete(QCbhsGlobalFyzYs.cbhsGlobalFyzYs).where(QCbhsGlobalFyzYs.cbhsGlobalFyzYs.projectOid.eq(projectOid)).execute();
				queryFactory.batchSaveOrUpdate(cbhsGlobalFyzYss);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServiceException(new ExceptionResponse(-1, e.getMessage()));
		}

	}
}
