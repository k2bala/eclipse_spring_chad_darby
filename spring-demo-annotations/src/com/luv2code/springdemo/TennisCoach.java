package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class TennisCoach implements Coach, DisposableBean {
	
	@Autowired
	@Qualifier("randomFortuneService")
    private FortuneService  fortuneService;

//  Constructor Injection  
//	@Autowired	
//	public TennisCoach(FortuneService fortuneService) {
//		this.fortuneService = fortuneService;
//	}

//  Setter/Method Injection	
//	public void setFortuneService(FortuneService fortuneService) {
//		System.out.println("Inside tennis coach setter");
//		this.fortuneService = fortuneService;
//	}
	
	@Override
	public String getDailyWorkout() {
		return "Daily workout: tennis";
	}
	
	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}
	
	@PostConstruct
	public void doInit() {
		System.out.println("Iniializing");
	}

	//Code for cleaning up prototype beans
	@Override
	public void destroy() throws Exception {
		System.out.println("Cleaning up");
		
	}
	
//	@PreDestroy
//	public void doCleanUp() {
//		System.out.println("Cleaning up");
//	}
	
	

}
