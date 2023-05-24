package com.exam.spring06;

public class HelloBean {
	private String name;
	
	public HelloBean() {
		System.out.println("HelloBean() 호출");
		this.name = "홍길동";
	}
	
	public HelloBean(String name) {
		System.out.println("HelloBean() 호출");
		this.name = name;
	}
	
	public HelloBean(String firstName, String lastName) {
		System.out.println("HelloBean(String firstName, String lastName) 호출");
		this.name = lastName + " " + firstName;
	}
	
	public void sayHello() {
		System.out.println(this.name + " 님 안녕하세요.");
	}
}
