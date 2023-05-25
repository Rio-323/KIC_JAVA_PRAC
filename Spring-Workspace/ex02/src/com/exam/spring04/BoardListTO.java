package com.exam.spring04;

import java.util.ArrayList;

public class BoardListTO {
	private ArrayList<String> userLists;
	private ArrayList<BoardTO> boardLists;
	
	public ArrayList<String> getUserLists() {
		return userLists;
	}
	
	public void setUserLists(ArrayList<String> userLists) {
		this.userLists = userLists;
	}
	
	public ArrayList<BoardTO> getBoardLists() {
		return boardLists;
	}
	
	public void setBoardLists(ArrayList<BoardTO> boardLists) {
		this.boardLists = boardLists;
	}
	
}
