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
				const array = [
					{name : "daum", link : "https://www.daum.net"},
					{name : "naver", link : "https://www.naver.com"},
					{name : "google", link : "https://www.google.com"}
				];
				
				// console.log(array);
				
				/* for(let i = 0; i < array.length; i++) {
					console.log(array[i].name, ' / ', array[i].link);
				}
				
				// for in
				for(let i in array) {
					  console.log(array[i].name, ' / ', array[i].link);
				}
				
				// for each
				array.forEach(function(item){
					console.log(item.name, ' / ', item.link);
				}); */
				
				$.each(array, function(index, item) {
					// console.log('array');
					console.log(index, ' / ', item.name, ' / ', item.link);
				});
			});
		</script>
	</head>
	<body>
		
	</body>
</html>