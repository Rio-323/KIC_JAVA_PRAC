package com.exam.spring07;

public class App1 {

	public static void main(String[] args) {
		BoardTO to = new BoardTO();
//		WriteAction writeAction1 = new WriteAction();
//		writeAction1.execute();
		
		WriteAction writeAction2 = new WriteAction(to);
		writeAction2.execute();

	}
}
