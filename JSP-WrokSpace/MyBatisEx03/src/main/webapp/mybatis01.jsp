<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.InputStream" %>

<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>

<%@ page import="model1.EmpTO" %>

<%
	String resource ="myBatisConfig.xml";

	InputStream is = null;
	SqlSession sqlSession = null;
	
	StringBuilder sbHtml = new StringBuilder();
	
	try {
		
		is = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		
		sqlSession = sqlSessionFactory.openSession();
		
		
		// EmpTO to = (EmpTO)sqlSession.selectOne("selectparamone1", "scott");
		// List<EmpTO> lists = sqlSession.selectList("mybatis2.selectparamone1", "s%");
		List<EmpTO> lists = sqlSession.selectList("mybatis1.selectparamone2", "s%");
		
		sbHtml.append("<table border='1'>");
		for(EmpTO to : lists) {
			sbHtml.append("<tr>");
			sbHtml.append("<td>" + to.getEmpno() + "</td>");
			sbHtml.append("<td>" + to.getEname() + "</td>");
			sbHtml.append("<td>" + to.getJob() + "</td>");
			sbHtml.append("<td>" + to.getMgr() + "</td>");
			sbHtml.append("<td>" + to.getHiredate() + "</td>");
			sbHtml.append("<td>" + to.getSal() + "</td>");
			sbHtml.append("<td>" + to.getComm() + "</td>");
			sbHtml.append("<td>" + to.getDeptno() + "</td>");
			sbHtml.append("</tr>");
		}
		sbHtml.append("</table>");
		
	} catch(IOException e) {
		System.out.println("[Error] : " + e.getMessage());
	} finally {
		if(sqlSession != null) sqlSession.close();
		if(is != null) is.close();
	}
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<%= sbHtml %>
	</body>
</html>