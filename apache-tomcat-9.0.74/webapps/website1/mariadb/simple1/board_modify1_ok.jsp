<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>

<%@ page import="javax.sql.DataSource" %>

<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>

<%

	request.setCharacterEncoding("utf-8");

	String subject = request.getParameter("subject");
	String seq = request.getParameter( "seq" );
	String mail = "";
	if(!request.getParameter("mail1").equals("") && !request.getParameter("mail2").equals("")) {
		mail = request.getParameter("mail1") + "@" + request.getParameter("mail2");
	}
	
	String password = request.getParameter("password");
	String content = request.getParameter("content");
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	// flag -> 0 : 정상 /  1 -> 비정상
	int flag = 2;
	
	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup( "java:comp/env" );
		DataSource dataSource = (DataSource)envCtx.lookup( "jdbc/mariadb3" );
		
		conn = dataSource.getConnection();
	
		String sql = "update board set subject = ?, mail =?, content = ? where seq = ? and password = ?";
		pstmt = conn.prepareStatement( sql );
		pstmt.setString(1, subject);
		pstmt.setString(2, mail);
		pstmt.setString(3, content);
		pstmt.setString(4, seq);
		pstmt.setString(5, password);
		
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			flag = 0;
		} else if(result == 0) {
			flag = 1;
		}
		
	} catch( NamingException e ) {
		System.out.println( "[에러] " + e.getMessage() );
	} catch( SQLException e ) {
		System.out.println( "[에러] " + e.getMessage() );
	} finally {
		if( pstmt != null ) pstmt.close();
		if( conn != null ) conn.close();
	}
	
	out.println("<script type='text/javascript'>");
	if(flag == 0) {
		out.println("alert('게시글 수정 성공');");
		out.println("location.href='board_view1.jsp?seq=" + seq + "';");
	} else if(flag == 1) {
		out.println("alert('비밀번호 오류');");
		out.println("history.back();");
	} else {
		out.println("alert('게시글 수정 실패');");
		out.println("history.back();");
	}
	out.println("</script>");
	
%>