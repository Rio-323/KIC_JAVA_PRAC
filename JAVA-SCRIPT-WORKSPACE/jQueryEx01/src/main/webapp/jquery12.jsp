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
				// parent() / children()
				// prev()/ next();
				// sibling()
				
				// $('#l1').css('color', 'red');
				// $('#l1').parent().css('color', 'blue');
				
				$('#d1').children().css('color', 'blue');
				$('#d1').children('ol').css('color', 'red');
				$('#d1').prev().css('color', 'green');
				$('#d1').next().css('color', 'green');
			});
		</script>
	</head>
	<body>
		<div>
			<div>내용1</div>
			<div>내용1</div>
			
			<div id="d1">
				<ul>
					<li id="l1">사과</li>
					<li>수박</li>
					<li>딸기</li>
				</ul>
				
				<ol>
					<li id="l2">사과</li>
					<li>수박</li>
					<li>딸기</li>
				</ol>
			</div>
			
			<div>내용3</div>
			<div>내용4</div>
		</div>
	</body>
</html>