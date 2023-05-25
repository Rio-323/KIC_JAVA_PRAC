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
	}
}
