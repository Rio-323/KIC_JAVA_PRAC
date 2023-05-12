<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model1.BoardTo" %>
<%@ page import="model1.BoardDao" %>
<%@ page import="mapper.BoardMapperInter" %>



<%
	request.setCharacterEncoding( "utf-8" );



	BoardTo to = new BoardTo();
	
	String searchKey = request.getParameter( "searchKey" );
	String searchWord = request.getParameter( "searchWord" );
	to.setSeq(request.getParameter("seq"));
	to.setSubject( request.getParameter( "subject" ) );
	to.setMail( "" ) ;
	if( !request.getParameter("mail1").equals("") 
			&& !request.getParameter("mail2").equals("") ) {
		to.setMail( request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" ) );	
	}
	
	to.setPassword( request.getParameter( "password" ) );
	to.setContent( request.getParameter( "content" ) );
	
	BoardDao dao = new BoardDao();
	int flag = dao.boardModifyOk(to);
	out.println( "<script type='text/javascript'>" );
	if( flag == 0 ) {
		out.println( "alert('글수정에 성공');" );
		out.println( "location.href='board_view1.jsp?searchKey=" + searchKey + "&searchWord=" + searchWord + "&seq=" + to.getSeq() + "'" );
	} else if( flag == 1 ) {
		out.println( "alert('비밀번호 오류');" );
		out.println( "history.back();" );
	} else {
		out.println( "alert('글수정에 실패');" );
		out.println( "history.back();" );
	}
	out.println( "</script>" );
%>





