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
	</body>
</html>