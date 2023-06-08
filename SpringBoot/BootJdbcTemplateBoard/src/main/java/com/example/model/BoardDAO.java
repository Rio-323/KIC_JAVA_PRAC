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
	
	public BoardTO boardView(BoardTO to) {
		
		int result = jdbcTemplate.update("update board set hit = hit + 1 where seq = ?", to.getSeq());
		
		to = jdbcTemplate.queryForObject("select seq, subject, writer, mail, wip, wdate, hit, content from board where seq = ?", new BeanPropertyRowMapper<BoardTO>(BoardTO.class), to.getSeq());
		
		return to;
	}
	
	public BoardTO boardModify(BoardTO to) {
		String sql = "select seq, subject, writer, mail, content, password from board where seq=?";
		to = jdbcTemplate.queryForObject( sql, new BeanPropertyRowMapper<BoardTO>(BoardTO.class), to.getSeq() );
		
		return to;
	}
	
	public int boardModifyOk(BoardTO to) {
		int flag = 2;
		
		String sql = "update board set subject=?, mail=?, content=? where seq=? and password=?";
		int result = jdbcTemplate.update( sql, to.getSubject(), to.getMail(), to.getContent(), to.getSeq(), to.getPassword() );

		if( result == 0 ) {
			flag = 1;
		} else if( result == 1 ) {
			flag = 0;
		}
		
		return flag;
	}
	
	public BoardTO boardDelete(BoardTO to) {
		String sql = "select seq, subject, writer from board where seq=?";
		to = jdbcTemplate.queryForObject( sql, new BeanPropertyRowMapper<BoardTO>(BoardTO.class), to.getSeq() );
		
		return to;
	}
	
	public int boardDeleteOk(BoardTO to) {
		int flag = 2;
		
		String sql = "delete from board where seq=? and password=?";
		int result = jdbcTemplate.update( sql, to.getSeq(), to.getPassword() );
		
		if( result == 0 ) {
			flag = 1;
		} else if( result == 1 ) {
			flag = 0;
		}
		
		return flag;
	}
}
