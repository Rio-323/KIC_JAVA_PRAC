package com.exam.lifecycle.model;

public class WriteAction implements Action {
	
	private String writer;
	
	public WriteAction() {
		System.out.println("1. 빈의 생성자 실행");
	}
	
	public void setWriter(String writer) {
		System.out.println("2. setWriter(String writer) 실행");
		this.writer = writer;
	}

	@Override
	public void execute() {
		System.out.println("*. execute() 실행");
	}

}
