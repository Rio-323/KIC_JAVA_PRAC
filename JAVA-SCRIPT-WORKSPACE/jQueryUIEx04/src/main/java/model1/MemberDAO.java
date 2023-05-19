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

public class MemberDAO {
	private DataSource dataSource;
    
	public MemberDAO() {
		
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup( "java:comp/env" );
			this.dataSource = (DataSource)envCtx.lookup( "jdbc/mariadb2" );
		} catch (NamingException e) {
			
			System.out.println( "[에러] " + e.getMessage() ); 
		}
	}

	public ArrayList<MemberTO> userList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
	       
		ArrayList<MemberTO> lists = new ArrayList<>();
	       
		try {
			conn = this.dataSource.getConnection();
	       
			String sql = "select seq, name, password, email, address, wdate from users";
			pstmt = conn.prepareStatement( sql );
	           
			rs = pstmt.executeQuery();
			while( rs.next() ) {
				MemberTO to = new MemberTO();
				to.setSeq(rs.getString("seq"));
				to.setName(rs.getString("name"));
				to.setPassword(rs.getString("password"));
				to.setEmail(rs.getString("email"));
				to.setAddress(rs.getString("address"));
				to.setWdate(rs.getString("wdate"));
	               
				lists.add( to );
			}
		} catch( SQLException e ) {
			System.out.println( e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
		return lists;
	}
	
	public int userWrite(MemberTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int flag = 1;
	       
		try {
			conn = this.dataSource.getConnection();
	       
			String sql = "insert into users values (0, ?, ?, ?, ?, now())";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, to.getName() );
			pstmt.setString( 2, to.getPassword() );
			pstmt.setString( 3, to.getEmail() );
			pstmt.setString( 4, to.getAddress() );
	           
			int result = pstmt.executeUpdate();
			
			if(result == 1) {
				flag = 0;
			}
			
		} catch( SQLException e ) {
			System.out.println( e.getMessage() );
		} finally {
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
		return flag;
	}
	
	public int userModify(MemberTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int flag = 2;
	       
		try {
			conn = this.dataSource.getConnection();
	       
			String sql = "update users set email = ?, address = ? where seq = ? and password = ?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, to.getEmail() );
			pstmt.setString( 2, to.getAddress() );
			pstmt.setString( 3, to.getSeq() );
			pstmt.setString( 4, to.getPassword() );
	           
			int result = pstmt.executeUpdate();
			
			if(result == 0) {
				flag = 1;
			} else if(result == 1) {
				flag = 0;
			}
			
		} catch( SQLException e ) {
			System.out.println( e.getMessage() );
		} finally {
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
		return flag;
	}
	
	public int userDelete(MemberTO to) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int flag = 2;
	       
		try {
			conn = this.dataSource.getConnection();
	       
			String sql = "delete from users where seq = ? and password = ?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, to.getSeq() );
			pstmt.setString( 2, to.getPassword() );
	           
			int result = pstmt.executeUpdate();
			
			if(result == 0) {
				flag = 1;
			} else if(result == 1) {
				flag = 0;
			}
			
		} catch( SQLException e ) {
			System.out.println( e.getMessage() );
		} finally {
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
		}
		return flag;
	}

}