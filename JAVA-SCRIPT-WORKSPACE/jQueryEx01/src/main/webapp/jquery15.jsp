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
				const array = [
					{name : "daum", link : "https://www.daum.net"},
					{name : "naver", link : "https://www.naver.com"},
					{name : "google", link : "https://www.google.com"}
				];
				
				let output = '';
				
				$.each(array, function(index, item) {
					output += '<a href="' + item.link + '">';
					output += '<div>' + item.name + '</div>';
					output += '</a>'
				});
				
				document.body.innerHTML = output;
			});
		</script>
	</head>
	<body>
		
	</body>
</html>