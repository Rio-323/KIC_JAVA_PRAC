<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="form_ok.do" method="get">
			데이터 : <input type="text" name="data">
			<input type="submit" value="get전송">
		</form>
		
		<form action="form_ok.do" method="post">
			데이터 : <input type="text" name="data">
			<input type="submit" value="post전송">
		</form>
	</body>
</html>