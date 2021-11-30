package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			// create and associate objects
			session.beginTransaction();
			Query<Instructor> query = session.createQuery(
					"select i from Instructor i join FETCH i.courses where i.id = :theInstructorId", Instructor.class);
			query.setParameter("theInstructorId", 1);
			Instructor tempInstructor = query.getSingleResult();
			System.out.println("Retreieved instructor" + tempInstructor );
			session.getTransaction().commit();
			session.close();
			System.out.println("Courses" + tempInstructor.getCourses() );
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			factory.close();
		}

	}

}
