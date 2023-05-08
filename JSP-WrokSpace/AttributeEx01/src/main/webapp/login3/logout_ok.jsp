<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	// logout_ok.jsp
		Cookie cookie1 = new Cookie("login_id", "");
    	Cookie cookie2 = new Cookie("login_grade", "");
    	cookie1.setMaxAge(0);
    	cookie2.setMaxAge(0);
    	
    	response.addCookie(cookie1);
    	response.addCookie(cookie2);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		alert('로그아웃 되었습니다.');
		location.href='login_form.jsp';
	</script>
</body>
</html>