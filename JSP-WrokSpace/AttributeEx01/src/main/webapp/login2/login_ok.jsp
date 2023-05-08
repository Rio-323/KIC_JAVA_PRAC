<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>

<%@ page import="javax.sql.DataSource" %>

<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
    <%
    	// login_ok.jsp
    	request.setCharacterEncoding("utf-8");
    	
    	String id = request.getParameter("id");
    	String password = request.getParameter("password");
    	
    	// 실제 아이디, 패스워드
    	// 게시판 select
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
    	
    	
    	// 0 - success / 1 - paswword fail / 2 - etc
    	int flag = 2;
    	
    	try {
    		
    		Context initCtx = new InitialContext();
    		Context envCtx = (Context)initCtx.lookup( "java:comp/env" );
    		DataSource dataSource = (DataSource)envCtx.lookup( "jdbc/mariadb2" );
    		conn = dataSource.getConnection();
    		
    		// select 
    		// count(*)
    		// name, mail, grade => session
    		String sql = "select name, mail, grade from member1 where id = ? and password = ?";
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1, id);
    		pstmt.setString(2, password);
    		rs = pstmt.executeQuery();
    		
    		if(rs.next()) {
    			flag = 0;
    			
    			session.setAttribute("sid", id);
    			session.setAttribute("sname", rs.getString("name"));
    			session.setAttribute("sgrade", rs.getString("grade"));
    			
    			
    		} else {
    			flag = 1;
    		}
    		
    	} catch( NamingException e ) {
    		System.out.println( "[에러] " + e.getMessage() );
    	} catch( SQLException e ) {
    		System.out.println( "[에러] " + e.getMessage() );
    	} finally {
    		if( pstmt != null ) pstmt.close();
    		if( conn != null ) conn.close();
    		if( rs != null ) rs.close();
    	}
    	
    	
    	out.println("<script type='text/javascript'>");
    	if(flag == 0) {
    		out.println("alert('로그인 되었습니다.')");
    		out.println("location.href='login_complete.jsp'");
    	} else if(flag == 1) {
    		out.println("alert('비밀번호 오류')");
    		out.println("history.back();");
    	} else if(flag == 2) {
    		out.println("alert('오류')");
    		out.println("history.back();");
    	}
    	out.println("</script>");
    %>
