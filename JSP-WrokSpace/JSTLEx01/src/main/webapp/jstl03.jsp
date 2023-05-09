<%@page import="model1.BoardTo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="to" value="<%= new BoardTo() %>" scope="page"></c:set>
    <c:set target="${ to }" property="subject" value="제목"></c:set>
     <c:set target="${ to }" property="writer" value="작성자"></c:set>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		제목 : ${ to.subject }<br>
		작성자 : ${ to.writer }<br>
	</body>
</html>