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
				$('table').css('width', '800');
				
				document.getElementById('btn1').onclick = function() {
					$('tr:odd').css('background-color', 'blue');
					$('tr:even').css('background-color', 'yellow');
				};
				
				document.getElementById('btn2').onclick = function() {
					$('tr:odd').css('background-color', 'white');
					$('tr:even').css('background-color', 'white');
				};
				
			});
		</script>
	</head>
	<body>
		<button id="btn1">색상 변경</button>
		<button id="btn2">원상복구</button>
		<table border="1">
			<tr>
				<th>이름</th>
				<th>혈액형</th>
				<th>지역</th>
			</tr>
			
			<tr>
				<th>tester</th>
				<th>a</th>
				<th>서울</th>
			</tr>
			
			<tr>
				<th>tester</th>
				<th>a</th>
				<th>서울</th>
			</tr>
			
			<tr>
				<th>tester</th>
				<th>a</th>
				<th>서울</th>
			</tr>
			
			<tr>
				<th>tester</th>
				<th>a</th>
				<th>서울</th>
			</tr>
			
			<tr>
				<th>tester</th>
				<th>a</th>
				<th>서울</th>
			</tr>
		</table>
	</body>
</html>