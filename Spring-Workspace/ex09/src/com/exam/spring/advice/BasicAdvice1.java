package com.exam.spring.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class BasicAdvice1 {
	@Pointcut("execution(* execute1())")
	private void myTarget() {}
	
	@Around("myTarget()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("전처리 구간 1");
		Object rtnObj = joinPoint.proceed();
		
		System.out.println("후처리 구간 1");
		
		return rtnObj;
	}
}
