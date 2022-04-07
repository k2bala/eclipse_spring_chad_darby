package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterFinallyDemoApp {

	public static void main(String[] args) {
		// read java config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO dao = context.getBean("accountDAO", AccountDAO.class);
		List<Account> foundAccount = null;
		boolean tripwire = true;
		try {
			foundAccount = dao.findAccount(tripwire);
		} catch(Exception e) {
			System.out.println("Main caught exception"  + e);
		}
		System.out.println("\nMain program after returning");
		System.out.println(foundAccount);
		context.close();
	}

}
