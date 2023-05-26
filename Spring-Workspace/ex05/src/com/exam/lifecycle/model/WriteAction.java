package com.exam.lifecycle.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class WriteAction implements Action, InitializingBean, DisposableBean, 
ApplicationContextAware, BeanNameAware, 
BeanClassLoaderAware, BeanFactoryAware {
	private String writer;
	
	private String beanName;
	private BeanFactory beanFactory;
	
	public WriteAction() {
		// TODO Auto-generated constructor stub
		System.out.println("1. 빈의 생성자 호출");
	}
	
	public void setWriter(String writer) {
		System.out.println("2.setWriter(String writer) 호출");
		this.writer = writer;
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		System.out.println("*.execute() 호출");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("5.setBeanFactory(BeanFactory beanFactory) 호출");
		
		System.out.println("beanFactory :" + beanFactory);
	}

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		// TODO Auto-generated method stub
		System.out.println("4.setBeanClassLoader(ClassLoader classLoader)  호출");
	}

	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("3. setBeanName(String name 호출");
		
		System.out.println("beanName: " + name);
		this.beanName = name;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("6. setApplicationContext(ApplicationContext applicationContext) 호출");
	}

	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("11. destroy() 호출");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("8. afterPropertiesSet() 호출");
		
		if(writer == null) {
			System.out.println("writer의 값이 없습니다.");
		} else {
			System.out.println("writer의 값이 있습니다.");
		}
	}

	//커스텀 메서드
	public void init_method() {
		System.out.println("9. init_method() 호출" );
	}
	
	public void destroy_method() {
		System.out.println("12. destroy_method() 호출" );
	}
}
