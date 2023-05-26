package com.exam.spring.model;

public class WriteAction {
	private String writer;
	
	public WriteAction() {
		System.out.println("WriteAction() 호츌");
	}
	
	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	// core concern (핵심 기능)
	public void execute1() {
		System.out.println("execute1() 호츌");
	}
	
	public void execute2() {
		System.out.println("execute2() 호츌");
	}
}
