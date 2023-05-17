<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="./css/cupertino/jquery-ui.css">
		<style type="text/css">
			body {font-size: 80%;}
		</style>
		<script type="text/javascript" src="./js/jquery-3.7.0.js"></script>
		<script type="text/javascript" src="./js/jquery-ui.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$('#progressbar').progressbar({
					value : 50
				});
			});
		</script>
	</head>
	<body>
		<div id="progressbar"></div>
	</body>
</html>