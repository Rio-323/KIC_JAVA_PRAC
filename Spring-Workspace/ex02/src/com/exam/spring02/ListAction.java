package com.exam.spring02;

public class ListAction {
	
	private BoardTO to;

	public BoardTO getTo() {
		return to;
	}

	public void setTo(BoardTO to) {
		this.to = to;
	}
	
	
	public void execute() {
		System.out.println(to.getSeq());
		System.out.println(to.getSubject());
	}
}
