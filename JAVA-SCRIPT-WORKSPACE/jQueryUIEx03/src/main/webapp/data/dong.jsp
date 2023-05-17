<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="model1.ZipcodeTO"%>
<%@ page import="model1.ZipcodeDAO"%>
<%@ page import="java.util.ArrayList"%>
<%
	request.setCharacterEncoding( "utf-8" );

	String strSido = request.getParameter("sido");
	String strGugun = request.getParameter("gugun");
	
	ZipcodeDAO dao = new ZipcodeDAO();
	ArrayList<ZipcodeTO> lists = dao.dongList(strSido, strGugun);
	
	StringBuilder sbXml = new StringBuilder();
	for( ZipcodeTO to : lists ) {
		String dong = to.getDong();
		
		sbXml.append( "<dong>" + dong + "</dong>" );
	}
%>
<address>
<%=sbXml %>
</address>    