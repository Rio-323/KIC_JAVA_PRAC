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
		   $('#files').selectmenu({
			   width: 500,
			   change: function() {
				   console.log($(this).val());
				   console.log($('option:selected', this).text());
			   }
		   });
		});
		</script>
	</head>
	<body>
		<select id="files">
			<option disabled="disabled" selected="selected">선택하세요</option>
			<optgroup label="classA">
				<option value="jquery">jquery.js</option>
				<option value="jqueryui">jqueryui.js</option>
			</optgroup>
			
			<optgroup label="classB">
				<option value="jquery">jquery.js</option>
				<option value="jqueryui">jqueryui.js</option>
			</optgroup>
			
			<optgroup label="classC">
				<option value="jquery">jquery.js</option>
				<option value="jqueryui">jqueryui.js</option>
			</optgroup>
		</select>
	</body>
</html>
