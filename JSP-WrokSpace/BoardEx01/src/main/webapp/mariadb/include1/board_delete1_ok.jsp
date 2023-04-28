<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="./include/connection.jspf" %>
<%
	request.setCharacterEncoding("utf-8");
	String seq = request.getParameter("seq");
	String password = request.getParameter("password");
	
	
	
	int flag = 2;
	
	try {
		String sql = "delete from board where seq = ? and password = ?";
		pstmt = conn.prepareStatement( sql );
		pstmt.setString(1, seq);
		pstmt.setString(2, password);
		
		// result -> 0 : password wrong / 1 : success
		int result = pstmt.executeUpdate();
		
		if( result == 1) {
			flag = 0;
		} else if(result == 0) {
			flag = 1;
		}
		
	} catch( SQLException e ) {
		System.out.println( "[에러] " + e.getMessage() );
	} finally {
		if( pstmt != null ) pstmt.close();
		if( conn != null ) conn.close();
	}
	
	
	out.println("<script type='text/javascript'>");
	if(flag == 0) {
		out.println("alert('게시글 삭제 성공');");
		out.println("location.href='board_list1.jsp';");
	} else if(flag == 1) {
		out.println("alert('비밀번호 오류');");
		out.println("history.back();");
	} else {
		out.println("alert('게시글 삭제 실패');");
		out.println("history.back();");
	}
	out.println("</script>");
%>