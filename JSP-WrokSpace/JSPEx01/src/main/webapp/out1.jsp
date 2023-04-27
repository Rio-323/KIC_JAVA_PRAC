<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" buffer="1kb" autoFlush="false"%>
    <%
    	out.println("버퍼 크기 : " + out.getBufferSize() + "<br>");
    	out.println("버퍼 남은 크기 : " + out.getRemaining() + "<br>");
    	
    	for(int i = 1; i < 100; i++) {
    		out.println(i + "Hello JSP<br>");
    		if(i % 50 == 0) {
    			out.println("버퍼 남은 크기 : " + out.getRemaining() + "<br>");
    		}
    	}
    %>
