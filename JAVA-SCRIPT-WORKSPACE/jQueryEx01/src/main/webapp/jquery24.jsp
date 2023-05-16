<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				// json
				let object = {name : '홍길동'};
				console.log(object);
				
				// 동적 프로퍼티 추가 가능
				object.region1 = '서울시 종로구';
				object.part1 = '리더';
				
				console.log(object);
				
				$.extend(object, 
						{region2: '서울시 강남구', part2:'베이스'},
						{region3: '서울시 서초구', part3:'세컨드'},
				);
				console.log(object);
			});
		</script>
	</head>
	<body>
		<h2 class="c">Header - 1</h2>
		<h2>Header - 2</h2>
		<h2 class="c">Header - 3</h2>
		<h2>Header - 4</h2>
		<h2 class="c">Header - 5</h2>
	</body>
</html>