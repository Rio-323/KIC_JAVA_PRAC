package com.exam.spring.model2;

import java.util.ArrayList;

import com.exam.spring.model1.BoardDAO;

public class ListAction implements Action {
	private BoardDAO dao;
	
	public ListAction(BoardDAO dao) {
		this.dao = dao;
	}

	@Override
	public void execute() {
		ArrayList<String> lists = dao.boardList();
		
		for(String data : lists) {
			System.out.println(data);
		}
	}

}
