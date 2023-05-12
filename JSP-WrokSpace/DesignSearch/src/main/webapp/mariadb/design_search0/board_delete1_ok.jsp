<%@page import="model1.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model1.BoardTo" %>
<%@ page import="model1.BoardDao" %>
<%@ page import="mapper.BoardMapperInter" %>

<%
	request.setCharacterEncoding("utf-8");
	
	BoardTo to = new BoardTo();
	to.setSeq(request.getParameter("seq"));
	to.setPassword(request.getParameter("password"));
	
	BoardDao dao = new BoardDao();
	int flag = dao.boardDeleteOk(to);
	
	//System.out.println(seq);
	//System.out.println(password);
	
	out.println("<script typr='text/javascript'>");
	if(flag == 0){
		out.println("alert('글삭제에 성공');");
		out.println("location.href='board_list1.jsp';");
	}else if(flag==1){
		out.println("alert('비밀번호 오류');");
		out.println("history.back();");
	}else{
		out.println("alert('글삭제에 실패');");
		out.println("history.back();");
	}
	out.println("</script>");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>








