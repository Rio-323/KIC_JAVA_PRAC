<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.InputStream" %>

<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>

<%@ page import="model1.DeptTO" %>
<%@ page import="mapper.SqlMapperInter" %>

<%
	String resource ="myBatisConfig.xml";

	InputStream is = null;
	SqlSession sqlSession = null;
	
	StringBuilder sbHtml = new StringBuilder();
	
	try {
		
		is = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		
		sqlSession = sqlSessionFactory.openSession(true);
		
		
		// mapper 연결
		sqlSession.getConfiguration().addMapper(SqlMapperInter.class);
		
		SqlMapperInter mapper = (SqlMapperInter)sqlSession.getMapper(SqlMapperInter.class);
		
		DeptTO to = new DeptTO();
		to.setDeptno("60");
		
		int result = mapper.delete(to);
		sbHtml.append("결과 : " + result);
		
		
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