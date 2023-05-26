package com.exam.spring.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class BasicAdvice2 implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		// 전처리 구간
		System.out.println("전처리 구간2");
		Object rtnObj = invocation.proceed();
		
		// 후처리 구간
		System.out.println("후처리 구간2");
		
		return null;
	}

}
