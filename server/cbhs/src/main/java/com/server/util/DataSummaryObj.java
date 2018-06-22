package com.server.util;

import java.util.List;

import com.server.common.DateObj;

public class DataSummaryObj {

	private Integer projectOid;
	private List<Integer> deptOids;
	private DateObj dt;
	private List<Integer> globalGclOids;

	public Integer getProjectOid() {
		return projectOid;
	}

	public void setProjectOid(Integer projectOid) {
		this.projectOid = projectOid;
	}

	public List<Integer> getDeptOids() {
		return deptOids;
	}

	public void setDeptOids(List<Integer> deptOids) {
		this.deptOids = deptOids;
	}

	public DateObj getDt() {
		return dt;
	}

	public void setDt(DateObj dt) {
		this.dt = dt;
	}

	public List<Integer> getGlobalGclOids() {
		return globalGclOids;
	}

	public void setGlobalGclOids(List<Integer> globalGclOids) {
		this.globalGclOids = globalGclOids;
	}

}
