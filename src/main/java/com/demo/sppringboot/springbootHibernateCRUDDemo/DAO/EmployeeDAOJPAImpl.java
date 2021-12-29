package com.demo.sppringboot.springbootHibernateCRUDDemo.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.sppringboot.springbootHibernateCRUDDemo.entity.Employee;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeDAOJPAImpl(EntityManager theEntityManger) {
		entityManager = theEntityManger;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		TypedQuery<Employee> theQuery = (TypedQuery<Employee>) entityManager.createQuery("from Employee");
		List<Employee> theEmployees = theQuery.getResultList();
		return theEmployees;
	}

	@Override
	@Transactional
	public Employee getById(int theId) {
		Employee theEmployee = entityManager.find(Employee.class, theId);
		return theEmployee;
	}

	@Override
	@Transactional
	public void saveEmployee(Employee theEmployee) {
		entityManager.merge(theEmployee);
		theEmployee.setId(theEmployee.getId());

	}

	@Override
	@Transactional
	public void updateEmployeeById(Employee theEmployee, int theId) {
		Employee employee = entityManager.find(Employee.class, 1);
		if (employee != null) {
			theEmployee.setId(theId);
			entityManager.merge(theEmployee);

		}

	}

	@Override
	@Transactional
	public void deleteEmployee(int theID) {
		Query theQuery = entityManager.createQuery("delete Employee where id=:theId");
		theQuery.setParameter("theId", theID);

		theQuery.executeUpdate();

	}

}
