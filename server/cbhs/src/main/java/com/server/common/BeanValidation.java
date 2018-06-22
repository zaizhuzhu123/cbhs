package com.server.common;

import com.google.common.base.Preconditions;
import com.server.jpa.MyQueryFactory;
import com.server.pojo.bean.QCbhsCailiao;
import com.server.pojo.bean.QCbhsCailiaoKemu;
import com.server.pojo.bean.QCbhsDept;
import com.server.pojo.bean.QCbhsFbCompany;
import com.server.pojo.bean.QCbhsHt;
import com.server.pojo.bean.QCbhsMachinery;
import com.server.pojo.bean.QCbhsMachineryType;
import com.server.pojo.bean.QCbhsProject;

/**
 * 提取的工具类 用于Bean类依赖属性缺失 以及数据库是否存在的校验
 * 
 * @ClassName: BeanValidation
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 青明锋
 * @date 2018年5月6日 下午12:14:26
 *
 */
public class BeanValidation {
	// 校验的类型 beanType
	public static enum beanType {
		project, dept, cailiaoKemu, cailiao, fbCompany, machineryType, machinery, ht;
	}

	// 校验查方式 valiType
	public static enum valiType {
		all, notNull, exsit
	}

	// 操作数据库
	private MyQueryFactory queryFactory;

	public BeanValidation(MyQueryFactory queryFactory) {
		this.queryFactory = queryFactory;
	}

	@SuppressWarnings("incomplete-switch")
	public BeanValidation vali(beanType beanType, valiType valiType, Integer id) {
		switch (beanType) {
		case project:
			switch (valiType) {
			case notNull:
				Preconditions.checkArgument(id != null, "工程项目ID不能为空!");
				break;
			case all:
				Preconditions.checkArgument(id != null, "工程项目ID不能为空!");
				Preconditions.checkArgument(queryFactory.exists(QCbhsProject.cbhsProject, QCbhsProject.cbhsProject.oid.eq(id)), "工程项目不存在!");
			}
			break;
		case dept:
			switch (valiType) {
			case notNull:
				Preconditions.checkArgument(id != null, "部门ID不能为空!");
				break;
			case all:
				Preconditions.checkArgument(id != null, "部门ID不能为空!");
				Preconditions.checkArgument(queryFactory.exists(QCbhsDept.cbhsDept, QCbhsDept.cbhsDept.oid.eq(id).and(QCbhsDept.cbhsDept.status.eq(true))), "部门不存在!");
			}
			break;
		case cailiaoKemu:
			switch (valiType) {
			case notNull:
				Preconditions.checkArgument(id != null, "材料科目ID不能为空!");
				break;
			case all:
				Preconditions.checkArgument(id != null, "材料科目ID不能为空!");
				Preconditions.checkArgument(queryFactory.exists(QCbhsCailiaoKemu.cbhsCailiaoKemu, QCbhsCailiaoKemu.cbhsCailiaoKemu.oid.eq(id).and(QCbhsCailiaoKemu.cbhsCailiaoKemu.status.eq(true))),
						"材料科目不存在!");
			}
			break;
		case cailiao:
			switch (valiType) {
			case notNull:
				Preconditions.checkArgument(id != null, "材料ID不能为空!");
				break;
			case all:
				Preconditions.checkArgument(id != null, "材料ID不能为空!");
				Preconditions.checkArgument(queryFactory.exists(QCbhsCailiao.cbhsCailiao, QCbhsCailiao.cbhsCailiao.oid.eq(id).and(QCbhsCailiao.cbhsCailiao.status.eq(true))), "材料不存在!");
			}
			break;
		case fbCompany:
			switch (valiType) {
			case notNull:
				Preconditions.checkArgument(id != null, "分包商ID不能为空!");
				break;
			case all:
				Preconditions.checkArgument(id != null, "分包商ID不能为空!");
				Preconditions.checkArgument(queryFactory.exists(QCbhsFbCompany.cbhsFbCompany, QCbhsFbCompany.cbhsFbCompany.oid.eq(id).and(QCbhsFbCompany.cbhsFbCompany.status.eq(true))), "分包商不存在!");
			}
			break;
		case machineryType:
			switch (valiType) {
			case notNull:
				Preconditions.checkArgument(id != null, "机械设备种类ID不能为空!");
				break;
			case all:
				Preconditions.checkArgument(id != null, "机械设备种类ID不能为空!");
				Preconditions.checkArgument(
						queryFactory.exists(QCbhsMachineryType.cbhsMachineryType, QCbhsMachineryType.cbhsMachineryType.oid.eq(id).and(QCbhsMachineryType.cbhsMachineryType.status.eq(true))),
						"机械设备种类不存在!");
			}
			break;
		case machinery:
			switch (valiType) {
			case notNull:
				Preconditions.checkArgument(id != null, "机械设备ID不能为空!");
				break;
			case all:
				Preconditions.checkArgument(id != null, "机械设备ID不能为空!");
				Preconditions.checkArgument(queryFactory.exists(QCbhsMachinery.cbhsMachinery, QCbhsMachinery.cbhsMachinery.oid.eq(id).and(QCbhsMachinery.cbhsMachinery.status.eq(true))), "机械设备不存在!");
			}
			break;
		case ht:
			switch (valiType) {
			case notNull:
				Preconditions.checkArgument(id != null, "合同ID不能为空!");
				break;
			case all:
				Preconditions.checkArgument(id != null, "合同ID不能为空!");
				Preconditions.checkArgument(queryFactory.exists(QCbhsHt.cbhsHt, QCbhsHt.cbhsHt.oid.eq(id).and(QCbhsHt.cbhsHt.status.eq(true))), "合同不存在!");
			}
			break;
		default:
			break;
		}
		// 返回自己 支持链式写法
		return this;
	}

	public BeanValidation valiMonth(String monthStr, Long MonthTimeStamp) {

		return this;
	}
}
