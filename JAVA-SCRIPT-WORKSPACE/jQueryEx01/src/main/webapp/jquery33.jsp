<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			.c1 {color: red;}
			.c2 {color: pink;}
			.c3 {color: orange;}
		</style>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				document.getElementById('btn1').onclick = function() {
					// console.log($('h2').css('color'));
					$('h2').css('color', function(index, item) {
						console.log(item);
					});
				};
				
				document.getElementById('btn2').onclick = function() {
					// $('h2').css('color', 'cyan' );
					
					const colors = ['purple', 'black', 'red'];
					$('h2').css('color', function(index, item) {
						return colors[index];
					});
					
				};
			});
		</script>
	</head>
	<body>
		<button id="btn1">내용</button>
		<button id="btn2">변경</button>
		<br><hr><br>
		<h2 class="c1">header - 1</h2>
		<h2 class="c2">header - 2</h2>
		<h2 class="c3">header - 3</h2>
	</body>
</html>