<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- setCookies.jsp -->
		<%
			Cookie cookie = new Cookie("data1", "value1");
			cookie.setMaxAge(30 * 60); // 30분
			response.addCookie(cookie);
			
			Cookie cookie2 = new Cookie("data2", "value2");
			cookie2.setMaxAge(30 * 60); // 30분
			response.addCookie(cookie2);
		%>
	</body>
</html>