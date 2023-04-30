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
			System.out.println( "[Error] : " + e.getMessage() );
		} 
	}
	
	public void boardWrite() {
		
	}
	
	public int boardWriteOk(BoardDTO dto) {
		int flag = 1;
		return flag;
	}
	
	public BoardListDTO boardListDTO(BoardListDTO boardListDTO) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int cpage = boardListDTO.getCpage();
		int recordPerPage = boardListDTO.getRecordPerPage();
		
		int blockPerPage = boardListDTO.getBlockPerPage();
		
		
		try {
			conn = this.dataSource.getConnection();
			
			String sql = "select seq, subject, writer, date_format(wdate, '%Y-%m-%d') wdate, hit, datediff(now(), wdate) wgap from board order by seq desc";
			pstmt = conn.prepareStatement( sql );
			
			rs = pstmt.executeQuery();
			
			rs.last();
			boardListDTO.setTotalRecord(rs.getRow());
			rs.beforeFirst();
			
			int skip = (cpage - 1) * recordPerPage;
			
			boardListDTO.setTotalPage(((boardListDTO.getTotalRecord() - 1) / boardListDTO.getRecordPerPage()) + 1);
			if(skip > 0) { rs.absolute(skip); }
			
			ArrayList<BoardDTO> boardLists = new ArrayList<>();
			
			for(int i = 0; i < recordPerPage && rs.next(); i++){
				BoardDTO dto  = new BoardDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setWriter(rs.getString("writer"));
				dto.setWdate(rs.getString("wdate"));
				dto.setHit(rs.getString("hit"));
				dto.setWgap(rs.getInt("wgap"));
				boardLists.add(dto);
			}
			
			boardListDTO.setBoardLists(boardLists);
			
			boardListDTO.setStartBlock(cpage - (cpage - 1) % blockPerPage);
			boardListDTO.setEndBlock(cpage - (cpage - 1) % blockPerPage + blockPerPage - 1);
			
			if(boardListDTO.getEndBlock() >= boardListDTO.getTotalPage()) {
				boardListDTO.setEndBlock(boardListDTO.getTotalPage());
			}
			
		} catch( SQLException e ) {
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( pstmt != null ) try { pstmt.close(); } catch(SQLException e) {System.out.println( "[에러] " + e.getMessage() );}
			if( conn != null ) try { conn.close(); } catch(SQLException e) {System.out.println( "[에러] " + e.getMessage() );}
			if( rs != null ) try{rs.close();}  catch(SQLException e) {System.out.println( "[에러] " + e.getMessage() );}
		}
		
		return boardListDTO;
		
	}
	
	
}
