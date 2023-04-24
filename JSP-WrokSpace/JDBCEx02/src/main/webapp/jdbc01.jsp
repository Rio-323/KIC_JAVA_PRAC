<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="javax.naming.Context" %>
    <%@ page import="javax.naming.InitialContext" %>
    <%@ page import="javax.naming.NamingException" %>
    
    <%@ page import="javax.sql.DataSource" %>
    
    <%@ page import="java.sql.Connection" %>
    <%@ page import="java.sql.SQLException" %>
    
    <%
    	Connection conn = null;
    
    	Context initCtx = new InitialContext();
    	Context envCtx = (Context)initCtx.lookup("java:comp/env");
    	DataSource dataSource = (DataSource)envCtx.lookup("jdbc/mariadb1");
    	
    	conn = dataSource.getConnection();
    	
    	System.out.println("데이터 베이스 연결 성공");
    	conn.close();
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>데이터베이스 풀링</title>
	</head>
	<body>
		
	</body>
</html>