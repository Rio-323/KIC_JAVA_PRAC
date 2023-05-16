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
				document.getElementById('btn').onclick = function() {
					// 집합적 적용
					// $('div').html('<i>새로운결과<i>');
					
					$('div').html(function(index) {
						return '<i>새로운 결과 ' + index + '<i>'
					});
				};
			});
		</script>
	</head>
	<body>
		<button id="btn">내용 확인</button>
		<br><hr><br>
		<div><b>출력내용1</b></div>
		<div><b>출력내용2</b></div>
		<div><b>출력내용3</b></div>
	</body>
</html>