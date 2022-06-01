package com.Employee.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Employee.Bean.Employee;
import com.Employee.Bean.FetchEmployeeDetailsDto;
import com.Employee.Bean.FetchEmployeeNmReq;
import com.Employee.Dao.EmployeeDao;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao service;

	@Override
	public Boolean insertEmployeeDetailsUsingMap(Employee insertEmployeeRequest) {
		return service.insertEmployeeDetailsUsingMap(insertEmployeeRequest);
	}

	@Override
	public Boolean insertEmployeeDetailsUsingSqlParameterSource(Employee insertEmployeeRequest) {
		return service.insertEmployeeDetailsUsingSqlParameterSource(insertEmployeeRequest);
	}

	@Override
	public Boolean insertEmployeeDetailsUsingBeanPropertySqlParameterSource(Employee insertEmployeeRequest) {
		return service.insertEmployeeDetailsUsingBeanPropertySqlParameterSource(insertEmployeeRequest);
	}

	@Override
	public Boolean updateEmployeeDetailsUsingMap(Employee updateEmployeeRequest, Long empId) {
		return service.updateEmployeeDetailsUsingMap(updateEmployeeRequest, empId);
		
	}

	@Override
	public  Boolean updateEmployeeDetailsUsingSqlParameterSource(Employee updateEmployeeRequest) {
				return service.updateEmployeeDetailsUsingSqlParameterSource(updateEmployeeRequest);
	}
	
	@Override
	public Boolean insertEmployeeDetails(Employee insertEmployeeRequest) {
		return service.insertEmployeeDetails(insertEmployeeRequest);
	}


	@Override
	public Boolean insertEmployeeInBatch(Employee insertEmployeeRequest) {
		return service.insertEmployeeInBatch(insertEmployeeRequest);
	}

	@Override
	public Boolean EmployeesDetailsinBatch(List<Employee> insertEmployeeRequestList) {
		return service.EmployeesDetailsinBatch(insertEmployeeRequestList);
	}
	

@Override
public String fetchEmployeeNameByEmpIdUsingObject(FetchEmployeeNmReq fetchEmployeeRequest) {
	return service.fetchEmployeeNameByEmpIdUsingObject(fetchEmployeeRequest);
}
@Override
public FetchEmployeeDetailsDto fetchEmployeeNameByEmpIdUsingMap(FetchEmployeeNmReq fetchEmployeeRequest){
	return service.fetchEmployeeNameByEmpIdUsingMap(fetchEmployeeRequest);
}
public List<FetchEmployeeDetailsDto> fetchAllEmployeesUsingList(FetchEmployeeDetailsDto fetchEmployeeRequest){
	return service.fetchAllEmployeesUsingList(fetchEmployeeRequest);
}
public List<FetchEmployeeDetailsDto> fetchAllEmployeeDetails(FetchEmployeeDetailsDto fetchEmployeeRequest) {
	return service.fetchAllEmployeeDetails(fetchEmployeeRequest);
}

}