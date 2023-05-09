<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- <c:redirect url="https://search.naver.com/search.naver?query=covid"></c:redirect> --%>

<c:redirect url="https://search.daum.net/search">
	<c:param name="w" value="tot"></c:param>
	<c:param name="q" value="카타르 월드컵"></c:param>
</c:redirect>
