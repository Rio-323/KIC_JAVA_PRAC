<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <jsp:useBean id="dto" class="pack1.MemberDTO"></jsp:useBean>
     <jsp:setProperty name="dto" property="id" value="tester"/>
      <jsp:setProperty name="dto" property="password" value="1234"/>
      
     <%
	 	out.println(dto.getId() + "<br>");
	 	out.println(dto.getPassword() + "<br>");
     %>
