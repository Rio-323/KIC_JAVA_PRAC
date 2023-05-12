<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ajax01.jsp -->

<!-- 

동기(Synchronous) 방식과 비동기(Asynchronous) 방식은 프로그래밍에서 매우 중요한 개념입니다.

동기 방식은 작업을 순차적으로 처리하며, 이전 작업이 완료되어야 다음 작업을 처리합니다. 이렇게 하면 프로그램의 흐름을 예측하기 쉬우며, 간단한 구현이 가능합니다. 
하지만, 작업이 길어지거나 대기시간이 발생할 경우, 작업이 끝날 때까지 다음 작업을 처리하지 못하므로, 시간적인 효율성이 떨어집니다.

반면 비동기 방식은 작업이 완료되지 않은 상태에서 다음 작업을 처리할 수 있으므로, 작업의 처리 속도가 빨라집니다. 
이를 위해 작업을 요청한 후 결과를 기다리지 않고, 다른 작업을 처리할 수 있도록 비동기 방식에서는 작업을 처리하는 함수가 콜백 함수를 받습니다. 콜백 함수는 비동기 작업이 완료되면 실행됩니다. 
이러한 비동기 방식은 대용량 처리나 네트워크 작업 등에서 유용하게 사용됩니다.

예를 들어, 웹 페이지를 로딩할 때, 동기 방식은 해당 페이지의 모든 요소를 다운로드하고 해석하는 작업을 완료해야 화면에 렌더링이 됩니다. 
반면 비동기 방식은 필요한 요소만 먼저 다운로드하고 화면에 먼저 렌더링을 시작한 후, 나머지 요소들을 다운로드하여 순차적으로 렌더링하는 방식을 취합니다. 이렇게 하면 페이지 로딩이 빨라지며, 사용자 경험도 좋아집니다.

 -->


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
					
					// false - 동기처리 / true - 비동기 처리
					request.open("get", "csv1.jsp", false);
					request.send();
					
					console.log(request.responseText);
				};
				
				document.getElementById('btn2').onclick = function() {
					
					const request = new XMLHttpRequest();
					
					console.log("1");
					
					request.onreadystatechange = function() {
						// console.log(request.readyState);
						
						if(request.readyState == 4) {
							if(request.status == 200) {
								console.log("2");
								console.log(request.responseText);
							} else {
								alert('페이지 오류');
							}
						}
					};
				
					request.open("get", "csv1.jsp", true);
					request.send();
					console.log("3");
					
					// console.log(request.responseText);
				};
			};
		</script>
	</head>
	<body>
		<button id="btn1">요청하기</button>
		
		<button id="btn2">요청하기</button>
	</body>
</html>

