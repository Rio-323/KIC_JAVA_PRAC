
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.DriverManager"%>
    <%@ page import = "java.sql.Connection" %>
    <%@ page import = "java.sql.SQLException" %>
    <%@page import="java.sql.PreparedStatement"%>
    <%@page import="java.sql.ResultSet"%>
    
    <%
    	request.setCharacterEncoding("utf-8");
	    String url = "jdbc:mariadb://localhost:3306/project";
		String user = "project";
		String password = "1234";
		String dongName = request.getParameter("dongName");
		
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
			String sql = "select zipcode, sido, gugun, dong, ri, bunji from zipcode where dong like ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + dongName + "%");
			rs = pstmt.executeQuery();
			
			sbHtml.append("<table width='800' border='1'>");
			while(rs.next()) {
				sbHtml.append("<tr>");
				sbHtml.append("<td>" + rs.getString("zipcode") + "</td>");
				sbHtml.append("<td>" + rs.getString("sido") + "</td>");
				sbHtml.append("<td>" + rs.getString("gugun") + "</td>");
				sbHtml.append("<td>" + rs.getString("dong") + "</td>");
				sbHtml.append("<td>" + rs.getString("ri") + "</td>");
				sbHtml.append("<td>" + rs.getString("bunji") + "</td>");
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
		<form action="jdbc04.jsp" method="post">
		동 이름 : <input type="text" name="dongName"><br><br>
		<input type="submit" value="검색">
		
		</form>
		<%= sbHtml.toString() %>
	</body>
</html>