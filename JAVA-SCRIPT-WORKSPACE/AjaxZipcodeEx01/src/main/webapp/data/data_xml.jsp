<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
    
<%@ page import="model1.ZipcodeTO" %>
<%@ page import="model1.ZipcodeDAO" %>
<%@ page import="java.util.ArrayList" %>

<%
	request.setCharacterEncoding("utf-8");

	String strDong = request.getParameter("strDong");
	
	ZipcodeDAO dao = new ZipcodeDAO();
	ArrayList<ZipcodeTO> lists = dao.zipcodeList(strDong);
	
	// System.out.println(lists.size());
	
	StringBuffer sbXml = new StringBuffer();
	
	for(ZipcodeTO to : lists) {
		String zipcode = to.getZipcode();
		String sido = to.getSido();
		String gugun = to.getGugun();
		String dong = to.getDong();
		String ri = to.getRi();
		String bunji = to.getBunji();
		
		sbXml.append("<address>");
		sbXml.append("<zipcode>" + zipcode + "</zipcode>");
		sbXml.append("<sido>" + sido + "</sido>");
		sbXml.append("<gugun>" + gugun + "</gugun>");
		sbXml.append("<dong>" + dong + "</dong>");
		sbXml.append("<ri>" + ri + "</ri>");
		sbXml.append("<bunji>" + bunji + "</bunji>");
		sbXml.append("</address>");
	}
%>

<addressess>
	<%= sbXml %>
</addressess>