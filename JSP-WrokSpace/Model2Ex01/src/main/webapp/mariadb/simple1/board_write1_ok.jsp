<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model1.BoardDTO" %>
<%@ page import="model1.BoardDAO" %>

<%
	request.setCharacterEncoding("utf-8");
	BoardDTO dto = new BoardDTO();
	
	dto.setSubject(request.getParameter("subject"));
	dto.setWriter(request.getParameter("writer"));
	
	dto.setMail("");
	
	if(!request.getParameter("mail1").equals("") && !request.getParameter("mail2").equals("")) {
		dto.setMail( request.getParameter("mail1") + "@" + request.getParameter("mail2"));
	}
	
	dto.setPasword(request.getParameter("password"));
	dto.setContent(request.getParameter("content"));
	dto.setWip(request.getRemoteAddr());
	
	BoardDAO dao = new BoardDAO();
	int flag = dao.boardWriteOk(dto);
	
	out.println("<script type='text/javascript'>");
	if(flag == 0) {
		out.println("alert('게시글 작성 성공');");
		out.println("location.href='board_list1.jsp';");
	} else {
		out.println("alert('게시글 작성 실패');");
		out.println("history.back();");
	}
	out.println("</script>");
%>