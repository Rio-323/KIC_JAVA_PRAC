<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel="stylesheet" href="./css/w2ui-2.0.css">
		<style type="text/css">
			#wrap {
				margin: 0 auto;
				width: 960px;
				height: 500px;
			}
		</style>
		<script type="text/javascript" src="./js/jquery-3.7.0.js"></script>
		<script type="text/javascript" src="./js/w2ui-2.0.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
				const data =  [
						{recid: 1, title: '모던 웹을 위한 HTML5 + CSS3 입문', author: '유비', publisher: '삼국미디어', price: 3000},
						{recid: 2, title: '모던 웹을 위한 JavaScript + JQuery 입문', author: '관우', publisher: '삼국미디어', price: 3000},
						{recid: 3, title: '모던 웹을 위한 Node.js 프로그래밍 입문', author: '장비', publisher: '삼국미디어', price: 3000}
					];
				
				$('#wrap').w2grid({
					name: 'grid',
					columns: [
						{field: 'title', text: '도서명', size: '40%', editable: {type: 'text'}},
						{field: 'author', text: '저자', size: '30%', editable: {type: 'text'}},
						{field: 'publisher', text: '출판사', size: '20%', editable: {type: 'text'}},
						{field: 'price', text: '가격', size: '10%', editable: {type: 'text'}}
					],
					records: data
				});
			});
		</script>
	</head>
	<body>
		<div id="wrap"></div>
	</body>
</html>