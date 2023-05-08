<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model1.BoardTO" %>
<%@ page import="model1.BoardListTO" %>
<%@ page import="java.util.ArrayList" %>

<%
	BoardTO to1 = new BoardTO();
	to1.setSubject("제목 1");
	to1.setWriter("작성자 1");
	
	BoardTO to2 = new BoardTO();
	to2.setSubject("제목 2");
	to2.setWriter("작성자 2");
	
	BoardListTO listTO1 = new BoardListTO();
	listTO1.setCpage("1");
	listTO1.setBoardTO(to1);
	
	BoardListTO listTO2 = new BoardListTO();
	listTO2.setCpage("2");
	listTO2.setBoardTO(to2);
	
	ArrayList<BoardListTO> lists = new ArrayList();
	lists.add(listTO1);
	lists.add(listTO2);
	
	pageContext.setAttribute("lists", lists);
	// EL을 통해서 데이터에 접근.
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		${ lists[0].cpage }<br>
		${ lists[1].cpage }<br>
		
		${ lists[0].boardTO.subject }<br>
		${ lists[0].boardTO.writer }<br>
	</body>
</html>