package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		
		System.out.println(System.getProperty("user.dir"));
		ClassPathXmlApplicationContext context 
		= new ClassPathXmlApplicationContext("beanLifecycleApplicationContext.xml");
		
		Coach theCoach      = context.getBean("myCoach", Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		context.close();

	}

}
