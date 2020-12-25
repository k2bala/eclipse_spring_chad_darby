package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context 
		= new AnnotationConfigApplicationContext(SportConfig.class);
		
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		SwimCoach assitantCoach = context.getBean("swimCoach", SwimCoach.class);
		
		boolean result = (theCoach == assitantCoach);
		System.out.println("Comparision result of " + theCoach + " and " + assitantCoach + " is " + result);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getFortune());
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		context.close();

	}

}
