package com.exam.spring02;

public class WriteAction {
	private BoardTO to;
	
	public WriteAction(BoardTO to) {
		System.out.println("WriteAction(BoardTO to) 호출");
		
		this.to = to;
	}
	
	public void execute() {
		System.out.println(to.getSeq());
		System.out.println(to.getSubject());
	}
}
