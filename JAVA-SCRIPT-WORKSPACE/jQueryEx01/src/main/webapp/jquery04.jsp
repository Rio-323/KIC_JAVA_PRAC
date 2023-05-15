<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
		<script type="text/javascript">
		// jQuery -> HTML문서에 쉽게 접근하기 위해 사용
		// Selector <- Css
		// $('selector').처리할 내용...
		// css(css 효과)
		// css('color', 'red') -> 글자색
		// css('backgroundColor', 'red') -> 배경색
			$(document).ready(function(){
				// $('*').css('color', 'red');
				$('*').css({
					color : 'blue'
				});
			});
		</script>
	</head>
	<body>
		<h2>Header-1</h2>
		<h3>Header-2</h3>
		
		<h2>Header-3</h2>
		<h3>Header-4</h3>
	</body>
</html>