<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="model1.BoardDTO" %>

<%
	int flag = (Integer)request.getAttribute("flag");
	
	
	out.println("<script type='text/javascript'>");
	if(flag == 0) {
		out.println("alert('게시글 작성 성공');");
		out.println("location.href='./controller?path=list';");
	} else {
		out.println("alert('게시글 작성 실패');");
		out.println("history.back();");
	}
	out.println("</script>");
%>