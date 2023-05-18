<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="model1.MemberTO"%>
<%@ page import="model1.MemberDAO"%>
<%@ page import="java.util.ArrayList"%>
<%
	request.setCharacterEncoding( "utf-8" );

	MemberDAO dao = new MemberDAO();
	ArrayList<MemberTO> lists = dao.userList();
	
	StringBuilder sbXml = new StringBuilder();
	
	for(MemberTO to : lists) {
		String seq = to.getSeq();
		String name = to.getName();
		String password = to.getPassword();
		String email = to.getEmail();
		String address = to.getAddress();
		String wdate = to.getWdate();
		
		sbXml.append( "<user>" );
		sbXml.append( "<seq>" + seq + "</seq>" );
		sbXml.append( "<name>" + name + "</name>" );
		sbXml.append( "<password>" + password + "</password>" );
		sbXml.append( "<email>" + email + "</email>" );
		sbXml.append( "<address>" + address + "</address>" );
		sbXml.append( "<wdate>" + wdate + "</wdate>" );
		sbXml.append( "</user>" );
	}
	
%>
	<users>
		<%= sbXml %>
	</users>  