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
		<c:set var="intArr" value="<%= new int[] {1, 2, 3, 4, 5} %>"></c:set>
		<c:out value="${ intArr[0] }"></c:out><br>
		<c:out value="${ intArr[1] }"></c:out><br>
		<hr><br>
		
		<c:forEach var="data" items="${ intArr }" begin="2" end="4" varStatus="status">
			<c:out value="${ data } / ${ status.index }"></c:out><br>
		</c:forEach>
		<hr><br>
		
		<c:set var="strArr" value='<%= new String[] {"11", "22", "33", "44", "55"} %>'></c:set>
		<c:forEach var="data" items="${ strArr }">
			<c:out value="${ data }"></c:out><br>
		</c:forEach>
		<hr><br>
		
		<c:set var="hm1" value='<%= new HashMap() %>'></c:set>
		<c:set target="${ hm1 }" property="name" value="홍길동"></c:set>
		<c:set target="${ hm1 }" property="today" value="<%= new Date() %>"></c:set>
		
		<c:forEach var="data" items="${ hm1 }">
			${ data.key } - ${ data.value } <br>
		</c:forEach>
	</body>
</html>