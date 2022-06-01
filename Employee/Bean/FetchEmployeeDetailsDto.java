package com.Employee.Bean;

import java.util.List;

public class FetchEmployeeDetailsDto {
	private Long empId;
	private String lastNm;
	private String firstNm;
	private String middleNm;
	private Long empCode;
	private Long mobileNm;
	private String stateNm;
	private String countryNm;
	private String cityNm;
	private Long orgId;
	private Boolean isActive;
	private List<EmployeeDepartmentsXref> departmentList;
	private List<EmployeeDesignationXref> designationList;
	
	public List<EmployeeDepartmentsXref> getDepartmentList() {
		return departmentList;
	}
	public void setDepartmentList(List<EmployeeDepartmentsXref> departmentList) {
		this.departmentList = departmentList;
	}
	public List<EmployeeDesignationXref> getDesignationList() {
		return designationList;
	}
	public void setDesignationList(List<EmployeeDesignationXref> designationList) {
		this.designationList = designationList;
	}
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getLastNm() {
		return lastNm;
	}
	public void setLastNm(String lastNm) {
		this.lastNm = lastNm;
	}
	public String getFirstNm() {
		return firstNm;
	}
	public void setFirstNm(String firstNm) {
		this.firstNm = firstNm;
	}
	public String getMiddleNm() {
		return middleNm;
	}
	public void setMiddleNm(String middleNm) {
		this.middleNm = middleNm;
	}
	public Long getEmpCode() {
		return empCode;
	}
	public void setEmpCode(Long empCode) {
		this.empCode = empCode;
	}
	public Long getMobileNm() {
		return mobileNm;
	}
	public void setMobileNm(Long mobileNm) {
		this.mobileNm = mobileNm;
	}
	public String getStateNm() {
		return stateNm;
	}
	public void setStateNm(String stateNm) {
		this.stateNm = stateNm;
	}
	public String getCountryNm() {
		return countryNm;
	}
	public void setCountryNm(String countryNm) {
		this.countryNm = countryNm;
	}
	public String getCityNm() {
		return cityNm;
	}
	public void setCityNm(String cityNm) {
		this.cityNm = cityNm;
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
}
	
