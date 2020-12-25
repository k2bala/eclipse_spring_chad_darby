package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context 
		= new AnnotationConfigApplicationContext(SportConfig.class);
		
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
        Coach assitantCoach = context.getBean("tennisCoach", Coach.class);
		
		boolean result = (theCoach == assitantCoach);
		System.out.println("Comparision result of " + theCoach + " and " + assitantCoach + " is " + result);
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getFortune());
		context.close();

	}

}
