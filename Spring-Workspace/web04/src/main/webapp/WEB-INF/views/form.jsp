<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		form.jsp<br><br>
		
		<form action="form_ok.do" method="get">
			데이터1 <input type="text" name="data1">
			<input type="submit" value="전송">
		</form>
		<br><hr><br>
		
		<form action="form_ok.do" method="post">
			데이터2 <input type="text" name="data2">
			<input type="submit" value="전송">
		</form>
	</body>
</html>