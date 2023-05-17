<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="model1.ZipcodeTO"%>
<%@ page import="model1.ZipcodeDAO"%>
<%@ page import="java.util.ArrayList"%>
<%
	request.setCharacterEncoding( "utf-8" );

	ZipcodeDAO dao = new ZipcodeDAO();
	ArrayList<ZipcodeTO> lists = dao.sidoList();
	
	StringBuilder sbXml = new StringBuilder();
	for(ZipcodeTO to : lists ) {
		String sido = to.getSido();
		
		sbXml.append( "<sido>" + sido + "</sido>" );
	}
%>
<address>
<%=sbXml %>
</address>    