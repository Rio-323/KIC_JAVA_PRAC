<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>session02</title>
	</head>
	<body>
		<%
			out.println(session.getId() + "<br>");
			out.println(new Date(session.getCreationTime()).toLocaleString() + "<br>");
			out.println(new Date(session.getLastAccessedTime()).toLocaleString() + "<br>");
			
			// 세션의 유효시간(초단위 1800 -> 30분)
			out.println(session.getMaxInactiveInterval() + "<br>");
			
			out.println((String)session.getAttribute("data1"));
			out.println((String)session.getAttribute("data2"));
		%>
	</body>
</html>