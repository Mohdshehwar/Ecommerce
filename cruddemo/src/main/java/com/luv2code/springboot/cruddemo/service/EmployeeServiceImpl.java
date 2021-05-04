package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
@Autowired
private EmployeeDAO employeeDao;
	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeDao.findAll();
	}

	@Override
	@Transactional
	public Employee FindById(int theId) {
		return employeeDao.FindById(theId);
	}

	@Override
	@Transactional
	public Employee addEmployee(Employee theEmployee) {
		
		employeeDao.addEmployee(theEmployee);
		return theEmployee;
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		employeeDao.deleteById(theId);
		
	}

}