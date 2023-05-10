<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.IOException" %>
<%@ page import="java.io.InputStream" %>

<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>

<%@ page import="model1.DeptTO" %>

<%

	String resource ="myBatisConfig.xml";

	InputStream is = null;
	SqlSession sqlSession = null;
	
	StringBuilder sbHtml = new StringBuilder();
	
	try {
		
		is = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		
		sqlSession = sqlSessionFactory.openSession(true); // auto commit
		
		DeptTO to = new DeptTO();
		to.setDeptno("90");
		to.setDname("ACCOUNTING");
		
		int result = sqlSession.update("update1", to);
		
		// 즉시 update 되지 않음
		// transaction을 해야함
		// 		commit - 인정
		//		rollback - 되돌림
		if(result == 1) {
			// sqlSession.commit();
			sbHtml.append("입력 성공 : " + result);
		}
		
		
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