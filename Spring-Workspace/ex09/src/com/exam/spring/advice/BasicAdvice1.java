package com.exam.spring.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BasicAdvice1 {
	@Pointcut("execution(* execute*())")
	private void myTarget() {}
	
//	@Around("myTarget()")
//	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
//		System.out.println("전처리 구간 1");
//		Object rtnObj = joinPoint.proceed();
//		
//		System.out.println("후처리 구간 1");
//		
//		return rtnObj;
//	}
	
	@Before("myTarget()")
	public void before() {
		System.out.println("전처리 구간 1");
	}
	
	@Before("myTarget()")
	public void after() {
		System.out.println("후처리 구간 1");
	}
}
