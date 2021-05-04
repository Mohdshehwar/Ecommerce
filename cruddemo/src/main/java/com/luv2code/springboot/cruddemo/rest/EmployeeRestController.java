package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
@Autowired
   private EmployeeService employeeService;
	
	
	
	@GetMapping("/employees")
	public List<Employee> getAll()
	{
		
		return employeeService.findAll();
	}
	@GetMapping("/employees/{employeeId}")
	public Employee getById (@PathVariable int employeeId )
	{
		return employeeService.FindById(employeeId);
	}
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee)
	{
		theEmployee.setId(0);
		
		return employeeService.addEmployee(theEmployee);
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee)
	{
		return employeeService.addEmployee(theEmployee);
	}
	
	
	@DeleteMapping("/employees/{theId}")
	public void delete(@PathVariable int theId)
	{
		employeeService.deleteById(theId);
	}
	
}
