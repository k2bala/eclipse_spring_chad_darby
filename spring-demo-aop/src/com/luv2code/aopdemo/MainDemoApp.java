package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// read java config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO dao = context.getBean("accountDAO", AccountDAO.class);
		dao.addAccount();
		context.close();
		System.out.println("Second call");
		dao.addAccount();

	}

}
