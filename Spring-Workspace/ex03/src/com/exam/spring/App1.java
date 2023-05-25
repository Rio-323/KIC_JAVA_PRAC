package com.exam.spring;

import com.exam.spring.model1.BoardDAO;
import com.exam.spring.model2.Action;
import com.exam.spring.model2.ListAction;

public class App1 {

	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		Action action = new ListAction(dao);
		
		action.execute();
	}

}
