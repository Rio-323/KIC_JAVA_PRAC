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
	public void execute() {
		System.out.println("execute() 호츌");
	}
}
