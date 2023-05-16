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
				// innerHTML -> html();
				// textContent -> text();
				document.getElementById('btn1').onclick = function() {
					const html = document.getElementById('result');
					// Javascript 방식
					console.log(html.innerHTML);
					console.log(html.textContent);
					
					// jQuery
					console.log($('#result').html());
					console.log($('#result').text());
				};
			});
		</script>
	</head>
	<body>
		<button id="btn1">내용 확인</button>
		<br><hr><br>
		<div id="result"><b>출력내용</b></div>
	</body>
</html>