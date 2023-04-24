
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.DriverManager"%>
    <%@ page import = "java.sql.Connection" %>
    <%@ page import = "java.sql.SQLException" %>
    <%@page import="java.sql.PreparedStatement"%>
    <%@page import="java.sql.ResultSet"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>JDBC</title>
	</head>
	<body>
		<%
			String url = "jdbc:mariadb://localhost:3306/sample";
			String user = "root";
			String password = "123456";
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				// out.println("드라이버 로딩 성공<br>");
				
				conn = DriverManager.getConnection(url, user, password);
				// out.println("데이터베이스 연결 성공<br>");
				
				// PreparedStatement -> dept table select -> table로 출력
				String sql = "select * from dept";
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				out.println("<table width='800' border='1'>");
				while(rs.next()) {
					out.println("<tr>");
					out.println("<td>" + rs.getString("deptno") + "</td>");
					out.println("<td>" + rs.getString("dname") + "</td>");
					out.println("<td>" + rs.getString("loc") + "</td>");
					out.println("</tr>");
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
	</body>
</html>