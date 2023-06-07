package com.example.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ZipcodeDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public List<ZipcodeTO> zipcodeLists(String strDong) {
		
		List<ZipcodeTO> lists = sqlSession.selectList("selectzipcode", strDong + "%");
		
		return lists;
	}
}
