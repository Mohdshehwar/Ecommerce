package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOimpl implements EmployeeDAO {
	
	
	
     private EntityManager entitymanager;
     @Autowired
	public EmployeeDAOimpl(EntityManager theEntityManager)
	{
		entitymanager=theEntityManager;
	}
	@Override
	//@Transactional
	public List<Employee> findAll() {
		Session currentSession=entitymanager.unwrap(Session.class);
	
		Query<Employee> theQuery=currentSession.createQuery("from Employee", Employee.class);
			
		List<Employee> employees=theQuery.getResultList();
		
		
		return employees;
	}
	@Override
	//@Transactional
	public Employee FindById(int theId) {
		Session currentSession=entitymanager.unwrap(Session.class);
		Employee theEmployee=currentSession.get(Employee.class, theId);
		
		return theEmployee;
	}
	@Override
	public Employee addEmployee(Employee theEmployee) {
		Session currentSession=entitymanager.unwrap(Session.class);
		currentSession.saveOrUpdate(theEmployee);
		return theEmployee;
		
	}
	@Override
	public void deleteById(int theId) {
		Session currentSession=entitymanager.unwrap(Session.class);
		Employee emp=currentSession.get(Employee.class,theId);
		currentSession.delete(emp);
	}
	

	
	
	
	
	
	
	
	
}
