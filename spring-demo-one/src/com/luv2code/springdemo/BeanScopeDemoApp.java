package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		System.out.println(System.getProperty("user.dir"));
		ClassPathXmlApplicationContext context 
		= new ClassPathXmlApplicationContext("beansScopeApplicationContext.xml");
		
		Coach theCoach      = context.getBean("myCoach", Coach.class);
		Coach assitantCoach = context.getBean("myCoach", Coach.class);
		
		boolean result = (theCoach == assitantCoach);
		System.out.println("Comparision result of " + theCoach + " and " + assitantCoach + " is " + result);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		
		context.close();

	}

}
