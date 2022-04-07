package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

	// define entity manager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public EmployeeDAOHibernateImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		// get session
		Session session = entityManager.unwrap(Session.class);
		// create and execute query
		Query<Employee> query = session.createQuery("from Employee", Employee.class);
		List<Employee> resultList = query.getResultList();
		// return result list
		return resultList;
	}

	@Override
	public Employee findById(int theId) {
		// get session
		Session session = entityManager.unwrap(Session.class);
		Employee employee = session.get(Employee.class, theId);

		return employee;
	}

	@Override
	public void save(Employee employee) {
		// get session
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
	}

	@Override
	public void deleteById(int theId) {
		Session session = entityManager.unwrap(Session.class);
		Query<Employee> query = session.createQuery("delete from Employee where id = :employeeId");
		query.setParameter("employeeId", theId);
		query.executeUpdate();
	}

}
