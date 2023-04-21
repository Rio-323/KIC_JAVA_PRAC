<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");
    
    	String strStartDan = request.getParameter("startDan");
    	String strEndDan = request.getParameter("endDan");
    	
    	// System.out.println(strStartDan);
    	// System.out.println(strEndDan);
    	
    	int startDan = Integer.parseInt(strStartDan);
    	int endDan = Integer.parseInt(strEndDan);
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>구구단 출력</title>
	</head>
	<body>
		<!-- 구구단 출력 -->
		<%
			out.println("<table width='800' border='1'");
			for(int i = startDan; i <= endDan; i++ ) {
				out.println("<tr>");
				for(int j = 1; j < 10; j++) {
					out.println("<td>" + i + " X " + j + " = " + (i*j) + "</td>");
				}
				out.println("</tr>");
			}
			
			out.println("</table>");
		%>
	</body>
</html>