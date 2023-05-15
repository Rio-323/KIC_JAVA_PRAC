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
					
				// $('tr').eq(0).css('color', 'blue');
				// $('tr').first().css('color', 'blue');
				// $('tr').last().css('color', 'blue');
				$('tr').eq(-2).css('color', 'blue');
				
				
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