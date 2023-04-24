<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.DriverManager"%>
    <%@ page import = "java.sql.Connection" %>
    <%@ page import = "java.sql.SQLException" %>
    <%@page import="java.sql.PreparedStatement"%>
    <%@page import="java.sql.ResultSet"%>
    
    <%
    	request.setCharacterEncoding("utf-8");
    
    	StringBuilder sbHtml = new StringBuilder();
    	if(request.getParameter("dong") != null) {
    		String strDong = request.getParameter("dong");
    		
    		String url = "jdbc:mariadb://localhost:3306/project";
    		String user = "project";
    		String password = "1234";
    		
    		Connection conn = null;
    		PreparedStatement pstmt = null;
    		ResultSet rs = null;
    		
    		try {
    			Class.forName("org.mariadb.jdbc.Driver");
    			
    			conn = DriverManager.getConnection(url, user, password);
    			
    			String sql = "select zipcode, sido, gugun, dong, ri, bunji from zipcode where dong like ?";
    			pstmt = conn.prepareStatement(sql);
    			pstmt.setString(1, "%" + strDong + "%");
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
    			sbHtml.append("</table>");
    			
    			
    		} catch(ClassNotFoundException e) {
    			System.out.println("[Error] : " + e.getMessage());
    		} catch(SQLException e) {
    			System.out.println("[Error] : " + e.getMessage());
    		} finally {
    			if(conn != null) { conn.close();}
    			if(pstmt != null) { pstmt.close();}
    			if(rs != null) { rs.close();}
    		}
    	}
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			window.onload = function() {
				document.getElementById('btn').onclick = function() {
					document.frm.submit();
				}
			}
		</script>
	</head>
	<body>
		<form action="zipcode.jsp" method="post" name="frm">
			<fieldset>
				<legend>우편번호 검색</legend>
				<label for="dong">동이름 입력</label>
				<input type="text" id="dong" name="dong" size="40" placeholder="동이름 입력">
				<input type="button" id="btn" value="우편번호 검색">
			</fieldset>
		</form>
		<%= sbHtml.toString() %>
	</body>
</html>