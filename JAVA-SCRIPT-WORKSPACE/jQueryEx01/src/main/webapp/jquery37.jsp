<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			.c {color: red;}
		</style>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				
				/* $('#btn1').on('click', function() {
					alert('btn1 click');
				});
				
				$('#btn2').on('click', function() {
					alert('btn2 click');
				});
				
				$('#btn3').on('click', function() {
					alert('btn3 click');
				}); */
				
				$('button').on('click', function() {
					alert('button click');
				});
				
			});
		</script>
	</head>
	<body>
		<button id="btn1">버튼1</button><br><br>
		<button id="btn2">버튼2</button><br><br>
		<button id="btn3">버튼3</button><br><br>
	</body>
</html>