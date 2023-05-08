<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	int flag = 1;
    	Cookie[] cookies = request.getCookies();
    	
    	if(cookies != null && cookies.length >= 0) {
    		for(int i = 0; i < cookies.length; i++) {
    			if(cookies[i].getName().equals("login_id") && !cookies[i].getValue().equals("")) {
    				flag = 0;
    				break;
    			}
    		}
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