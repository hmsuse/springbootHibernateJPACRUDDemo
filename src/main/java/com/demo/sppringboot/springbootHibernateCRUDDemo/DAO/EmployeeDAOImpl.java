package com.demo.sppringboot.springbootHibernateCRUDDemo.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.sppringboot.springbootHibernateCRUDDemo.entity.Employee;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	public EmployeeDAOImpl() {
		
	}

	private EntityManager entityManager;
	@Autowired
	public EmployeeDAOImpl(EntityManager theEntityManager){
		entityManager=theEntityManager;
		
	}
	
	@Override
	
	public List<Employee> findAll() {
		Session currentSession=entityManager.unwrap(Session.class);
	Query<Employee> theQuery=	currentSession.createQuery("from Employee",Employee.class);
List<Employee>employees=	theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee getById(int theId) {
		Session currentSession=entityManager.unwrap(Session.class);
	Employee theEmployee=	currentSession.get(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public void saveEmployee(Employee theEmployee) {
		
		Session currentSession=entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theEmployee);
		
	}

	@Override
	public void updateEmployeeById(Employee theEmployee, int theId) {
		Session currentSession=entityManager.unwrap(Session.class);
	Query theQuery=	currentSession.createQuery("from Employee  where id=:theId",Employee.class);
	theQuery.setParameter("theId", theId)	;
	Employee employee=(Employee) theQuery.getSingleResult();
	if(employee !=null) {
		employee.setId(theId);
		/*
		 * employee.setFirstName(theEmployee.getFirstName());
		 * employee.setLastName(theEmployee.getLastName());
		 * employee.setEmail(theEmployee.getEmail());
		 */
		employee.setName(theEmployee.getName());
		employee.setEmail(theEmployee.getEmail());
		employee.setPassword(theEmployee.getPassword());
		employee.setPassword(theEmployee.getMob());
		
	}else {
		throw new RuntimeException("Employee id is not exist in Database ===>"+theId);
	}
	
	currentSession.saveOrUpdate(employee);
	
	}

	@Override
	public void deleteEmployee(int theID) {
		Session currentSession=entityManager.unwrap(Session.class);
	Employee employee=	currentSession.get(Employee.class,theID);
	
	currentSession.delete(employee);
		
	}

}
