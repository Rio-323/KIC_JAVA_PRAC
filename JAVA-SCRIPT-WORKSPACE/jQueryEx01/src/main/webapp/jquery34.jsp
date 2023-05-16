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
				document.getElementById('btn1').onclick = function() {
					$('h2').addClass('c');
				};
				
				document.getElementById('btn2').onclick = function() {
					$('h2').removeClass('c');
				};
				
				document.getElementById('btn3').onclick = function() {
					$('h2').toggleClass('c');
				};
			});
		</script>
	</head>
	<body>
		<button id="btn1">내용</button>
		<button id="btn2">변경</button>
		<button id="btn3">변경</button>
		<br><hr><br>
		<h2>header - 1</h2>
		<h2>header - 2</h2>
		<h2>header - 3</h2>
	</body>
</html>