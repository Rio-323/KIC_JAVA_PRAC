<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="model1.BoardDTO"%>
<%@page import="model1.BoardDAO"%>

<%
	request.setCharacterEncoding("utf-8");
	BoardDTO dto = new BoardDTO();
	
	dto.setSubject(request.getParameter("subject"));
	dto.setSeq(request.getParameter( "seq" ));
	dto.setMail("");
	if(!request.getParameter("mail1").equals("") && !request.getParameter("mail2").equals("")) {
		dto.setMail(request.getParameter("mail1") + "@" + request.getParameter("mail2"));
	}
	
	dto.setPasword(request.getParameter("password"));
	dto.setContent(request.getParameter("content"));
	
	BoardDAO dao = new BoardDAO();
	int flag = dao.boardModifyOk(dto);
	
	out.println("<script type='text/javascript'>");
	if(flag == 0) {
		out.println("alert('게시글 수정 성공');");
		out.println("location.href='board_view1.jsp?seq=" + dto.getSeq() + "';");
	} else if(flag == 1) {
		out.println("alert('비밀번호 오류');");
		out.println("history.back();");
	} else {
		out.println("alert('게시글 수정 실패');");
		out.println("history.back();");
	}
	out.println("</script>");
	
%>