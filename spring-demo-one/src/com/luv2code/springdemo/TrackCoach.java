package com.luv2code.springdemo;

public class TrackCoach implements Coach {

    private FortuneService  fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Daily workout: Track";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	public void doInit() {
		System.out.println("Iniializing");
	}
	
	public void doCleanUp() {
		System.out.println("Cleaning up");
	}

}
