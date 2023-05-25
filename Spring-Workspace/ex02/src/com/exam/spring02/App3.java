package com.exam.spring02;


public class App3 {

	public static void main(String[] args) {
		BoardTO to = new BoardTO();
		to.setSeq(1);
		to.setSubject("제목 1");
		
		WriteAction writeAction = new WriteAction(to);
		writeAction.execute();
	}

}
