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
				$('h1').each(function(index, item) {
					// console.log(index, ' / ', item);
					// console.log(item.innerHTML);
					// console.log(this.innerHTML);
					
					this.innerHTML = 'New Text : ' + index;
				});
			});
		</script>
	</head>
	<body>
		<h1>Header - 1</h1>
		<h1>Header - 2</h1>
		<h1>Header - 3</h1>
		<h1>Header - 4</h1>
		<h1>Header - 5</h1>
	</body>
</html>