<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				// 속성
				$('input[type="text"]').css('background-color', 'red');
				$('input[data="text2"]').css('background-color', 'blue');
			});
		</script>
	</head>
	<body>
		<input type="text" data="text1"><br>
		<input type="password" data="text2"><br>
	</body>
</html>