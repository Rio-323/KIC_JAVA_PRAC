package com.exam.spring04;

import java.util.HashMap;

public class App3 {
	public static void main(String[] args) {
		HashMap<String, String> userMaps = new HashMap();
		
		userMaps.put("key1", "홍길동");
		userMaps.put("key2", "박문수");
		
		BoardListTO listTO = new BoardListTO();
		listTO.setUserMaps(userMaps);
		
		for(String value : listTO.getUserMaps().values()) {
			System.out.println(value);
		}
	}
}
