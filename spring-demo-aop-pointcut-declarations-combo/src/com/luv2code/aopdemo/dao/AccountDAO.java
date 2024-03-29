package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;

	public void addAccount(Account acc, boolean flag) {
		System.out.println(getClass() + ": Doing my DB work, adding an ccount");
	}
	
	
	public boolean doWork() {
		System.out.println(getClass() + ": Doing work");
		return false;
	}


	public String getName() {
		System.out.println(getClass() + ": in getName");
		return name;
	}


	public void setName(String name) {
		System.out.println(getClass() + ": in setName");
		this.name = name;
	}


	public String getServiceCode() {
		System.out.println(getClass() + ": in getServiceCode");
		return serviceCode;
	}


	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + ": in setServiceCode");
		this.serviceCode = serviceCode;
	}
	
	


}
