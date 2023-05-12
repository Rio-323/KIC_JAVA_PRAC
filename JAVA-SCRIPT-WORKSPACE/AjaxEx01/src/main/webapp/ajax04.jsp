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
								
								// 문자열 방식
								// console.log( typeof request.responseText);
								
								// XML 객체 형식
								// console.log(request.responseXML);
								
								const xmlData = request.responseXML;
								const names = xmlData.getElementsByTagName('name');
								const publishers = xmlData.getElementsByTagName('publisher');
								const authors = xmlData.getElementsByTagName('author');
								const prices = xmlData.getElementsByTagName('price');
								
								// console.log(names);
								// console.log(names.length);
								// console.log(names[0]);
								// console.log(names[0].innerHTML);
								
								let result = '<table border="1">';
								
								for(let i = 0; i < names.length; i++) {
									result += '<tr>';
									result += '<td>' + names[i].innerHTML + '</td>';
									result += '<td>' + publishers[i].innerHTML + '</td>';
									result += '<td>' + authors[i].innerHTML + '</td>';
									result += '<td>' + prices[i].innerHTML + '</td>';
									result += '</tr>';
								}
								
								result += "</table>";
								
								document.getElementById('result').innerHTML = result;
							} else {
								alert('페이지 오류');
							}
						}
					};
				
					request.open("get", "xml1.jsp", true);
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

