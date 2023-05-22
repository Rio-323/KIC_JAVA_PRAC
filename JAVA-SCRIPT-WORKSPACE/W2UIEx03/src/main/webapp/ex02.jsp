<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/w2ui-2.0.min.css" />
<style type="text/css">
	#wrap {
		margin: 0 auto;
		width: 960px;
		height: 500px;
	}
</style>
<script type="text/javascript" src="./js/jquery-3.7.0.js"></script>
<script type="text/javascript" src="./js/w2ui-2.0.min.js"></script>
<script type="text/javascript">
	$( document ).ready( function() {
		const data = [
		];
		
		$('#wrap').w2grid({
			name: 'grid',
			// 2
			url: './data/emp_json.jsp',
			show: {
				toolbar: true,
				footer: true,
				
				columnHeaders: true,
				lineNumbers: true,
			},
			columns: [
				{ field: 'empno', text: '사원번호' },
				{ field: 'ename', text: '사원이름' },
				{ field: 'job', text: '직책' },
				{ field: 'mgr', text: '관리자번호' },
				{ field: 'hiredate', text: '입사일자' },
				{ field: 'sal', text: '급여' },
				{ field: 'comm', text: '보너스' },
				{ field: 'deptno', text: '부서번호' }
			],
			// records: data,
			onRender: function(event) {
				console.log('Render 호출');
				
				// 1
				// ajax
			},
			onLoad: function(event) {
				
				// 데이터 호출 후에 발생 이벤트
				console.log('Load 호출');
				
			},
			onSearch: function(event) {
				console.log('Search 호출');
				console.log(event.detail.searchValue);
				
				// 삭제
				this.clear();
				
				event.preventDefault();
			}
		});		
	});
</script>
</head>
<body>

<div id="wrap"></div>

</body>
</html>