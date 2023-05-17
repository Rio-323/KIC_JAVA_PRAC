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
		   $('#sido').selectmenu({
			   width: 150,
			   change: function() {
				   $.ajax({
					  // url: './data/gugun.jsp?sido=' + $('#sido').val(),
					  url: './data/gugun.jsp',
					  type: 'get',
					  data: {
						  sido: $('#sido').val()
					  },
					  dataType: 'xml',
					  success: function(xml) {
						  $('#gugun').empty();
						  
						  $('#gugun').html('<option disabled="disabled" selected="selected">구군 선택</option>');
						  $(xml).find('gugun').each(function() {
							  $('#gugun').append('<option>' + $(this).text() + '</option>');
						  });
						  
						  $('#gugun').selectmenu('refresh');
					  },
					  
					  error: function(e) {
						  alert('[Error] : ' + e.status);
					  }
				   });
			   }
		   });
		   
		   $('#gugun').selectmenu({
			   width: 150,
			   change: function() {
				   
			   }
		   });
		   
		   $('#dong').selectmenu({
			   width: 150,
			   change: function() {
				   
			   }
		   });
		   
		   $('#btn').button();
		   
		   $.ajax({
			  url: './data/sido.jsp',
			  type: 'get',
			  dataType: 'xml',
			  success: function(xml) {
				  $('#sido').html('<option disabled="disabled" selected="selected">시도 선택</option>');
				  $(xml).find('sido').each(function() {
					  $('#sido').append('<option>' + $(this).text() + '</option>');
					 
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
		<fieldset>
			<legend>우편번호 검색</legend>
			<label for="sido">시도</label>
			<select id="sido">
				<option disabled="disabled" selected="selected">시도 선택</option>
			</select>
			
			<label for="gugun">구군</label>
			<select id="gugun">
				<option disabled="disabled" selected="selected">구군 선택</option>
			</select>
			
			<label for="dong">동</label>
			<select id="dong">
				<option disabled="disabled" selected="selected">동 선택</option>
			</select>
			<button id="btn">우편번호 검색</button>
		</fieldset>
		<br><hr><br>
		
		<div id="result">
			<table border="1" width="800">
				<tr>
					<td>우편번호</td>
					<td>시도</td>
					<td>구군</td>
					<td>동</td>
					<td>리</td>
					<td>번지</td>
				</tr>
			</table>
		</div>
	</body>
</html>
