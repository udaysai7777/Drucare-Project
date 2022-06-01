package com.Bank.Bean;

import java.util.List;

public class FetchEmployeeNmReq {
	private Long empId;
	private Long orgId;
	private Boolean isActive;
	
	public FetchEmployeeNmReq(Long empId, Long orgId, Boolean isActive) {
		super();
		this.empId = empId;
		this.orgId = orgId;
		this.isActive = isActive;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public Long getOrgId() {
		return orgId;
	}
	public void setOrgId(Long orgId) {
		this.orgId = orgId;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "FetchEmployeeNmReq [empId=" + empId + ", orgId=" + orgId + ", isActive=" + isActive + "]";
	}
}
	
	