package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
	
    private FortuneService  fortuneService;
    
    @Value("${foo.email}")
    private String emailAddress;
    @Value("${foo.team}")
	private String team;
	
    
	
    public FortuneService getFortuneService() {
		return fortuneService;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getTeam() {
		return team;
	}

	//  Constructor Injection  
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
    }

	@Override
	public String getDailyWorkout() {
		return "Daily workout: Swim";
	}
	
	@Override
	public String getFortune() {
		return fortuneService.getFortune();
	}
	
}
