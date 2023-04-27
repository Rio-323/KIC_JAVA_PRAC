<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="pack1.MemberDTO" %>
    <%
    	MemberDTO dto = new MemberDTO();
    	dto.setId("tester");
    	dto.setPassword("1234");
    	
    	out.println(dto.getId() + "<br>");
    	out.println(dto.getPassword() + "<br>");
    %>
	