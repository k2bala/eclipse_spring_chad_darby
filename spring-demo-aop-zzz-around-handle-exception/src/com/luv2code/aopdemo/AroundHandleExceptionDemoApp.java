package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {
	private static Logger myLogger  = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

	public static void main(String[] args) {
		// read java config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		TrafficFortuneService trafficService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		myLogger.info("\nMain program around demo");
		boolean tripwire = true;
		String fortune = trafficService.getFortune(tripwire);
		myLogger.info(fortune);
		myLogger.info("\nMain program after returning");
		context.close();
	}

}
