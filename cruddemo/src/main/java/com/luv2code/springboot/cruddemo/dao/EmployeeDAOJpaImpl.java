package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	// define entity manager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		Query query = entityManager.createQuery("from Employee");
		List<Employee> employeeList  = query.getResultList();
		return employeeList;
	}

	@Override
	public Employee findById(int theId) {
		return entityManager.find(Employee.class, theId);
	}

	@Override
	public void save(Employee employee) {
		Employee employeeSaved = entityManager.merge(employee);
		employee.setId(employeeSaved.getId());
	}

	@Override
	public void deleteById(int theId) {
		Query query = entityManager.createQuery("delete from Employee where id = :employeeId");
		query.setParameter("employeeId", theId);
		query.executeUpdate();
	}

}
