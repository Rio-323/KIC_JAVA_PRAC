package com.example.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ArrayList<BoardTO> boardList() {
		String sql = "select seq, subject, writer, date_format(wdate, '%Y-%m-%d') wdate, hit, datediff(now(), wdate) wgap from board order by seq desc";
		ArrayList<BoardTO> lists = (ArrayList<BoardTO>)jdbcTemplate.query(sql, new BeanPropertyRowMapper<BoardTO>(BoardTO.class));
		
		return lists;
	}
	
	public int boardWriteOk(BoardTO to) {
		int flag = 1;
		
		int result = jdbcTemplate.update("insert into board values ( 0, ?, ?, ?, ?, ?, 0, ?, now() )",
				to.getSubject(), to.getWriter(), to.getMail(), to.getPassword(), to.getContent(), to.getWip());
		
		if(result == 1) {
			flag = 0;
		}
				
		return flag;
	}
}
