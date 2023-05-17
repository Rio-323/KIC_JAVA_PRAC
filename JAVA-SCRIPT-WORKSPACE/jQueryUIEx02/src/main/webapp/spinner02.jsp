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
			table {
			    border-collapse: collapse;
			}
			table td {
			    border: 1px solid black;
			    padding: 5px;
			}
		</style>
		<script type="text/javascript" src="./js/jquery-3.7.0.js"></script>
		<script type="text/javascript" src="./js/jquery-ui.js"></script>
		<script type="text/javascript">
		$(document).ready(function() {
		    $('#start').spinner({
		        change: function(event, ui) {
		            var startValue = parseInt($('#start').val());
		            var endValue = parseInt($('#end').val());
		            
		            if (startValue >= endValue) {
		                $('#end').spinner('value', startValue + 1);
		            }
		        }
		    });
		    
		    $('#end').spinner();
		    
		    $('#btn').button().click(function() {
		        var start = parseInt($('#start').val());
		        var end = parseInt($('#end').val());
		        
		        // Clear previous results
		        $('#result').empty();
		        
		        // Create table element
		        var table = $('<table>').appendTo('#result');
		        var tbody = $('<tbody>').appendTo(table);
		        
		        // Generate multiplication table rows
		        for (var i = start; i <= end; i++) {
		            var row = $('<tr>').appendTo(tbody);
		            
		            // Generate table cells for each multiplication
		            for (var j = 1; j <= 9; j++) {
		                var cell = $('<td>').text(i + ' x ' + j + ' = ' + (i * j)).appendTo(row);
		            }
		        }
		    });
		});

		</script>
	</head>
	<body>
		<fieldset>
			<legend>구구단 출력</legend>
			<label for="start">시작단</label>
			<input type="text" id="start" value="1" readonly="readonly">
			~
			<label for="end">끝단</label>
			<input type="text" id="end" value="2" readonly="readonly">
			<button id="btn">구구단 출력</button>
		</fieldset>
		<br><hr><br>
		
		<div id="result"></div>
	</body>
</html>
