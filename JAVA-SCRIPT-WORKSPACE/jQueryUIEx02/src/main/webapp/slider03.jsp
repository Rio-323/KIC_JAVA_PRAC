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
				$('#slider').slider({
					range: true,
					min: 0,
					max: 500,
					values: [75, 300],
					slide : function(event, ui) {
						// console.log(ui.values[0], ' / ', ui.values[1])
						console.log($(this).slider('values', 0), ' / ', $(this).slider('values', 1));
					}
				});
				
				$('#btn').button().on('click', function() {
					console.log($('#slider').slider('value'));
				});
			});
		</script>
	</head>
	<body>
		<div id="slider"></div>
		<br><hr><br>
		<button id="btn">값 확인</button>
	</body>
</html>