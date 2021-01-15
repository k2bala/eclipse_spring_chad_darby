package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		try {
			int studentId = 1000;
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			Student myStudent = session.get(Student.class, studentId);
			System.out.println("Retrieved " + myStudent);
			myStudent.setDateOfBirth(DateUtils.parseDate("01/01/1901"));
			session.getTransaction().commit();

			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("update Student set email = 'foo@spring.net'").executeUpdate();

			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> students) {
		for (Student s : students) {
			System.out.println(s);
		}
	}

}
