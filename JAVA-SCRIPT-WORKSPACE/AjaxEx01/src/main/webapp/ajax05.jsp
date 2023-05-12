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
								document.getElementById('ta').value = request.responseText;
								
								const xmlData = request.responseXML;
								const ranks = xmlData.getElementsByTagName('rank');
								const movieNms = xmlData.getElementsByTagName('movieNm');
								
								let result = '<table border="1">';
								
								for(let i = 0; i < ranks.length; i++) {
									result += '<tr>';
									result += '<td>' + ranks[i].innerHTML + '</td>';
									result += '<td>' + movieNms[i].innerHTML + '</td>';
									result += '</tr>';
								}
								
								result += "</table>";
								
								document.getElementById('result').innerHTML = result;
							} else {
								alert('페이지 오류');
							}
						}
					};
				
					request.open("get", "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.xml?key=f5eef3421c602c6cb7ea224104795888&targetDt=20230507", true);
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

