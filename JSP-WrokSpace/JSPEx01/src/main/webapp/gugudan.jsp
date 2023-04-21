<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- 시작단과 끝단 입력 -->
		
		<form action="gugudan_ok2.jsp" method="post">
			시작단 : <input type="text" name="startDan">
			&nbsp;&nbsp;~&nbsp;&nbsp;
			끝단 : <input type="text" name="endDan">
			<input type="submit" value="구구단 출력">
		</form>
	</body>
</html>