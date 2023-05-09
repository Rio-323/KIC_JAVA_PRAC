<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<c:url var="url1" value="./list.do"></c:url>
		${ url1 }<br>
		
		<c:url var="url2" value="https://search.daum.net/search">
			<c:param name="w" value="tot"></c:param>
			<c:param name="q" value="카타르 월드컵"></c:param>
		</c:url>
		
		${ url2 }<br>
		
		<c:redirect url="${ url2 }"></c:redirect>
	</body>
</html>
