<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="model1.ZipcodeTO"%>
<%@ page import="model1.ZipcodeDAO"%>
<%@ page import="java.util.ArrayList"%>
<%
	request.setCharacterEncoding( "utf-8" );

	String strSido = request.getParameter( "sido" );
	
	ZipcodeDAO dao = new ZipcodeDAO();
	ArrayList<ZipcodeTO> lists = dao.gugunList(strSido);
	
	StringBuilder sbXml = new StringBuilder();
	for( ZipcodeTO to : lists ) {
		String gugun = to.getGugun();
		
		sbXml.append( "<gugun>" + gugun + "</gugun>" );
	}
%>
<address>
<%=sbXml %>
</address>    