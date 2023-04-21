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
    	
    	StringBuilder sbHtml = new StringBuilder();
    	
    	sbHtml.append("<table width='800' border='1'");
    	
		for(int i = startDan; i <= endDan; i++ ) {
			sbHtml.append("<tr>");
			for(int j = 1; j < 10; j++) {
				sbHtml.append("<td>" + i + " X " + j + " = " + (i*j) + "</td>");
			}
			sbHtml.append("</tr>");
		}
		
		out.println("</table>");
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>구구단 출력</title>
	</head>
	<body>
		<!-- 구구단 출력 -->
		<%= sbHtml.toString() %>
	</body>
</html>