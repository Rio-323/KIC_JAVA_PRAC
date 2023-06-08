package com.example.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.bootmybatisboard.BoardMapperInter;

@Repository
public class BoardDAO {

	@Autowired
	private BoardMapperInter mapper;
	
	public ArrayList<BoardTO> boardList() {
		ArrayList<BoardTO> lists = (ArrayList)mapper.boardList();
	
		return lists;
	}
	
	public int boardWriteOk(BoardTO to) {
		int flag = 1;
		
		int result = mapper.boardWriteOk( to );
		
		if( result == 1 ) {
			flag = 0;
		}
       
		return flag;
	}
}
