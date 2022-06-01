package com.Employee.Service;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.Employee.Bean.Employee;
//import com.Employee.Bean.InsertEmployeeRequest;
import com.Employee.Bean.FetchEmployeeDetailsDto;
import com.Employee.Bean.FetchEmployeeNmReq;


public interface EmployeeService {
	Boolean insertEmployeeDetailsUsingMap(Employee insertEmployeeRequest);
	Boolean insertEmployeeDetailsUsingSqlParameterSource(Employee insertEmployeeRequest);
	Boolean insertEmployeeDetailsUsingBeanPropertySqlParameterSource(Employee insertEmployeeRequest);
	
	
	Boolean updateEmployeeDetailsUsingMap(Employee updateEmployeeRequest, Long empId);
	 Boolean updateEmployeeDetailsUsingSqlParameterSource(Employee updateEmployeeRequest);
	 Boolean insertEmployeeDetails(Employee insertEmployeeRequest);
	 
	 Boolean insertEmployeeInBatch(Employee insertEmployeeRequest);
	 Boolean EmployeesDetailsinBatch(List<Employee> insertEmployeeRequestList);
	 
	 public String fetchEmployeeNameByEmpIdUsingObject(FetchEmployeeNmReq fetchEmployeeRequest);
	 public FetchEmployeeDetailsDto fetchEmployeeNameByEmpIdUsingMap(FetchEmployeeNmReq fetchEmployeeRequest);
	 public List<FetchEmployeeDetailsDto> fetchAllEmployeesUsingList(FetchEmployeeDetailsDto fetchEmployeeRequest) ;
	 public List<FetchEmployeeDetailsDto> fetchAllEmployeeDetails(FetchEmployeeDetailsDto fetchEmployeeRequest);
	 
	
}