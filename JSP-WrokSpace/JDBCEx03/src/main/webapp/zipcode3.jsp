<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>

<%@ page import="javax.sql.DataSource" %>

<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>

<%
	request.setCharacterEncoding( "utf-8" );

	String strSido = request.getParameter( "sido" );
	String strGugun = request.getParameter("gugun");
	String strDong = request.getParameter("dong");
	

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	StringBuilder sbSido = new StringBuilder();
	StringBuilder sbGugun = new StringBuilder();
	StringBuilder sbHtml = new StringBuilder();
	try {
		Context initCtx = new InitialContext();
		Context envCtx = (Context)initCtx.lookup( "java:comp/env" );
		DataSource dataSource = (DataSource)envCtx.lookup( "jdbc/mariadb2" );
		
		conn = dataSource.getConnection();
	
		String sql = "select distinct sido from zipcode";
		
		pstmt = conn.prepareStatement( sql );
		
		rs = pstmt.executeQuery();
		
		while( rs.next() ) {
			sbSido.append( "<option value='" + rs.getString( "sido" ) + "'>" + rs.getString( "sido" ) + "</option>" );
		}
		
		
		
		if( request.getParameter( "sido" ) != null ) {
			
			sql = "select distinct gugun from zipcode where sido=?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, strSido );
			
			rs = pstmt.executeQuery();
			
			while( rs.next() ) {
				sbGugun.append( "<option value='" + rs.getString( "gugun" ) + "'>" + rs.getString( "gugun" ) + "</option>" );
			}
		}
		
		
		
		if(request.getParameter( "sido" ) != null && request.getParameter( "gugun" ) != null && request.getParameter( "dong" ) != null) {
			sql = "select zipcode, sido, gugun, dong, ri, bunji from zipcode where sido = ? and gugun = ? and dong like ?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString( 1, strSido );
			pstmt.setString( 2, strGugun );
			pstmt.setString(3, "%" + strDong + "%");
			rs = pstmt.executeQuery();
			
			sbHtml.append("<table width='800' border='1'>");
			while(rs.next()) {
				sbHtml.append("<tr>");
				sbHtml.append("<td>" + rs.getString("zipcode") + "</td>");
				sbHtml.append("<td>" + rs.getString("sido") + "</td>");
				sbHtml.append("<td>" + rs.getString("gugun") + "</td>");
				sbHtml.append("<td>" + rs.getString("dong") + "</td>");
				sbHtml.append("<td>" + rs.getString("ri") + "</td>");
				sbHtml.append("<td>" + rs.getString("bunji") + "</td>");
				sbHtml.append("</tr>");
			}
			sbHtml.append("</table>");
			
			
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
%>


<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		table	{ border: 1px solid black; font-size: 15px; border-collapse: collapse; }
		td		{ width: 800px; padding: 10px; text-align: center; border: 1px solid black; }
		#sido	{ width: 100px; }
		#gugun	{ width: 100px; }
	</style>
	<script type="text/javascript">
		window.onload = function() {
			document.getElementById( 'sido' ).onchange = function() {
				const sido = document.getElementById( 'sido' ).value;
			
	           	document.frm.submit();
			};
		};
	</script>
	</head>
	<body>
	
	<form action="zipcode3.jsp" method="post" name="frm">
	<table>
	<tr>
		<td>
			<select name="sido" id="sido">
				<option value="시도">시도</option>
				<%= sbSido %>
			</select>
			<select name="gugun" id="gugun">
				<option value="구군">구군</option>
				<%= sbGugun %>
			</select>
			<input type="text" name="dong" id="dong" size="40" />
			<input type="submit" value="우편번호검색" />
		</td>
	</tr>
	</table>
	</form>
		<br><hr><br>
			<%= sbHtml.toString() %>
	</body>
</html>




