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
								alert('정상');
								console.log(request.responseText.trim());
							} else {
								alert('페이지 처리 에러');
							}
						}
					};
					
					// https://kobis.or.kr - 서버에서 정책으로 데이터 접근을 허용
					// 나머지 - 디폴트로 데이터  접근 거부
					// => 강제로 가져오는 법
					
					
					// request.open('get', './data/xml.jsp', true);
					// request.open('get', 'https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.xml?key=f5eef3421c602c6cb7ea224104795888&targetDt=20230513', true);
					request.open('get', 'http://rss.etnews.com/02.xml', true);
					request.send();
				};
			};
		</script>
	</head>
	<body>
		<button id="btn">요청하기</button>
		<br><hr><br>
		<div id="result"></div>
	</body>
</html>