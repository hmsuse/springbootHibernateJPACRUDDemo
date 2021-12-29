package com.demo.sppringboot.springbootHibernateCRUDDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.sppringboot.springbootHibernateCRUDDemo.DAO.EmployeeDAO;
import com.demo.sppringboot.springbootHibernateCRUDDemo.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDAO;
	
	 public EmployeeServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	 @Autowired
	 public EmployeeServiceImpl(@Qualifier("employeeDAOJPAImpl")EmployeeDAO theEmployeeDAO) {
		 employeeDAO=theEmployeeDAO; 
		 
	 }
	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee getById(int theId) {
		// TODO Auto-generated method stub
		return employeeDAO.getById(theId);
	}

	@Override
	@Transactional
    public void saveEmployee(Employee theEmployee) {
		
		employeeDAO.saveEmployee(theEmployee);
		
	}

	@Override
	@Transactional
	public void updateEmployeeById(Employee theEmployee, int theId) {
		employeeDAO.updateEmployeeById(theEmployee, theId);
	}

	@Override
	@Transactional
	public void deleteEmployee(int theID) {
		employeeDAO.deleteEmployee(theID);
		
	}

}
