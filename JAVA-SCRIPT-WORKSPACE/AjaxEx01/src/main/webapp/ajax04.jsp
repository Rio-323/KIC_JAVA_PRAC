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
								const data = request.responseText.trim();
								const jsonData = JSON.parse(data);
								
								// console.log(jsonData);
								// console.log(jsonData[0].name);
								
								let result = '<table border="1">';
								
								for(let i = 0; i < jsonData.length; i++) {
									result += '<tr>';
									result += '<td>' + jsonData[i].name + '</td>';
									result += '<td>' + jsonData[i].publisher + '</td>';
									result += '<td>' + jsonData[i].author + '</td>';
									result += '<td>' + jsonData[i].price + '</td>';
									result += '</tr>';
								}
								
								result += "</table>";
								
								document.getElementById('result').innerHTML = result;
								
							} else {
								alert('페이지 오류');
							}
						}
					};
				
					request.open("get", "json2.jsp", true);
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

