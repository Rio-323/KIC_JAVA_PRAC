package com.exam.spring.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class BasicAdvice1 implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		
		// 전처리 구간
		System.out.println("전처리 구간1 : " + invocation.getMethod().getName());
		System.out.println(invocation.getMethod().getName() + "메서드 시작");
		StopWatch stopWatch = new StopWatch();
		stopWatch.start(invocation.getMethod().getName());
		
		Object rtnObj = invocation.proceed();
		
		// 후처리 구간
		System.out.println("후처리 구간1");
		stopWatch.stop();
		
		System.out.println("처리 시간" + stopWatch.getTotalTimeSeconds());
		
		return null;
	}

}
