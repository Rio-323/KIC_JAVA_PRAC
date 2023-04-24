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
					// alert('버튼 클릭');
					if(document.frm.year.value.trim() == '') {
						alert('년도를 입력하셔야 합니다.');
						return;
					}
					
					if(document.frm.month.value.trim() == '') {
						alert('월을 입력하셔야 합니다.');
						return;
					} else if(document.frm.month.value.trim() > 12 || document.frm.month.value.trim() < 1) {
						alert('1월 부터 12월 사이의 값이여야 합니다.')
						return;
					}
					
					document.frm.submit();
				}
			}
		</script>
	</head>
	<body>
		<form action="calendar_ok1.jsp" method="post" name="frm">
			년도 : <input type="text" name="year"><br><br>
			월 : <input type="text" name="month"><br><br>
			<input type="button" id="btn" value="달력 보기">
		</form>
	</body>
</html>