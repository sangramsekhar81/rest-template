package com.rest.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.demo.model.Employee;
import com.rest.demo.service.EmployeeService;

@RestController
public class EmployeeResource {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping
	public String saveEmployee(@RequestBody Employee employee) {
	   return employeeService.saveEmp(employee);	
	}
	
	@GetMapping("/get")
	public List<Employee> getAll(){
		return employeeService.getAll();
	}

}
