package com.exam.spring04;

import java.util.ArrayList;

public class App1 {
	public static void main(String[] args) {
		ArrayList<String> userList = new ArrayList();
		userList.add("홍길동");
		userList.add("박문수");
		
		BoardListTO listTO = new BoardListTO();
		listTO.setUserLists(userList);
		
		for(String user : listTO.getUserLists()) {
			System.out.println(user);
		}
		
		BoardTO to1 = new BoardTO();
		to1.setSeq(1);
		to1.setSubject("제목1");
		
		BoardTO to2 = new BoardTO();
		to2.setSeq(2);
		to2.setSubject("제목2");
		
		
		ArrayList<BoardTO> boardLists = new ArrayList();
		boardLists.add(to1);
		boardLists.add(to2);
		
		listTO.setBoardLists(boardLists);
		
		for(BoardTO to : boardLists) {
			System.out.println(to.getSeq());
			System.out.println(to.getSubject());
		}
	}
}
