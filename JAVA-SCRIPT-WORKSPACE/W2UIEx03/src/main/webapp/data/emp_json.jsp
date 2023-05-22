<%@ page language="java" contentType="text/plain; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="javax.naming.Context"%>
<%@ page import="javax.naming.InitialContext"%>
<%@ page import="javax.naming.NamingException"%>

<%@ page import="javax.sql.DataSource"%>

<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.SQLException"%>

<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %>
<%
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	JSONArray jsonArray = new JSONArray();
	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context) initCtx.lookup( "java:comp/env" );
		DataSource dataSource = (DataSource) envCtx.lookup( "jdbc/mariadb1" );

		conn = dataSource.getConnection();
		String sql = "select empno, ename, job, mgr, hiredate, sal, comm, deptno from emp";
		pstmt = conn.prepareStatement(sql);
		
		rs = pstmt.executeQuery();
		
		while( rs.next() ) {
			JSONObject obj = new JSONObject();
			obj.put( "empno", rs.getString( "empno" ) );
			obj.put( "ename", rs.getString( "ename" ) );
			obj.put( "job", rs.getString( "job" ) );
			obj.put( "mgr", rs.getString( "mgr" ) );
			obj.put( "hiredate", rs.getString( "hiredate" ) );
			obj.put( "sal", rs.getString( "sal" ) );
			obj.put( "comm", rs.getString( "comm" ) );
			obj.put( "deptno", rs.getString( "deptno" ) );
			jsonArray.add( obj );
		}
	} catch( NamingException e ) {
		System.out.println( "[에러] " + e.getMessage() );
	} catch( SQLException e ) {
		System.out.println( "[에러] " + e.getMessage() );
	} finally {
		if( rs != null ) rs.close();
		if( pstmt != null ) pstmt.close();
		if( conn != null ) conn.close();
	}
	
	out.println( jsonArray );
%>
