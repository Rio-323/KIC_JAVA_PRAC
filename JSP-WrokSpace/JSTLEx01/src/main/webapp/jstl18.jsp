<%@page import="java.util.Date"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/sql" %>

<%-- <s:setDataSource var="ds" 
    dataSource="jdbc/mariadb1"
    scope="page" /> --%>
    

					
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<s:query var="rs" dataSource="jdbc/mariadb1">
			select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp where ename like 's%'
		</s:query>
		
		<table width="600" border="1">
			<tr>
				<c:forEach var="columnName" items="${ rs.columnNames }">
					<td>${ columnName }</td>
				</c:forEach>
			</tr>
			
			<c:forEach var="row" items="${ rs.rows }">
				<tr>
					<td>${ row.empno }</td>
					<td>${ row.ename }</td>
					<td>${ row.job }</td>
					<td>${ row.mgr }</td>
					<td>${ row.hiredate }</td>
					<td>${ row.sal }</td>
					<td>${ row.comm }</td>
					<td>${ row.deptno }</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
