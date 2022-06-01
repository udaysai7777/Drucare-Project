package com.Bank.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Bank.Bean.Employee;
import com.Bank.Bean.FetchEmployeeNmReq;
import com.Bank.Service.EmployeeServiceImpl;
@RestController
@RequestMapping("/bank")
public class BankController{
	@Autowired
	EmployeeServiceImpl empService;
	
@GetMapping("/fetchEmployeeNameByEmpIdUsingMap")
public Employee fetchEmployeeNameByEmpIdUsingMap(@RequestBody FetchEmployeeNmReq fetchBankRequest) {
	return empService.fetchEmployeeNameByEmpIdUsingMap(fetchBankRequest);
}

@PostMapping("/insertEmployeeDetailsUsingMap")
Boolean insertEmployeeDetailsUsingMap(@RequestBody Employee insertEmployeeRequest) {
	return empService.insertEmployeeDetailsUsingMap(insertEmployeeRequest);
}

@GetMapping("/fetchEmployeeNameByEmpIdUsingObject")
public String fetchEmployeeNameByEmpIdUsingObject(@RequestBody FetchEmployeeNmReq fetchEmployeeRequest) {
	return empService.fetchEmployeeNameByEmpIdUsingObject(fetchEmployeeRequest);
}

@PutMapping("/updateEmployeeDetailsUsingSqlParameterSource")
public Boolean updateEmployeeDetailsUsingSqlParameterSource(@RequestBody Employee updateEmployeeRequest) {
	return empService.updateEmployeeDetailsUsingSqlParameterSource(updateEmployeeRequest);
}
}
//GetMapping("/fetchAllEmployeeDetails")
//public List<Employee> fetchAllEmployeeDetails( @RequestBody FetchEmployeeNmReq fetchEmployeeRequest) {
	//return empService.fetchAllEmployeeDetails(fetchEmployeeRequest);
//}
//}




