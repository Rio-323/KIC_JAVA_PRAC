<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="./css/cupertino/jquery-ui.css">
		<style type="text/css">
			body {font-size: 80%;}
		</style>
		<script type="text/javascript" src="./js/jquery-3.7.0.js"></script>
		<script type="text/javascript" src="./js/jquery-ui.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$('#progressbar').progressbar({
					value : 50
				});
				
				$('#btn1').button().on('click', function() {
					const value = $('#progressbar').progressbar('value');
					
					
					$('#progressbar').progressbar('value', value + 10);
					
					console.log(value);
				});
				
				$('#btn2').button().on('click', function() {
					const value = $('#progressbar').progressbar('value');
					
					$('#progressbar').progressbar('value', value - 10);
					
					console.log(value);
				});
			});
		</script>
	</head>
	<body>
		<div id="progressbar"></div>
		<br><hr><br>
		<button id="btn1">증가(+10)</button>
		<button id="btn2">증가(-10)</button>
	</body>
</html>