package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {};
	
	//this is where add logging advice
	//@Before("execution(public void add*())")
	//Match specific class
	//@Before("execution(* add*(com.luv2code.aopdemo.Account))")
	//Match specific class followed by any number of argument
	//@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
	//Match all methods in package
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n======: Execution @Before advice on addAccount ");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n======: Perform Api anlaytics ");
	}

}
