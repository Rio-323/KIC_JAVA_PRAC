<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
		  table {
		    width: 1000px;
		    height: 600px;
		    border-collapse: collapse;
		  }
		  th, td {
		    border: 1px solid black;
		    text-align: center;
		    padding: 10px;
		  }
		  th {
		    height: 40px;
		    font-weight: bold;
		  }
		</style>
	</head>
	<body>
		<table>
		  <tr>
		    <th> </th>
		    <c:forEach var="i" begin="1" end="9">
		      <th>X${i}</th>
		    </c:forEach>
		  </tr>
		  <c:forEach var="i" begin="1" end="9">
		    <tr>
		      <th>${i}단</th>
		      <c:forEach var="j" begin="1" end="9">
		        <td>${i} x ${j} = ${i*j}</td>
		      </c:forEach>
		    </tr>
		  </c:forEach>
		</table>
	</body>
</html>