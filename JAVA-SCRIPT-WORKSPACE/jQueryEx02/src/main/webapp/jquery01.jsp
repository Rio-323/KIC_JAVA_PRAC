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
			// ready = window.onload()
			$(document).ready(function(){
				 $('#btn').on('click', function() {
					// alert('btn click');
					$.ajax({
						url : './data/json1.jsp',
						type : 'get',
						dataType : 'json',
						success : function(csvData) {
							console.log('success : ', typeof csvData);
							console.log(csvData);
						},
						error : function() {
							console.log('fail', err.status);
							console.log('fail', err.responseText);
						}
					})
				});
			});
		</script>
	</head>
	<body>
		<button id="btn">요청</button>
		<br><hr><br>
	</body>
</html>