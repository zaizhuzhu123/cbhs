package com.server.common;

public class SheObject {

	public static final int shType_Jjcb = 1; // 间接成本
	public static final int shType_glfycb = 2; // 管理费用
	public static final int shType_zylxyg = 3; // 零星用工
	public static final int shType_zyjxcb = 4; // 机械
	public static final int shType_qtcb = 5; // 其他费用
	public static final int shType_zycailiaocb = 6; // 自营材料
	public static final int shType_fbljxm = 7; // 临建项目
	public static final int shType_fbgcl = 8; // 分包工程量统计
	public static final int shType_zytj = 9; // 分包商统计
	public static final int shType_fbgcljg = 10; // 分包工程价格统计
	public static final int shType_zyjxcbry = 11; // 机械成本 燃油
	public static final int shType_zytjry = 12;// 资源统计 燃油
	public static final int shType_zytjzc = 13;// 资源统计 主材
	public static final int shType_ssd = 14;// 对下结算
	public static final int shType_reim = 15;// 财务报销
	public static final int shType_fbljxmcount = 16;// 分包临建项目 数量

	private String max; // 设定的最大值
	private String used; // 已使用的值
	private String this_; // 当前提交的值
	private String name; // 详细名称

	public String getMax() {
		return max;
	}

	public void setMax(String max) {
		this.max = max;
	}

	public String getUsed() {
		return used;
	}

	public void setUsed(String used) {
		this.used = used;
	}

	public String getThis_() {
		return this_;
	}

	public void setThis_(String this_) {
		this.this_ = this_;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SheObject(String max, String used, String this_, String name) {
		super();
		this.max = max;
		this.used = used;
		this.this_ = this_;
		this.name = name;
	}

	public SheObject() {
	}

}
