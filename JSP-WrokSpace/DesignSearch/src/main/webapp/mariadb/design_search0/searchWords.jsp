<%@page import="model1.BoardTo"%>
<%@page import="model1.BoardDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	request.setCharacterEncoding("utf-8");
		
    	String searchKey = request.getParameter("searchKey");
    	String searchWord = request.getParameter("searchWord");
    	
    	System.out.println("\nsearch jsp 서치 키 " + searchKey);
    	System.out.println("\nsearch jsp 서치 단어 " + searchWord);
    
		BoardDao dao = new BoardDao();
		
		
		List<BoardTo> datas = dao.searchList(searchKey, searchWord);
		//List<ZipcodeTO> lists = dao.selectListZipcode(strDong + "%");
		
		int totalRecord = datas.size();
	
		StringBuilder sbHtml = new StringBuilder();
		

		for( BoardTo to : datas ) {
			String seq = to.getSeq();
			String subject = to.getSubject();
			String writer = to.getWriter();
			String wdate = to.getWdate();
			String hit = to.getHit();
			int wgap = to.getWgap();
				
			sbHtml.append( "<tr>" );
			sbHtml.append( "<td>&nbsp;</td>" );
			sbHtml.append( "<td>" + seq + "</td>" );
				
			sbHtml.append( "<td class='left'>" );
			sbHtml.append( "<a href='board_view1.jsp?seq=" + seq + "'>" + subject + "</a>" );
			if( wgap == 0 ) { 
				sbHtml.append( "&nbsp;<img src='../../images/icon_new.gif' alt='NEW'>" );
			}
			sbHtml.append( "</td>" );
				
			sbHtml.append( "<td>" + writer + "</td>" );
			sbHtml.append( "<td>" + wdate + "</td>" );
			sbHtml.append( "<td>" + hit + "</td>" );
			sbHtml.append( "<td>&nbsp;</td>" );
			sbHtml.append( "</tr>" );
		}
	
	    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<%=sbHtml %>
</table>
</body>
</html>