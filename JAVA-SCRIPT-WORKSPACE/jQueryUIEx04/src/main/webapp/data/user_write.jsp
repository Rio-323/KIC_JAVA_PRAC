<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model1.MemberTO" %>
 <%@ page import="model1.MemberDAO" %>
<%
	request.setCharacterEncoding("utf-8");
	
	MemberTO to = new MemberTO();
	to.setName(request.getParameter("name"));
	to.setPassword(request.getParameter("password"));
	to.setEmail(request.getParameter("email"));
	to.setAddress(request.getParameter("address"));
	
	MemberDAO dao = new MemberDAO();
	int flag = dao.userWrite(to);
	
%>
<users>
	<flag><%= flag %></flag>
</users>