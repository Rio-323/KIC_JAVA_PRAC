<%@page import="com.example.model.AlbumTO"%>
<%@ page import="com.example.model.ImageTO" %>
<% response.setContentType("text/html;charset=UTF-8"); %>
<%@ page import="java.io.PrintWriter" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>

<%
	request.setCharacterEncoding( "utf-8" );
	String seq = request.getParameter( "seq" );
	String cpage = request.getParameter( "cpage" );
	
	AlbumTO albumTO = (AlbumTO)request.getAttribute( "album" );
	ImageTO imageTO = (ImageTO)request.getAttribute( "image" );
	
	String writer = albumTO.getWriter();
	String subject = albumTO.getSubject();
	String content = albumTO.getContent();
	String filename = imageTO.getImageName();
	String mail[] = null;
	if(albumTO.getMail() == null || albumTO.getMail().equals("")) {
		mail = new String[] {"", ""};
	} else {
		mail = albumTO.getMail().split("@");
	}

%>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/board_write.css">
<script type="text/javascript">
window.navigator.geolocation.getCurrentPosition( function(position) {
	var lat = position.coords.latitude;
	var lng = position.coords.longitude;
	
	console.log( lat + "/" + lng );
	document.mfrm.latitude.value = lat;
	document.mfrm.longitude.value = lng;
}, function(error) {
	switch(error.code){
		case error.PERMISSION_DENIED:
			str = "사용자 거부";
			break;
		case error.POSITION_UNAVAILABLE:
			str = "지리정보 없음";
			break;
		case error.TIMEOUT:
			str = "시간 초과";
			break;
		case error.UNKOWN_ERROR:
			str = "알 수 없는 에러";
			break;
	}
})
window.onload = function() {
	document.getElementById('submit1').onclick = function() {
		if( document.mfrm.subject.value.trim() == '' ) {
			alert( '제목을 입력해주세요' );
			return false;
		}
		if ( document.mfrm.password.value.trim() == '' ) {
			alert( '비밀번호를 입력해주세요' );
			return false;
		}
		if ( document.mfrm.content.value.trim() == '' ) {
			alert( '내용을 입력해주세요' );
			return false;
		}
		document.mfrm.submit();
	}
}
</script>


</head>

<body>
<!-- 상단 디자인 -->
<div class="contents1"> 
	<div class="con_title"> 
		<p style="margin: 0px; text-align: right">
			<img style="vertical-align: middle" alt="" src="images/home_icon.gif" /> &gt; 커뮤니티 &gt; <strong>여행지리뷰</strong>
		</p>
	</div> 

	<form action="modify_ok.do" method="post" name="mfrm" enctype="multipart/form-data" >
		<input type="hidden" name="seq" value="<%= seq %>">
		<input type="hidden" name="cpage" value="<%= cpage %>">
		<div class="contents_sub">
		<!--게시판-->
			<div class="board_write">
				<table>
				<tr>
					<th class="top">글쓴이</th>
					<td class="top" colspan="3"><input type="text" name="writer" value="<%= writer %>" class="board_view_input_mail" maxlength="5" /></td>
				</tr>
				<tr>
					<th>제목</th>
					<td colspan="3"><input type="text" name="subject" value="<%=subject %>" class="board_view_input" /></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td colspan="3"><input type="password" name="password" value="" class="board_view_input_mail"/></td>
				</tr>
				<tr>
					<th>내용</th>
					<td colspan="3">
						<textarea name="content" class="board_editor_area"><%=content %></textarea>
					</td>
				</tr>
				<tr>
					<th>이미지</th>
					<td colspan="3">
<%-- 						<!--기존 이미지 : <%=filename %><br /><br />--> --%>
						<input type="file" name="upload" value="<%=filename %>" class="board_view_input" /><br /><br />
						위도 : <input type="text" name="latitude" value="" class="board_view_input_mail" readonly/> / 
						경도 : <input type="text" name="longitude" value="" class="board_view_input_mail" readonly/>
					</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td colspan="3"><input type="text" name="mail1" value="<%=mail[0] %>" class="board_view_input_mail"/> @ <input type="text" name="mail2" value="<%=mail[1] %>" class="board_view_input_mail"/></td>
				</tr>
				</table>
			</div>

			<div class="btn_area">
				<div class="align_left">			
					<input type="button" value="목록" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='./list.do?cpage=<%=cpage %>'" />
					<input type="button" value="보기" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='./view.do?cpage=<%=cpage %>&seq=<%=seq %>'" />
				</div>
				<div class="align_right">			
					<input type="button" value="수정" class="btn_write btn_txt01" style="cursor: pointer;" id="submit1"/>
				</div>	
			</div>	
			<!--//게시판-->
		</div>
	</form>
</div>
<!-- 하단 디자인 -->

<script src="경로/파일이름.js"></script>

</body>
</html>
