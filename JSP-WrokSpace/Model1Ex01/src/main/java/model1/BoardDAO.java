package model1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class BoardDAO {
	private DataSource dataSource = null;
	
	
	public BoardDAO() {
		// 데이터 베이스 접속
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup( "java:comp/env" );
			
			this.dataSource = (DataSource)envCtx.lookup( "jdbc/mariadb3" );
		} catch( NamingException e ) {
			System.out.println( "[에러] " + e.getMessage() );
		} 
	}
	
	/*
	 write / write_ok / list / view / modify / modify_ok / delete / delete_ok
	 */
	
	public void boardWrite() {
		
	}
	
	public int boardWriteOk(BoardDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		// flag -> 0 : 정상 /  1 -> 비정상
		int flag = 1;
		
		try {
			conn = this.dataSource.getConnection();
		
			String sql = "INSERT INTO board VALUES (0, ?, ?, ?, ?, ?, 0, ?, now())";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getMail());
			pstmt.setString(4, dto.getPasword());
			pstmt.setString(5, dto.getContent());
			pstmt.setString(6, dto.getWip());
			
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				flag = 0;
			} 
			
		} catch( SQLException e ) {
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( pstmt != null ) try { pstmt.close(); } catch(SQLException e) {System.out.println( "[에러] " + e.getMessage() );}
			if( conn != null ) try { conn.close(); } catch(SQLException e) {System.out.println( "[에러] " + e.getMessage() );}
		}
	
		return flag;
	}
	
	public ArrayList<BoardDTO> boardList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<BoardDTO> datas = new ArrayList<>();
		
		
		try {
			conn = this.dataSource.getConnection();
			
			String sql = "select seq, subject, writer, date_format(wdate, '%Y-%m-%d') wdate, hit, datediff(now(), wdate) wgap from board order by seq desc";
			pstmt = conn.prepareStatement( sql );
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setWriter(rs.getString("writer"));
				dto.setWdate(rs.getString("wdate"));
				dto.setHit(rs.getString("hit"));
				dto.setWgap(rs.getInt("wgap"));
				
				datas.add(dto);
			}
			
		} catch( SQLException e ) {
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( pstmt != null ) try {pstmt.close(); } catch(SQLException e) {}
			if( conn != null ) try {conn.close(); } catch(SQLException e) {}
			if( rs != null ) try{rs.close();}  catch(SQLException e) {}
		}
		
		return datas;
	}
	
	public BoardDTO boardView(BoardDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = this.dataSource.getConnection();
			
			// 조회수 증가
			String sql = "update board set hit = hit + 1 where seq = ?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString(1, dto.getSeq());
			
			pstmt.executeUpdate();
			
			sql = "select subject, writer, mail, wip,wdate, hit, content from board where seq = ?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString(1, dto.getSeq());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setSubject(rs.getString("subject"));
				dto.setWriter(rs.getString("writer"));
				dto.setMail(rs.getString("mail"));
				dto.setWip(rs.getString("wip"));
				dto.setWdate(rs.getString("wdate"));
				dto.setHit(rs.getString("hit"));
				dto.setContent(rs.getString("content"));
			}
			
		} catch( SQLException e ) {
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( pstmt != null ) try {pstmt.close();} catch(SQLException e) {System.out.println( "[에러] " + e.getMessage() );}
			if( conn != null ) try {conn.close();} catch(SQLException e) {System.out.println( "[에러] " + e.getMessage() );}
		}
		
		return dto;
	}
	
	public void boardModify() {
		
	}
	
	public void boardModifyOk() {
		
	}
	
	public void boardDelete() {
		
	}
	
	public void boardDeleteOk() {
		
	}
}
