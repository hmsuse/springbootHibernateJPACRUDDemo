package com.demo.sppringboot.springbootHibernateCRUDDemo.service;

import java.util.List;

import com.demo.sppringboot.springbootHibernateCRUDDemo.entity.Employee;

public interface EmployeeService {
	public List<Employee> findAll();
	public Employee getById(int theId);
	public void saveEmployee(Employee theEmployee);
	public void updateEmployeeById(Employee theEmployee ,int theId);
	public void deleteEmployee(int theID);


}
