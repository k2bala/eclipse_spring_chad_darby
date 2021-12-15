package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// read java config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		AccountDAO dao = context.getBean("accountDAO", AccountDAO.class);
		Account account = new Account();
		account.setName("bb");
		account.setEmail("gg");
		dao.addAccount(account, true);
		dao.setName("foo");
		dao.setServiceCode("bar");
		dao.getName();
		dao.getServiceCode();
		System.out.println("Second call");
		dao.addAccount(new Account(), false);
		dao.doWork();
		MembershipDAO membershipdao = context.getBean("membershipDAO", MembershipDAO.class);
		membershipdao.addSomeOne();
		membershipdao.doSleep();
		context.close();
	}

}
