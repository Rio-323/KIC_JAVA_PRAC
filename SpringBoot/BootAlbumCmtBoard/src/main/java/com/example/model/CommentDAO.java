package com.example.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.config.CommentMapperInter;

@Repository
public class CommentDAO {
	
	@Autowired
	private CommentMapperInter mapper;
	
	public ArrayList<CommentTO> getList(int seq) {
		return mapper.getList(seq);
	}
	
	public int commentWriteOk(CommentTO commentTO) {
		int flag = 1;
		
		int result = mapper.commentOK(commentTO);
		
		if( result == 1 ) {
			flag = 0;
		}
       
		return flag;
	}
}
