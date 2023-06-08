package com.example.model;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	@Autowired
	private SqlSession sqlSession;
	
	public ArrayList<BoardTO> boardList() {
		ArrayList<BoardTO> lists = (ArrayList)sqlSession.selectList( "list" );
	
		return lists;
	}
	
	public int boardWriteOk(BoardTO to) {
		int flag = 1;
		
		int result = sqlSession.insert( "write_ok", to );
		
		if( result == 1 ) {
			flag = 0;
		}
       
		return flag;
	}
}
