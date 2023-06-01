package model1;

import java.sql.SQLException;
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
		ArrayList<BoardTO> lists = (ArrayList<BoardTO>)jdbcTemplate.query(
				"select seq, subject, writer, date_format(wdate, '%Y-%m-%d') wdate, hit, datediff(now(), wdate) wgap from board order by seq desc", 
				new BeanPropertyRowMapper<BoardTO>(BoardTO.class));
		
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
		
		System.out.println("to1 : " + to);
		System.out.println("seq1 : " + to.getSeq());
		
		to = jdbcTemplate.queryForObject("select seq, subject, writer, mail, wip, wdate, hit, content from board where seq = ?", new BeanPropertyRowMapper<BoardTO>(BoardTO.class), to.getSeq());
		
		System.out.println("to2 : " + to);
		System.out.println("seq2 : " + to.getSeq());
		
		return to;
	}
	
	public BoardTO boardModify(BoardTO to) {
		
		to = jdbcTemplate.queryForObject("select seq, subject, writer, mail, content from board where seq=?", new BeanPropertyRowMapper<BoardTO>(BoardTO.class), to.getSeq());
		
		System.out.println("to2 : " + to);
		System.out.println("seq2 : " + to.getSeq());
		
		return to;
	}
	
	public int boardModifyOk(BoardTO to) {
		
		int flag = 2;
		
		int result = jdbcTemplate.update("update board set subject = ?, mail = ?, content = ? where seq = ? and password = ?",
				to.getSubject(), to.getMail(), to.getContent(), to.getSeq(), to.getPassword());
		
		if(result == 1) {
			flag = 0;
		} else if(result == 0) {
			flag = 1;
		}
		
		return flag;
	}
}
