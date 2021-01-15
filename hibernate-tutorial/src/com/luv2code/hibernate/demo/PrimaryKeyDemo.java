package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			Student student = new Student("Jo", "Kend", "jkend@ourl.com");
			Student student1 = new Student("Ind", "Kend", "ikend@ourl.com");
			Student student2 = new Student("Joy", "Kend", "ykend@ourl.com");
			session.beginTransaction();
			session.save(student);
			session.save(student1);
			session.save(student2);
			session.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
