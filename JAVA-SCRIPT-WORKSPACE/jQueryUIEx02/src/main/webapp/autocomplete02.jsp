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
				
				$.ajax({
					url: './data/json.jsp',
					type: 'get',
					dataType: 'json',
					success: function(json) {
						$('#tags').autocomplete({
							source: json.data
						});
					},
					error: function(e) {
						alert('[Error] : ' + e.status);
					}
				});
				
				
			});
		</script>
	</head>
	<body>
		<div>
			<label for="">Program Language</label>
			<input type="text" id="tags">
		</div>
	</body>
</html>