<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
		<style type="text/css">
			.gugudan {
				display: inline-block;
				width: 200px;
				margin-right: 20px;
				vertical-align: top;
			}
		</style>
		<script type="text/javascript">
			$(document).ready(function(){
				document.getElementById('btn').onclick = function() {
					// 시작 단과 끝 단 입력값 가져오기
					var startDan = parseInt($('#startdan').val());
					var endDan = parseInt($('#enddan').val());

					let html = '<table border="1" width="800">';
					
					for(let i = startDan; i<= endDan; i++) {
						html += '<tr>';
						for(let j = 1; j <= 9; j++) {
							html += '<th>' + i + ' X ' + j + ' = ' + (i * j) + '</th>';
						}
						html += '</tr>';
					}
					
					html += '</table>';
					
					$('#result').html(html);
				};
			});
		</script>
	</head>
	<body>
		시작단   <input type="text" id="startdan">
		~
		끝단   <input type="text" id="enddan">
		<button id="btn">구구단 출력</button>
		<br><hr><br>
		<div id="result"></div>
	</body>
</html>
