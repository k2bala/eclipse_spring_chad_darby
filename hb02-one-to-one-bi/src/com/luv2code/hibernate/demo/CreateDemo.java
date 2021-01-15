package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//create and associate objects
			Instructor instructor = new Instructor("Bala","Kendai","bken@email.com");
			InstructorDetail detail = new InstructorDetail("none","lenonearn");
			instructor.setInstructorDetail(detail);
			
			session.beginTransaction();
			session.save(instructor);
			session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
