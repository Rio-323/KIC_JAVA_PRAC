<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>
<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@page import="model1.ZipcodeTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model1.ZipcodeDAO"%>

<%

	request.setCharacterEncoding("utf-8");

	String strDong = "대치";

	ZipcodeDAO dao = new ZipcodeDAO();
	ArrayList<ZipcodeTO> lists = dao.zipcodeList(strDong);

	JSONArray jsonArray = new JSONArray();
	for(ZipcodeTO to : lists){
	   String zipcode = to.getZipcode();
	   String sido = to.getSido();
	   String gugun = to.getGugun();
	   String dong = to.getDong();
	   String ri = to.getRi();
	   String bunji = to.getBunji();
	   
	   JSONObject obj = new JSONObject();
	   obj.put("zipcode", zipcode);
	   obj.put("sido", sido);
	   obj.put("gugun", gugun);
	   obj.put("dong", dong);
	   obj.put("ri", ri);
	   obj.put("bunji", bunji);
	   
	   jsonArray.add(obj);
	}
	
   out.println(jsonArray);
%>