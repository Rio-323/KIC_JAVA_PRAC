<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			table {
				border : 1px solid black; 
				font-size: 15px;
				border-collapse: collapse;
			}
			
			td {
				width: 800px;
				padding: 10px;
				text-align: center;
				border : 1px solid balck; 
			}
			
			#sido {
				width: 150px;
			}
			
			#gugun {
				width: 150px;
			}
		</style>
	</head>
	<body>
		<form action="" method="post">
			<table>
				<tr>
					<td class="input">
						<select name="sido" id="sido">
							<option value="시도">시도</option>
						</select>
						
						<select name="gugun" id="gugun">
							<option value="구군">구군</option>
						</select>
						<input type="text" name="dong" id="dong" size="40">
						<input type="submit" value="우편번호검색">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>