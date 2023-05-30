<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model1.ZipcodeTO" %>
<%@ page import="java.util.ArrayList" %>

    
<%
	ArrayList<ZipcodeTO> lists = (ArrayList)request.getAttribute("lists");

	StringBuilder sbHtml = new StringBuilder();
	
	sbHtml.append("<table width='800' style='border-collapse: collapse;'>");
	
	for(ZipcodeTO to : lists) {
		sbHtml.append("<tr>");
	    sbHtml.append("<td style='border: 1px solid black;'>" + to.getZipcode() + "</td>");
	    sbHtml.append("<td style='border: 1px solid black;'>" + to.getSido() + "</td>");
	    sbHtml.append("<td style='border: 1px solid black;'>" + to.getGugun() + "</td>");
	    sbHtml.append("<td style='border: 1px solid black;'>" + to.getDong() + "</td>");
	    sbHtml.append("<td style='border: 1px solid black;'>" + to.getRi() + "</td>");
	    sbHtml.append("<td style='border: 1px solid black;'>" + to.getBunji() + "</td>");
	    sbHtml.append("</tr>");
		sbHtml.append("</tr>");
	}
	sbHtml.append("</table>");
	
	
%>    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		zipcode_ok.jsp<br><br>
		
		<%= sbHtml %>
		
		
	</body>
</html>