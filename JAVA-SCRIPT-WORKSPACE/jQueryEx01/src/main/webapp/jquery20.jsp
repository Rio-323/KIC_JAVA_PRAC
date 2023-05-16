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
				
				/*  $('h1').css('background-color', 'orange');
				 $('h1, h2').css('color', 'red'); */
				 
				 $('h1').css('background-color', 'orange').add('h2').css('color', 'red');
				
			});
		</script>
	</head>
	<body>
		<h1>Header - 1</h1>
		<h2>Header - 2</h2>
		<h1>Header - 3</h1>
		<h2>Header - 4</h2>
		<h1>Header - 5</h1>
	</body>
</html>