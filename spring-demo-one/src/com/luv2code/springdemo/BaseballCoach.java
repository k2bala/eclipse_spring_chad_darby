package com.luv2code.springdemo;

public class BaseballCoach implements Coach {
	
	private FortuneService  fortuneService;
	
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Daily workout: baseball";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
