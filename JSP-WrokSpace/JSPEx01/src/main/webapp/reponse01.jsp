<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	// redirect - 자동 이동
    	
    	// JSP
    	// response.sendRedirect("https://www.daum.net");
    
    	//  JS
    	out.println("<script type='text/javascript'>");
    	out.println("alert('성공 후 실행')");
    	out.println("location.href='https://www.daum.net'");
    	out.println("</script>");
    %>
