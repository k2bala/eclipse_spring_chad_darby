package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addSomeOne() {
		System.out.println(getClass() + ": Doing my work, adding a membership");
		return true;
	}
	
	public void doSleep() {
		System.out.println(getClass() + ": Doing sleep");
	}


}
