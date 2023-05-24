package com.exam.spring01;

public class App {

	public static void main(String[] args) {
		
		// 객체의 생성을 프로그래머가 담당.
		HelloBean1 helloBean1 = new HelloBean1();
		helloBean1.sayHello("홍길동");
		
		HelloBean2 helloBean2 = new HelloBean2();
		helloBean2.sayHello("박문수");
	}

}
