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
				// console.log($(document).find('h2'));
				// $(document).find('h2').each(function(index, item) {
				$(document).find('.c').each(function(index, item) {
					console.log(index, ' : ', item.innerHTML);
				});
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