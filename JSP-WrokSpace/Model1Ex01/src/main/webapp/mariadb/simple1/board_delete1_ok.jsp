<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="model1.BoardDTO"%>
<%@page import="model1.BoardDAO"%>
<%
	request.setCharacterEncoding("utf-8");
	BoardDTO dto = new BoardDTO();
	
	dto.setSeq(request.getParameter("seq"));
	dto.setPasword(request.getParameter("password"));
	
	BoardDAO dao = new BoardDAO();
	int flag = dao.boardDeleteOk(dto);
	
	out.println("<script type='text/javascript'>");
	if(flag == 0) {
		out.println("alert('게시글 삭제 성공');");
		out.println("location.href='board_list1.jsp';");
	} else if(flag == 1) {
		out.println("alert('비밀번호 오류');");
		out.println("history.back();");
	} else {
		out.println("alert('게시글 삭제 실패');");
		out.println("history.back();");
	}
	out.println("</script>");
%>