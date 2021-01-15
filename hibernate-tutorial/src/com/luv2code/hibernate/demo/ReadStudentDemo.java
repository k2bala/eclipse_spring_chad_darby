package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			List<Student> students = session.createQuery("from Student").getResultList();
			displayStudents(students);
			
			students = session.createQuery("from Student s where s.lastName ='Kend' or s.firstName ='Jo' ").getResultList();
			displayStudents(students);
			
			students = session.createQuery("from Student s where  s.firstName like 'I%' ").getResultList();
			displayStudents(students);
			session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}
		
	}

	private static void displayStudents(List<Student> students) {
		for(Student s: students) {
			System.out.println(s);
		}
	}

}
