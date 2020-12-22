package com.luv2code.springdemo;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	private String emailAddress;
	
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	private String team;
	
	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		System.out.println("Inside cricket coach set team");
		this.team = team;
	}

	public CricketCoach() {
		System.out.println("Inside cricket coach constructor");
	}

	public FortuneService getFortuneService() {
		return fortuneService;
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Inside cricket coach setter");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Daily workout: cricket";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune() + "from " + emailAddress;
	}

}
