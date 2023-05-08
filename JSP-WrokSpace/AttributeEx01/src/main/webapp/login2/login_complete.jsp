<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	int flag = 1;
    	if(session.getAttribute("sid") != null && session.getAttribute("sgrade") != null) {
    		flag = 0;
    	}
    	
    	if(flag == 0) {
    		out.println("login_complete.jsp");
    		out.println("<a href='logout_ok.jsp'>로그아웃</a>");
    		
    %>
    
    
<!DOCTYPE html>
<html>
	<%
    	} else if(flag == 1) {
    %>
    
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		
		<script type="text/javascript">
			alert('로그인 해야 합니다.');
			location.href='login_form.jsp';
		</script>
	</body>
</html>
	<%
    	}
    %>