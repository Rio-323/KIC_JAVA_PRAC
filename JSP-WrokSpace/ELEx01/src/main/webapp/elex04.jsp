<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%
			String name1 = "홍길동";
			pageContext.setAttribute("name2", "홍길동");
		%>
		<%= "name1 : " + name1 %><br>
		${ "name2 : "} ${ name2 }<br>
		<%= pageContext.getAttribute("name2") %> <br>
		${ pageScope.name2 }<br>
		${ pageScope['name2'] }<br>
		${ name2 }<br>
	</body>
</html>