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
			out.println("2<br>");
		%>
		
		<%= "2" %><br>
		
		<!-- Expression Language -->
		${ 2 }<br>
		${ 'test' }<br>
		${ "test" }<br>
		${ test }<br> <!-- 변수로 인식 -->
		\${ 'test' }<br> <!-- EL이 아니게 만들기 -->
	</body>
</html>