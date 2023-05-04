<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model1.ZipcodeTo" %>
<%@ page import="java.util.ArrayList" %>
<%
	ArrayList<ZipcodeTo> datas = (ArrayList)request.getAttribute("datas");

	StringBuilder sbHtml = new StringBuilder();
	
	sbHtml.append("<table width='800' style='border-collapse: collapse;'>");
	
	for(ZipcodeTo to : datas) {
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
	
	out.println(sbHtml);
%>
