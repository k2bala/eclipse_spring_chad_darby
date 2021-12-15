package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CRMLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forDaoPackage() || forServicePackage() || forControllerPackage()")
	private void forAppFlow() {}

	//add before advoce
	@Before("forAppFlow()")
	public void beforeMethod(JoinPoint theJoinPoint) {
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("in @Before before calling: " + method);
		Object[] args = theJoinPoint.getArgs();
		for(Object arg: args) {
			myLogger.info("in @Before argument: " + arg);
		}
		
	}
	
	@AfterReturning(pointcut ="forAppFlow()", returning ="result")
	public void afterReturningMethod(JoinPoint theJoinPoint, Object result) {
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("in @AfterReturning after calling: " + method);
		myLogger.info("in @AfterReturning result: " + result);
	}

}
