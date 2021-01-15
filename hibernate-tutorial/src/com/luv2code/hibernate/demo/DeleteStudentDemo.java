package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		try {
			int studentId = 1002;
			Session session = factory.getCurrentSession();
//			session.beginTransaction();
//			Student myStudent = session.get(Student.class, studentId);
//			System.out.println("Retrieved " + myStudent);
//			session.delete(myStudent);
//			session.getTransaction().commit();

//			session = factory.getCurrentSession();
			session.beginTransaction();
			session.createQuery("delete from Student where id = 1003").executeUpdate();

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
