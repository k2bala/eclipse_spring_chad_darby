package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private static Logger myLogger  = Logger.getLogger(MyDemoLoggingAspect.class.getName());

	// this is where add logging advice
	// @Before("execution(public void add*())")
	// Match specific class
	// @Before("execution(* add*(com.luv2code.aopdemo.Account))")
	// Match specific class followed by any number of argument
	// @Before("execution(* add*(com.luv2code.aopdemo.Account, ..))")
	// Match all methods in package
	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n======: Execution @Before advice on addAccount ");
		MethodSignature signature = (MethodSignature) theJoinPoint.getSignature();

		myLogger.info("Method signature: " + signature);

		for (Object tempArg : theJoinPoint.getArgs()) {
			myLogger.info(tempArg.toString());
			if (tempArg instanceof Account) {
				Account account = (Account) tempArg;
				myLogger.info("Account name: " + account.getName());
				myLogger.info("Account email: " + account.getEmail());

			}
		}
	}

	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))", returning = "result")
	public void afterReturnFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {
		MethodSignature signature = (MethodSignature) theJoinPoint.getSignature();

		myLogger.info("\n======: Execution @after returning advice on addAccount " + signature);

		myLogger.info("\n======: Result from methid @after returning advice on addAccount " + result);

		convertNameToUpperCase(result);
	}

	private void convertNameToUpperCase(List<Account> result) {
		// TODO Auto-generated method stub
		for (Account acc : result) {
			acc.setName(acc.getName().toUpperCase());
		}
	}

	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))", throwing = "ex")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable ex) {
		MethodSignature signature = (MethodSignature) theJoinPoint.getSignature();

		myLogger.info("\n======: Execution @after throwing advice on addAccount " + signature);

		myLogger.info("\n======: Exception from method @after throwin advice on addAccount " + ex);
	}

	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		MethodSignature signature = (MethodSignature) theJoinPoint.getSignature();

		myLogger.info("\n======: Execution @after(finally) advice on addAccount " + signature);
	}

	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();

		myLogger.info("\n======: Execution @Aroud advice on getFortune " + signature);
		long begin = System.currentTimeMillis();
		Object result = proceedingJoinPoint.proceed();
		long end = System.currentTimeMillis();
		myLogger.info("Function took " + (end - begin) / 1000.0 + "seconds");
		
		return result;
	}
}
