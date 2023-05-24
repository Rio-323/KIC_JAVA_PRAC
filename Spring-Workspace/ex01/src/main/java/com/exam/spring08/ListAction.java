package com.exam.spring08;

public class ListAction {
	private BoardTO to;
	
	public ListAction(BoardTO to) {
		System.out.println("ListAction(BoardTO to) 호출");
		this.to = to;
	}
	
	public void execute() {
		System.out.println(to.getSeq());
		System.out.println(to.getSubject());
	}
}
