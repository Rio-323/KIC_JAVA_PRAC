<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="./css/base/jquery-ui.css">
		<style type="text/css">
			/* 사용자 정의 */
			body {font-size: 80%;}
		</style>
		<script type="text/javascript" src="./js/jquery-3.7.0.js"></script>
		<script type="text/javascript" src="./js/jquery-ui.js"></script>
		<script type="text/javascript">
			/* 사용자 정의 */
			$(document).ready(function() {
				$('#btn1').button({
					icon:'ui-icon-gear'
					/* 없음, top, bottom, end */
					/* iconPosition:'end' */
				});
				
				// 메서드 체이닝
				$('#btn2').button({
					icon: 'ui-icon-flag',
					/* 내용이 사라짐 */
					showLabel: false
				}).on('click', function() {
					alert('btn2 click');
				});
			});
		</script>
	</head>
	<body>
		
		<button id="btn1">버튼 1</button><br><br>
		<div id="btn2">버튼 2</div>
	</body>
</html>