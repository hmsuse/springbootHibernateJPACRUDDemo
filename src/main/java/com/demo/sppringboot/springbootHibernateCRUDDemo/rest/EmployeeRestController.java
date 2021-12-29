package com.demo.sppringboot.springbootHibernateCRUDDemo.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.sppringboot.springbootHibernateCRUDDemo.DAO.EmployeeDAO;
import com.demo.sppringboot.springbootHibernateCRUDDemo.entity.Employee;
import com.demo.sppringboot.springbootHibernateCRUDDemo.service.EmployeeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/employee")
	public List<Employee> getAllEmployees() {
		List<Employee> theEmployees = employeeService.findAll();
		return theEmployees;
	}

	@GetMapping(value = "/employee/{employeeId}")
	public Employee geemployeeById(@PathVariable("employeeId") int theId) {
		Employee theEmployee = employeeService.getById(theId);

		if (theEmployee == null) {
			throw new RuntimeException("The given id is not found in Database =>" + theId);

		}
		return theEmployee;

	}

	@PostMapping(value = "/employee")
	public Employee saveEmployee(@RequestBody Employee theEmployee) {
		// theEmployee.setId(0);

		employeeService.saveEmployee(theEmployee);
		return theEmployee;
	}

	@PutMapping(value = "/employee")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {

		employeeService.saveEmployee(theEmployee);
		return theEmployee;
	}

	@PutMapping(value = "/employee/{employeeId}")
	public Employee updateEmployeeByID(@RequestBody Employee theEmployee, @PathVariable("employeeId") int theId) {

		// option1
		/*
		  Employee employee= employeeService.getById(theId);
		  
		  if(employee !=null) {
		  
		  employee.setFirstName(theEmployee.getFirstName());
		  employee.setLastName(theEmployee.getLastName());
		  employee.setEmail(theEmployee.getEmail());
		  employeeService.saveEmployee(employee); }else { throw new
		  RuntimeException("Employee Id is not Exist in database "+theId); }
		 */
		//option 2
		employeeService.updateEmployeeById(theEmployee, theId);
		theEmployee.setId(theId);
		return theEmployee;
	}
	
	
	@DeleteMapping(value = "/employee/{employeeId}")
	public void deleteEmployeeById(@PathVariable("employeeId") int theId) {
		employeeService.deleteEmployee(theId);
		
	}

}
