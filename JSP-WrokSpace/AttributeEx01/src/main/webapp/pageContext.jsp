<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String data1 = "값1";
    	System.out.println(data1);
    	
    	pageContext.setAttribute("data2", "값2");
    	System.out.println((String)pageContext.getAttribute("data2"));
    	
    	pageContext.setAttribute("data3", new Date());
    	Date date = (Date)pageContext.getAttribute("data3");
    	
    	System.out.println(date.toString());
    	
    	// wrapper
    	pageContext.setAttribute("data4", 1);
    	pageContext.setAttribute("data5", Integer.valueOf(1));
    	
    	Integer i = (Integer)pageContext.getAttribute("data5");
    	System.out.println(i.intValue());
    	
    	Integer i2 = (Integer)pageContext.getAttribute("data5");
    	System.out.println(i2);
    %>
