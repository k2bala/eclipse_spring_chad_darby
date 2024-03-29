package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class GetCourseForStudentsDemo {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			//create and associate objects
			session.beginTransaction();
			Student tempStudent = session.get(Student.class, 1);
			System.out.println("Retrieved student: " + tempStudent);
			System.out.println("\tCourse: " + tempStudent.getCourses());
			session.getTransaction().commit();
			session.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
		
	}

}
