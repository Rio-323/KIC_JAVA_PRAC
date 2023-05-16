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
				document.getElementById('btn1').onclick = function() {
					
					// 1개만 출력
					// console.log($('img').attr('src'));	
					
					// 전체
					/* $('img').each(function(index, item) {
						console.log($(item).attr('src'));
					}); */
					
					$('img').attr('src', function(index, item) {
						console.log(item);
					});
				};
				
				
				document.getElementById('btn2').onclick = function() {
					// $('img').attr('width', 100);
					/* $('img').attr('width', function(index) {
						return (index + 1) * 100;
					}); */
					
					$('img').attr({
						width : function(index) {
							return (index + 1) * 100;
						},
						height:200
					});
				};	
				
				
				document.getElementById('btn3').onclick = function() {
					
					$('img').removeAttr('height');
					
					$('img').each(function(index, item) {
						console.log($(item).attr('data'));
					});
						
				};		
			});
		</script>
	</head>
	<body>
		<button id="btn1">속성 내용</button>
		<button id="btn2">속성 수정</button>
		<button id="btn3">속성 제거</button>
		<br><hr><br>
		<img src="./images1/Chrysanthemum.jpg" width="150" data="1">
		<img src="./images1/Desert.jpg" width="150" data="2">
		<img src="./images1/Hydrangeas.jpg" width="150" data="3">
		<img src="./images1/Jellyfish.jpg" width="150" data="4">
	</body>
</html>