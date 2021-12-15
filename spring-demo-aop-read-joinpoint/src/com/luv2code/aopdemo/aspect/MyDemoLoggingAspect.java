package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	
	//this is where add logging advice
	//@Before("execution(public void add*())")
	//Match specific class
	//@Before("execution(* add*(com.luv2code.aopdemo.Account))")
	//Match specific class followed by any number of argument
	//@Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
	//Match all methods in package
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n======: Execution @Before advice on addAccount ");
		MethodSignature signature = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method signature: " + signature);
		
		for (Object tempArg: theJoinPoint.getArgs()) {
			System.out.println(tempArg);
			if (tempArg instanceof Account) {
				Account account = (Account) tempArg;
				System.out.println("Account name: " + account.getName());
				System.out.println("Account email: " + account.getEmail());
				
			}
		}
	}
	
}
