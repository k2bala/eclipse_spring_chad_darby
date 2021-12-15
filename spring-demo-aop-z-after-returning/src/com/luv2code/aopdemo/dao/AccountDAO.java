package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;

	public List<Account> findAccount() {
		List<Account> myList = new ArrayList<Account>();
		System.out.println(getClass() + ": Doing my DB work, adding an ccount");
		myList.add(new Account("a","1"));
		myList.add(new Account("b","2"));
		myList.add(new Account("c","3"));

		return myList;
	}

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
