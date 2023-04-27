<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <jsp:useBean id="dto" class="pack1.MemberDTO"></jsp:useBean>
     <%
	 	dto.setId("tester");
	 	dto.setPassword("1234");
	 	
	 	out.println(dto.getId() + "<br>");
	 	out.println(dto.getPassword() + "<br>");
     %>
