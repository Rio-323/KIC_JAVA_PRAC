<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="./css/base/jquery-ui.css">
		<style type="text/css">
			body {font-size: 80%;}
		</style>
		<script type="text/javascript" src="./js/jquery-3.7.0.js"></script>
		<script type="text/javascript" src="./js/jquery-ui.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				$('input[type="radio"]').checkboxradio({
					/* toggle button */
					icon: false
				// }).on('click', function() {
				 }).on('change', function() {
					console.log('radio change');
				});
			});
		</script>
	</head>
	<body>
		<fieldset>
			<legend>Hotel Ratings</legend>
			<label for="cb1">2 Star</label><input type="radio" name="r" id="cb1">
			<label for="cb2">3 Star</label><input type="radio" name="r" id="cb2">
			<label for="cb3">4 Star</label><input type="radio" name="r" id="cb3">
			<label for="cb4">5 Star</label><input type="radio" name="r" id="cb4">
		</fieldset>
	</body>
</html>