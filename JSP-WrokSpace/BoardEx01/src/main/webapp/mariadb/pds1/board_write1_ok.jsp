<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>

<%@ page import="javax.sql.DataSource" %>

<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="java.io.File" %>

<%
	String uploadPath = "/Users/ksy/Desktop/KIC_JAVA_PRAC/JSP-WrokSpace/BoardEx01/src/main/webapp/mariadb/upload";
	String encodingType = "utf-8";
	int maxFileSize = 4 * 1024 * 1024;
	
	MultipartRequest multipartRequest = new MultipartRequest(request, uploadPath, maxFileSize, encodingType, new DefaultFileRenamePolicy());
	
	
	
	String subject = multipartRequest.getParameter("subject");
	String writer = multipartRequest.getParameter("writer");
	
	//
	String mail = "";
	if(!multipartRequest.getParameter("mail1").equals("") && !multipartRequest.getParameter("mail2").equals("")) {
		mail = multipartRequest.getParameter("mail1") + "@" + multipartRequest.getParameter("mail2");
	}
	
	String password = multipartRequest.getParameter("password");
	String content = multipartRequest.getParameter("content");
	String wip = request.getRemoteAddr();
	
	//
	String fileName = multipartRequest.getFilesystemName("upload");
	long fileSize = 0;
	if(multipartRequest.getFile("upload") != null) {
		fileSize = multipartRequest.getFile("upload").length();
	}
	
	//
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	// flag -> 0 : 정상 /  1 -> 비정상
	int flag = 1;
	
	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup( "java:comp/env" );
		DataSource dataSource = (DataSource)envCtx.lookup( "jdbc/mariadb3" );
		
		conn = dataSource.getConnection();
	
		String sql = "INSERT INTO pds_board VALUES (0, ?, ?, ?, ?, ?, ?, ?, 0, ?, now())";
		pstmt = conn.prepareStatement( sql );
		pstmt.setString(1, subject);
		pstmt.setString(2, writer);
		pstmt.setString(3, mail);
		pstmt.setString(4, password);
		pstmt.setString(5, content);
		pstmt.setString(6, fileName);
		pstmt.setLong(7, fileSize);
		pstmt.setString(8, wip);
		
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			// System.out.println("성공");
			flag = 0;
		} else {
			// System.out.println("실패");
		}
		
	} catch( NamingException e ) {
		System.out.println( "[에러] " + e.getMessage() );
	} catch( SQLException e ) {
		System.out.println( "[에러] " + e.getMessage() );
	} finally {
		if( pstmt != null ) pstmt.close();
		if( conn != null ) conn.close();
	}
	
	out.println("<script type='text/javascript'>");
	if(flag == 0) {
		out.println("alert('게시글 작성 성공');");
		out.println("location.href='board_list1.jsp';");
	} else {
		out.println("alert('게시글 작성 실패');");
		out.println("history.back();");
	}
	out.println("</script>");
%>
