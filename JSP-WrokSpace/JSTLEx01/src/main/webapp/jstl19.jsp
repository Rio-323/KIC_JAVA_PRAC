<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

					
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<c:set var="str1" value="    Hello JSTL, Hello JSTL    "></c:set>
		
		문자열의 길이 : ${ fn:length( str1 ) }<br>
		문자열 추출 : ${ fn:substring( str1, 3, 6 ) }<br>
		여백 제거 : ${ fn:trim( str1 ) }<br>
		
	</body>
</html>
