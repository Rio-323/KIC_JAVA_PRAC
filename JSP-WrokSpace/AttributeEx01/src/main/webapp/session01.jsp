<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>session01</title>
	</head>
	<body>
		<%
			out.println(session.getId() + "<br>");
		
			session.setAttribute("data1", "value1");
			session.setAttribute("data2", "value2");
		%>
	</body>
</html>