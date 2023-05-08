<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	// login_ok.jsp
    	request.setCharacterEncoding("utf-8");
    	
    	String id = request.getParameter("id");
    	String password = request.getParameter("password");
    	
    	// 실제 아이디, 패스워드
    	// 게시판 select
    	String save_id = "tester";
    	String save_password = "123456";
    	
    	// 0 - success / 1 - paswword fail / 2 - etc
    	int flag = 2;
    	
    	if(save_id.equals(id) && save_password.equals(password)) {
    		flag = 0;
    	} else {
    		flag = 1;
    	}
    	
    	out.println("<script type='text/javascript'>");
    	if(flag == 0) {
    		// session
    		// 민간한 개인정보 입력 금지
    		session.setAttribute("sid", id);
    		session.setAttribute("sgrade", "a");
    		
    		out.println("alert('로그인 되었습니다.')");
    		out.println("location.href='login_complete.jsp'");
    	} else if(flag == 1) {
    		out.println("alert('비밀번호 오류')");
    		out.println("history.back();");
    	} else if(flag == 2) {
    		out.println("alert('오류')");
    		out.println("history.back();");
    	}
    	out.println("</script>");
    %>
