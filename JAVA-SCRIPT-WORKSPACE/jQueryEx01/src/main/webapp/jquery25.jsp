<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
		<script type="text/javascript">
			$.noConflict(); // $ -> 사용안하겠다.
			const J = jQuery;
			
			J(document).ready(function(){
				// console.log("Hello JQuery");
				let object = {name : '홍길동'};
				
				J.extend(object, 
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