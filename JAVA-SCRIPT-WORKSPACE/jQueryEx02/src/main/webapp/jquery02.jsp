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
				
					$.ajax({
						url : './data/xml1.jsp',
						type : 'get',
						dataType : 'xml',
						success : function(xmlData) {
							let html = '<table border="1">';
							
							$(xmlData).find('book').each(function() {
								html += '<tr>';
								html += '<td>' + $(this).find('name').text() + '</td>';
								html += '<td>' + $(this).find('publisher').text() + '</td>';
								html += '<td>' + $(this).find('author').text() + '</td>';
								html += '<td>' + $(this).find('price').text() + '</td>';
								html += '</tr>';
							});
							
							html += '</table>';
							
							$('#result').html(html);
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
		<div id="result"></div>
	</body>
</html>