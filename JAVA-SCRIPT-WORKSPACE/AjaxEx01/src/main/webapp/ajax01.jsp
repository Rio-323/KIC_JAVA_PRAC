<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ajax01.jsp -->
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			window.onload = function() {
				document.getElementById('btn1').onclick = function() {
					// alert('버튼 클릭');
					const request = new XMLHttpRequest();
					request.open("get", "csv1.jsp", false);
					request.send();
					
					console.log(request.responseText)
				};
			};
		</script>
	</head>
	<body>
		<button id="btn1">요청하기</button>
	</body>
</html>