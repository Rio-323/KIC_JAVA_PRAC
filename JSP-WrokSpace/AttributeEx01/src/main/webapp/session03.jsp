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
			out.println((String)session.getAttribute("data1"));
			out.println((String)session.getAttribute("data2"));
			
			// session.removeAttribute("data1");
			// session.removeAttribute("data2");
			session.invalidate();
			
			out.println((String)session.getAttribute("data1"));
			out.println((String)session.getAttribute("data2"));
		%>
	</body>
</html>