<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model1.MemberTO"%>
<%@ page import="model1.MemberDAO"%>
<%
	request.setCharacterEncoding("utf-8");

	MemberTO to = new MemberTO();
	to.setSeq(request.getParameter("seq"));
	to.setPassword(request.getParameter("password"));
	
	MemberDAO dao = new MemberDAO(); 
	int flag = dao.userDelete(to);
%>

<users>
	<flag><%= flag %></flag>
</users>