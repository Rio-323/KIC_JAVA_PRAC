<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		-- include 이전<br>
		<%
			 // pageContext.include("./include1/include.jsp");
			// 출력결과를 바꿔치기 한다.
			pageContext.forward("./include1/include.jsp");
		%>
		-- include 이후<br>
	</body>
</html>