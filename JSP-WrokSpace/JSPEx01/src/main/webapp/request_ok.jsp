<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	request.setCharacterEncoding("utf-8");
    %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			out.println("data1 : " + request.getParameter("data1") + "<br><br>");
			out.println("data2 : " + request.getParameter("data2") + "<br>");
		%>
	</body>
</html>