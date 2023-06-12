<%@ page import="com.example.model.CommentTO" %>
<%@ page import="com.example.model.AlbumTO" %>
<%@page import="com.example.model.ImageTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding( "utf-8" );
// 	String cpage = request.getParameter( "cpage" );
	
	AlbumTO albumTO = (AlbumTO)request.getAttribute( "album" );
	String album_seq = albumTO.getSeq();
	String album_subject = albumTO.getSubject();
	String album_writer = albumTO.getWriter();
	String album_cmtCnt = albumTO.getCmtCnt();
	String album_wdate = albumTO.getWdate();
	String album_hit = albumTO.getHit();
	String album_content = albumTO.getContent();
	int album_wgap = albumTO.getWgap();
	
	ImageTO imageTO = (ImageTO)request.getAttribute( "image" );
	String image_seq = imageTO.getSeq();
	String image_pseq = imageTO.getPseq();
	String image_imageName = imageTO.getImageName();
	long image_imageSize = imageTO.getImageSize();
	String image_latitude = imageTO.getLatitude();
	String image_longitude = imageTO.getLongitude();
	String image_wdate = imageTO.getWdate();
	String imageName = null;
	long imageSize = 0;
	
	ArrayList<CommentTO> commentList = (ArrayList<CommentTO>)request.getAttribute( "commentList" );
	StringBuffer commentHtml = new StringBuffer();
	for(CommentTO commentTo : commentList) {
		commentHtml.append( "<table>" );
		commentHtml.append( "	<tr>" );
		commentHtml.append( "	<td class='coment_re' width='20%'>" );
		commentHtml.append( "		<strong>"+ commentTo.getWriter() +"</strong> ("+ commentTo.getWdate() +")" );
		commentHtml.append( "		<div class='coment_re_txt'>" );
		commentHtml.append( "			"+ commentTo.getContent() +"" );
		commentHtml.append( "		</div>" );
		commentHtml.append( "	</td>" );
		commentHtml.append( "</tr>" );
		commentHtml.append( "</table>" );
	}
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/board_view.css">
<script type="text/javascript">
const commentOk = function() {
	if( document.cfrm.cwriter.value.trim() == '' ) {
		alert( '작성자명을 입력해주세요' );
		return false;
	}
	if ( document.cfrm.cpassword.value.trim() == '' ) {
		alert( '비밀번호를 입력해주세요' );
		return false;
	}
	if( document.cfrm.ccontent.value.trim() == '' ) {
		alert( '댓글 내용을 입력해주세요' );
		return false;
	}
	document.cfrm.submit();
}
</script>


</head>

<body>
  
<!-- 상단 디자인 -->
<div class="contents1"> 
	<div class="con_title"> 
		<p style="margin: 0px; text-align: right">
			<img style="vertical-align: middle" alt="" src="../images/home_icon.gif" /> &gt; 커뮤니티 &gt; <strong>게시판</strong>
		</p>
	</div>	
	
	<div class="contents_sub">	
	<!--게시판-->
	</div>
		<div class="board_view">		
		 	<table>
			<tr>  
				<th width="10%">제목</th>
				<td width="60%"><%=albumTO.getSubject() %>(<%=albumTO.getWip() %>)</td>
				<th width="10%">등록일</th>
				<td width="20%"><%=albumTO.getWdate() %></td>
			</tr>
			<tr>
				<th>글쓴이</th>
				<td><%=albumTO.getWriter() %></td>
				<th>조회</th>
				<td><%=albumTO.getHit() %></td>
			</tr>
			<tr>
				<th>위치정보</th>
				<td>
					위도 : <%=imageTO.getLatitude() %> / 경도 : <%= imageTO.getLongitude() %>
				</td>
				<th></th>
				<td></td>
			</tr>
			<tr>
				<td colspan="4" height="200" valign="top" style="padding:20px; line-height:160%">
					<div id="bbs_file_wrap">
						<div>
							<img src="upload/<%=imageTO.getImageName() %>" width="900" onerror="" /><br />
						</div>
					</div>
				<%=albumTO.getContent() %> 
				</td>
			</tr>			
			</table>
<%-- 			 	<%= sbHtml %> --%>
			 	
			<%--
			<table>
			<tr>
				<td class="coment_re" width="20%">
					<strong>54545</strong> (2016.09.19 02:00)
					<div class="coment_re_txt">
						Test
					</div>
				</td>
			</tr>
			<tr>
				<td class="coment_re" width="20%">
					<strong>54545</strong> (2016.09.19 07:54)
					<div class="coment_re_txt">
						우리는 민족 중흥의 역사적 사명을 띄고 이 땅에 태어났다. 조상의 빛난 얼을 오늘에 되살려
					</div>
				</td>
			</tr>
			</table>
			--%>
			<%-- 코멘트 출력 --%>
			<%=commentHtml %>
						
			<form action="commentOk.do" method="post" name="cfrm">
			<input type="hidden" name="seq" value="<%=album_seq %>" />
<%-- 			<input type="hidden" name="cpage" value="<%=cpage %>" /> --%>
			<table>
			<tr>
			
				<td width="94%" class="coment_re">
					글쓴이 <input type="text" name="cwriter" maxlength="5" class="coment_input" />&nbsp;&nbsp;
					비밀번호 <input type="password" name="cpassword" class="coment_input pR10" />&nbsp;&nbsp;
				</td>
				<td width="6%" class="bg01"></td>
			</tr>
			<tr>
				<td class="bg01">
					<textarea name="ccontent" cols="" rows="" class="coment_input_text"></textarea>
				</td>
				<td align="right" class="bg01">
					<input type="button" id="submit1" value="댓글등록" class="btn_re btn_txt01" onclick="commentOk()"/>
				</td>
			</tr>
			</table>
			</form>
		</div>
		<div class="btn_area">
			<div class="align_left">			
				<input type="button" value="목록" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='./list.do'" />
			</div>
			<div class="align_right">
				<input type="button" value="수정" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='./modify.do?seq=<%=albumTO.getSeq()%>'" />
  			    <input type="button" value="삭제" class="btn_list btn_txt02" style="cursor: pointer;" onclick="location.href='./delete.do?seq=<%=albumTO.getSeq()%>'" /> 
				<input type="button" value="쓰기" class="btn_write btn_txt01" style="cursor: pointer;" onclick="location.href='./write.do?'" />
			</div>
		</div>
		<!--//게시판-->
	</div>
<!-- 하단 디자인 -->
</div>

</body>
</html>
