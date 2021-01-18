package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateCoursesDemo {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//create and associate objects
			session.beginTransaction();
			Instructor tempInstructor = session.get(Instructor.class, 1);
			Course course1 = new Course("Spring boot");
			Course course2 = new Course("Spring security");
			tempInstructor.addCourse(course1);
			tempInstructor.addCourse(course2);
			
			session.save(course1);
			session.save(course2);
			
			session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
		
	}

}
