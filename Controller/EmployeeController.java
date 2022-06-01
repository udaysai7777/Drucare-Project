package com.Employee.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.Bean.Employee;
import com.Employee.Bean.FetchEmployeeDetailsDto;
import com.Employee.Bean.FetchEmployeeNmReq;
import com.Employee.Service.EmployeeService;

@RestController

public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@PostMapping("/insertEmployeeDetailsUsingMap")
	Boolean insertEmployeeDetailsUsingMap(@RequestBody Employee insertEmployeeRequest) {
		return employeeService.insertEmployeeDetailsUsingMap(insertEmployeeRequest);
	}

	@PostMapping("/insertEmployeeDetailsUsingSqlParameterSource")
	Boolean insertEmployeeDetailsUsingSqlParameterSource(@RequestBody Employee insertEmployeeRequest) {
		return employeeService.insertEmployeeDetailsUsingSqlParameterSource(insertEmployeeRequest);
	}

	@PostMapping("/insertEmployeeDetailsUsingBeanPropertySqlParameterSource")
	Boolean insertEmployeeDetailssingBeanPropertySqlParameterSource(@RequestBody Employee insertEmployeeRequest) {
		return employeeService.insertEmployeeDetailsUsingBeanPropertySqlParameterSource(insertEmployeeRequest);
	}

	@PutMapping("/updateEmployeeDetailsUsingMap")
	Boolean updateEmployeeDetailsUsingMap(@RequestBody Employee updateEmployeeRequest, Long empId) {
		return employeeService.updateEmployeeDetailsUsingMap(updateEmployeeRequest, empId);
	}

	@PutMapping("/updateEmployeeDetailsUsingSqlParameterSource")
	Boolean updateEmployeeDetailsUsingSqlParameterSource(@RequestBody Employee updateEmployeeRequest) {
		return employeeService.updateEmployeeDetailsUsingSqlParameterSource(updateEmployeeRequest);
	}

	@PostMapping("/insertEmployeeDetails")

	Boolean  insertEmployeeDetails(@RequestBody Employee insertEmployeeRequest){
		return employeeService.insertEmployeeDetails(insertEmployeeRequest);
	}
@PutMapping("/insertEmployeeinBatch")
     Boolean insertEmployeeInBatch(@RequestBody Employee insertEmployeeRequest) {
	  return employeeService.insertEmployeeInBatch(insertEmployeeRequest);
			  
}
@PutMapping("/insertEmployeeDetailsinBatch")
       Boolean EmployeesDetailsinBatch(@RequestBody List<Employee> insertEmployeeRequestList) {
       return employeeService.EmployeesDetailsinBatch(insertEmployeeRequestList);
}
@GetMapping("/fetchEmployeeNameByEmpIdUsingObject")
String fetchEmployeeNameByEmpIdUsingObject(@RequestBody FetchEmployeeNmReq fetchEmployeeRequest) {
	return employeeService.fetchEmployeeNameByEmpIdUsingObject(fetchEmployeeRequest);
}
@GetMapping("/fetchEmployeeNameByEmpIdUsingMap")
public FetchEmployeeDetailsDto fetchEmployeeNameByEmpIdUsingMap(@RequestBody FetchEmployeeNmReq fetchEmployeeRequest) {
	return employeeService.fetchEmployeeNameByEmpIdUsingMap(fetchEmployeeRequest);
}
@GetMapping("/fetchAllEmployeesUsingList")
public List<FetchEmployeeDetailsDto> fetchAllEmployeesUsingList(@RequestBody FetchEmployeeDetailsDto fetchEmployeeRequest) {
	return employeeService.fetchAllEmployeesUsingList(fetchEmployeeRequest);
}
@GetMapping("/fetchAllEmployeeDetails")
public List<FetchEmployeeDetailsDto> fetchAllEmployeeDetails( @RequestBody FetchEmployeeDetailsDto fetchEmployeeRequest) {
	return employeeService.fetchAllEmployeeDetails(fetchEmployeeRequest);
}
}
