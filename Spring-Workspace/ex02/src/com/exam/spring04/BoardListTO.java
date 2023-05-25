package com.exam.spring04;

import java.util.ArrayList;
import java.util.HashMap;

public class BoardListTO {
	private ArrayList<String> userLists;
	private ArrayList<BoardTO> boardLists;
	private HashMap<String, String> userMaps;
	private HashMap<String, BoardTO> boardMaps;
	
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
	
	public HashMap<String, String> getUserMaps() {
		return userMaps;
	}
	
	public void setUserMaps(HashMap<String, String> userMaps) {
		this.userMaps = userMaps;
	}
	
	public HashMap<String, BoardTO> getBoardMaps() {
		return boardMaps;
	}
	
	public void setBoardMaps(HashMap<String, BoardTO> boardMaps) {
		this.boardMaps = boardMaps;
	}
	
}
