
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.DriverManager"%>
    <%@ page import = "java.sql.Connection" %>
    <%@ page import = "java.sql.SQLException" %>
    <%@page import="java.sql.PreparedStatement"%>
    <%@page import="java.sql.ResultSet"%>
    
    <%
	    String url = "jdbc:mariadb://localhost:3306/sample";
		String user = "root";
		String password = "123456";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuilder sbHtml = new StringBuilder();
		
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// out.println("드라이버 로딩 성공<br>");
			
			conn = DriverManager.getConnection(url, user, password);
			// out.println("데이터베이스 연결 성공<br>");
			
			// PreparedStatement -> dept table select -> table로 출력
			String sql = "select * from dept";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			sbHtml.append("<table width='800' border='1'>");
			while(rs.next()) {
				sbHtml.append("<tr>");
				sbHtml.append("<td>" + rs.getString("deptno") + "</td>");
				sbHtml.append("<td>" + rs.getString("dname") + "</td>");
				sbHtml.append("<td>" + rs.getString("loc") + "</td>");
				sbHtml.append("</tr>");
			}
			out.println("</table>");
			
		} catch(ClassNotFoundException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch(SQLException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally {
			if(conn != null) { conn.close();}
			if(pstmt != null) { pstmt.close();}
			if(rs != null) { rs.close();}
		}
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JDBC</title>
	</head>
	<body>
		<%= sbHtml.toString() %>
	</body>
</html>