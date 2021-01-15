package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Student student = new Student("Bala", "K", "bkend@ourl.com");
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
