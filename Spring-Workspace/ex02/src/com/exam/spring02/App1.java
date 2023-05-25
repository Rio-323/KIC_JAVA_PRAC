package com.exam.spring02;

public class App1 {

	public static void main(String[] args) {
		BoardTO to = new BoardTO();
		to.setSeq(1);
		to.setSubject("제목1");
		
		System.out.println(to.getSeq());
		System.out.println(to.getSubject());
	}

}
