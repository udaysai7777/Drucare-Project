package com.Bank.Bean;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDetails {
private List<Employee> employeeList;

public List<Employee> getEmployeeList() {
	return employeeList;
}

public void setEmployeeList(List<Employee> employeeList) {
	this.employeeList = employeeList;
}

public EmployeeDetails(List<Employee> employeeList) {
	this.employeeList=new ArrayList<>();
}


}
