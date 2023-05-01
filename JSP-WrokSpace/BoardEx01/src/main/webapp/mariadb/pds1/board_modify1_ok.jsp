<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>

<%@ page import="javax.sql.DataSource" %>

<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="java.io.File" %>

<%
	String uploadPath = "/Users/ksy/Desktop/KIC_JAVA_PRAC/JSP-WrokSpace/BoardEx01/src/main/webapp/mariadb/upload";
	String encodingType = "utf-8";
	int maxFileSize = 4 * 1024 * 1024;
	
	MultipartRequest multipartRequest = new MultipartRequest(request, uploadPath, maxFileSize, encodingType, new DefaultFileRenamePolicy());

	String subject = multipartRequest.getParameter("subject");
	String seq = multipartRequest.getParameter( "seq" );
	String mail = "";
	if(!multipartRequest.getParameter("mail1").equals("") && !multipartRequest.getParameter("mail2").equals("")) {
		mail = multipartRequest.getParameter("mail1") + "@" + multipartRequest.getParameter("mail2");
	}
	
	String password = multipartRequest.getParameter("password");
	String content = multipartRequest.getParameter("content");
	String fileName = multipartRequest.getFilesystemName("upload");
	long fileSize = 0;
	if(multipartRequest.getFile("upload") != null) {
		fileSize = multipartRequest.getFile("upload").length();
	}
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// flag -> 0 : 정상 /  1 -> 비정상
	int flag = 2;
	
	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup( "java:comp/env" );
		DataSource dataSource = (DataSource)envCtx.lookup( "jdbc/mariadb3" );
		
		conn = dataSource.getConnection();
		
		String sql = "select filename from pds_board where seq = ?";
		pstmt = conn.prepareStatement( sql );
		pstmt.setString(1, seq);
		rs = pstmt.executeQuery();
		
		String oldFileName = null;
		
		if(rs.next()) {
			oldFileName = rs.getString("filename");
		}
		
		
		if(fileName != null) {
			sql = "update pds_board set subject = ?, mail =?, content = ?, filename = ?, filesize = ? where seq = ? and password = ?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString(1, subject);
			pstmt.setString(2, mail);
			pstmt.setString(3, content);
			pstmt.setString(4, fileName);
			pstmt.setLong(5, fileSize);
			pstmt.setString(6, seq);
			pstmt.setString(7, password);
		} else {
			sql = "update pds_board set subject = ?, mail =?, content = ? where seq = ? and password = ?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString(1, subject);
			pstmt.setString(2, mail);
			pstmt.setString(3, content);
			pstmt.setString(4, seq);
			pstmt.setString(5, password);
		}
		
		int result = pstmt.executeUpdate();
		
		if(result == 1) {
			flag = 0;
			
			if(fileName != null && oldFileName != null) {
				File file = new File(uploadPath, oldFileName);
				file.delete();
			}
			
		} else if(result == 0) {
			flag = 1;
			if(fileName != null) {
				// 비밀번호가 잘못됐을 경우
				File file = new File(uploadPath, fileName);
				file.delete();
			}
		}
		
	} catch( NamingException e ) {
		System.out.println( "[에러] " + e.getMessage() );
	} catch( SQLException e ) {
		System.out.println( "[에러] " + e.getMessage() );
	} finally {
		if( pstmt != null ) pstmt.close();
		if( conn != null ) conn.close();
		if( rs != null ) rs.close();
	}
	
	out.println("<script type='text/javascript'>");
	if(flag == 0) {
		out.println("alert('게시글 수정 성공');");
		out.println("location.href='board_view1.jsp?seq=" + seq + "';");
	} else if(flag == 1) {
		out.println("alert('비밀번호 오류');");
		out.println("history.back();");
	} else {
		out.println("alert('게시글 수정 실패');");
		out.println("history.back();");
	}
	out.println("</script>");
	
%>