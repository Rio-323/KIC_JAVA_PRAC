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
	
//	public ArrayList<ZipcodeTO> gugunList(String strSido) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//	       
//		ArrayList<ZipcodeTO> lists = new ArrayList<>();
//	       
//		try {
//			conn = this.dataSource.getConnection();
//	       
//			String sql = "select distinct gugun from zipcode where sido=?";
//			pstmt = conn.prepareStatement( sql );
//			pstmt.setString( 1, strSido );
//	           
//			rs = pstmt.executeQuery();
//			while( rs.next() ) {
//				ZipcodeTO to = new ZipcodeTO();
//				to.setGugun( rs.getString( "gugun" ) );
//	               
//				lists.add( to );
//			}
//		} catch( SQLException e ) {
//			System.out.println( e.getMessage() );
//		} finally {
//			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
//			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
//			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
//		}
//		return lists;
//	}
//	
//	public ArrayList<ZipcodeTO> dongList(String strSido, String strGugun) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//	       
//		ArrayList<ZipcodeTO> lists = new ArrayList<>();
//	       
//		try {
//			conn = this.dataSource.getConnection();
//	       
//			String sql = "select distinct dong from zipcode where sido = ? and gugun = ?";
//			pstmt = conn.prepareStatement( sql );
//			pstmt.setString( 1, strSido );
//			pstmt.setString( 2, strGugun );
//	           
//			rs = pstmt.executeQuery();
//			while( rs.next() ) {
//				ZipcodeTO to = new ZipcodeTO();
//				to.setDong( rs.getString( "dong" ) );
//	               
//				lists.add( to );
//			}
//		} catch( SQLException e ) {
//			System.out.println( e.getMessage() );
//		} finally {
//			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
//			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
//			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
//		}
//		return lists;
//	}
//
//	public ArrayList<ZipcodeTO> addressList(String strSido, String strGugun, String strDong) {
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//	       
//		ArrayList<ZipcodeTO> lists = new ArrayList<>();
//	       
//		try {
//			conn = this.dataSource.getConnection();
//	       
//			String sql = "select zipcode, sido, gugun, dong, ri, bunji from zipcode where sido = ? and gugun = ? and dong = ?";
//			pstmt = conn.prepareStatement( sql );
//			pstmt.setString( 1, strSido );
//			pstmt.setString( 2, strGugun );
//			pstmt.setString( 3, strDong );
//	           
//			rs = pstmt.executeQuery();
//			while( rs.next() ) {
//				ZipcodeTO to = new ZipcodeTO();
//				to.setZipcode( rs.getString( "zipcode" ) );
//				to.setSido( rs.getString( "sido" ) );
//				to.setGugun( rs.getString( "gugun" ) );
//				to.setDong( rs.getString( "dong" ) );
//				to.setRi( rs.getString( "ri" ) );
//				to.setBunji( rs.getString( "bunji" ) );
//	               
//				lists.add( to );
//			}
//		} catch( SQLException e ) {
//			System.out.println( e.getMessage() );
//		} finally {
//			if( rs != null ) try { rs.close(); } catch( SQLException e ) {}
//			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {}
//			if( conn != null ) try { conn.close(); } catch( SQLException e ) {}
//		}
//		return lists;
//	}

}