<%@ page language="java" contentType="text/html; charset=UTF-8"
		 encyType="multupart/form-data" pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<%@ page import="javax.sql.DataSource" %>

<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>

<%
	request.setCharacterEncoding("utf-8");

	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try {
		
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup( "java:comp/env" );
		DataSource dataSource = (DataSource)envCtx.lookup( "jdbc/mariadb1" );
		conn = dataSource.getConnection();
		
		String sql = "insert into album_board2 values (0, ?, ?, ?, ?, ?, ?, 0, 1, 1, 1, 0, ?, now())";
		pstmt = conn.prepareStatement(sql);
		for( int i=1; i<=50; i++ ) {
			pstmt.setString( 1, "제목" + i );
			pstmt.setString( 2, "글쓴이" );
			pstmt.setString( 3, "test@test.com" );
			pstmt.setString( 4, "123" );
			pstmt.setString( 5, "내용" + i );
			pstmt.setString( 6, "607927_1.jpg" );
			pstmt.setString( 7, "000.000.000.000" );
						
			pstmt.executeUpdate();
		}
		
	} catch(NamingException e) {
		System.out.println( "error: " + e.getMessage() );
	} catch(SQLException e) {
		System.out.println( "error: " + e.getMessage() );
	} finally {
		if ( pstmt != null ) pstmt.close();
		if ( conn != null ) conn.close();
	}
	
	out.println( " <script type='text/javascript'> " );
	out.println( " alert('글쓰기에 성공했습니다.'); " );
	out.println( " location.href='board_list1.jsp;' " );
	out.println( " </script> " );
	

%>