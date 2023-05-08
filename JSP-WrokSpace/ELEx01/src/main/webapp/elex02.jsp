<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
	
		${ 2 + 5 }<br>
		${ 2 - 5 }<br>
		${ 2 * 5 }<br>
		${ 2 / 5 }<br>
		${ 2 % 5 }<br>
		${ 2 div 5 }<br>
		${ 2 mod 5 }<br>
		
		<!-- 문자열이 아님 -> 자동형 변환 -->
		${ "2" + 5 }<br>
		${ "2" + "5" }<br>
		
		<%-- ${ "일" + "5" }<br> -> 오류 발생 --%>
		${ "일" } ${ "5" }<br>
		${ 2 } ${ 5 }<br>
	</body>
</html>