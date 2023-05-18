<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="./css/base/jquery-ui.css">
		<style type="text/css">
		</style>
		<script type="text/javascript" src="./js/jquery-3.7.0.js"></script>
		<script type="text/javascript" src="./js/jquery-ui.js"></script>
		<script type="text/javascript" src="./js/datepicker-ko.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				// 새창
				// window.open
				$('#btn1').button().on('click', function() {
					open('https://www.naver.com', 'winopen', 'width=640, height=960');
				});
				// jQuery
				// dialog
				
				// $('#dialog').dialog();
				$('#dialog').dialog({
					autoOpen: false
				});
				
				$('#btn2').button().on('click', function() {
					$('#dialog').dialog('open');
				});
				
			});
		</script>
	</head>
	<body>
		<button id="btn1">새창 열기</button>
		<button id="btn2">Dialog 열기</button>
		<br><hr><br>
		
		<div id="dialog" title="jQuery 다이얼로그">
			<h1>Hello 다이얼로그</h1>
		</div>
	</body>
</html>