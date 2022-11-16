package com.rest.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rest.demo.model.Employee;

@Service
public class EmployeeService {
	
	private RestTemplate restTemplate;
	
	@Autowired
	public EmployeeService(RestTemplateBuilder restTemplateBuilder) {
		super();
		this.restTemplate = restTemplateBuilder.build();
	}



	public String saveEmp(Employee employee) {
		HttpEntity<Employee> entity = new HttpEntity<>(employee);
		return restTemplate.exchange("http://localhost:8080/api/employees", HttpMethod.POST, entity, String.class).getBody();
	}
	
	public List<Employee> getAll(){
		return restTemplate.exchange("http://localhost:8080/api/employees/get", HttpMethod.GET, null, List.class).getBody();
	}
	

}
