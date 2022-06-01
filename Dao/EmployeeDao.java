package com.Employee.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.Employee.Bean.Employee;
import com.Employee.Bean.FetchEmployeeDetailsDto;
import com.Employee.Bean.FetchEmployeeNmReq;


@Repository
public interface EmployeeDao {

	Boolean insertEmployeeDetailsUsingMap(Employee insertEmployeeRequest);
	Boolean insertEmployeeDetailsUsingSqlParameterSource(Employee insertEmployeeRequest);
	Boolean insertEmployeeDetailsUsingBeanPropertySqlParameterSource(Employee insertEmployeeRequest);

	
	Boolean insertEmployeeDetails(Employee insertEmployeeRequest);
	Boolean updateEmployeeDetailsUsingMap(Employee updateEmployeeRequest, Long empId);
	Boolean updateEmployeeDetailsUsingSqlParameterSource(Employee updateEmployeeRequest);

	Boolean insertEmployeeInBatch(Employee insertEmployeeRequest);
	Boolean EmployeesDetailsinBatch(List<Employee> insertEmployeeRequestList);
	
	
	public String fetchEmployeeNameByEmpIdUsingObject(FetchEmployeeNmReq fetchEmployeeRequest);
	public FetchEmployeeDetailsDto fetchEmployeeNameByEmpIdUsingMap(FetchEmployeeNmReq fetchEmployeeRequest);
	public List<FetchEmployeeDetailsDto> fetchAllEmployeesUsingList(FetchEmployeeDetailsDto fetchEmployeeRequest);
	public List<FetchEmployeeDetailsDto> fetchAllEmployeeDetails(FetchEmployeeDetailsDto fetchEmployeeRequest);
	
}
