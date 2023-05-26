package com.exam.spring.advice;

import org.aspectj.lang.ProceedingJoinPoint;

// POJO
public class BasicAdvice1 {
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("전처리 구간 1");
		
		Object rtnObj = joinPoint.proceed();
		
		System.out.println("후처리 구간 1");
		
		return rtnObj;
	}
}
