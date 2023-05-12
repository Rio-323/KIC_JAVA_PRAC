<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script type="text/javascript">
			window.onload = function() {
				document.getElementById('btn').onclick = function() {
					
					const request = new XMLHttpRequest();
					
					request.onreadystatechange = function() {
						
						if(request.readyState == 4) {
							if(request.status == 200) {
								// console.log(request.responseText);
								// document.getElementById('ta').value = request.responseText.trim();
								
								// table 구조로  데이터 출력
								const data = request.responseText.trim();
								const rowdatas = data.split("\n");
								
								// console.log(rowdatas.length);
								// console.log(rowdatas[0]);
								let result = '<table border="1">';
								
								for(let i = 0; i < rowdatas.length; i++) {
									let coldatas = rowdatas[i].split(',');
									result += '<tr>';
									result += '<td>' + coldatas[0] + '</td>';
									result += '<td>' + coldatas[1] + '</td>';
									result += '<td>' + coldatas[2] + '</td>';
									result += '<td>' + coldatas[3] + '</td>';
									result += '</tr>';
								}
								
								result += '</table>';
								
								// console.log(result);
								document.getElementById('result').innerHTML = result;
							} else {
								alert('페이지 오류');
							}
						}
					};
				
					request.open("get", "csv1.jsp", true);
					request.send();
				};
			};
		</script>
	</head>
	<body>
		<button id="btn">요청하기</button>
		<br><hr><br>
		<textarea id="ta" rows="10" cols="100"></textarea>
		<br><hr><br>
		
		<div id="result">
			
		</div>
	</body>
</html>

