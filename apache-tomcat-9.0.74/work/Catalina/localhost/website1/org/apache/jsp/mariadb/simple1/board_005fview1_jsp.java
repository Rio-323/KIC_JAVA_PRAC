/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.74
 * Generated at: 2023-05-02 01:52:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.mariadb.simple1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public final class board_005fview1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("javax.naming.InitialContext");
    _jspx_imports_classes.add("java.sql.SQLException");
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("javax.sql.DataSource");
    _jspx_imports_classes.add("javax.naming.Context");
    _jspx_imports_classes.add("javax.naming.NamingException");
    _jspx_imports_classes.add("java.sql.PreparedStatement");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("	");

		request.setCharacterEncoding("utf-8");
		String seq = request.getParameter("seq");
		// System.out.println(seq);
		
		String subject = "";
		String writer = "";
		String mail = "";
		String wip = "";
		String wdate = "";
		String hit = "";
		String content = "";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context)initCtx.lookup( "java:comp/env" );
			DataSource dataSource = (DataSource)envCtx.lookup( "jdbc/mariadb3" );
			
			conn = dataSource.getConnection();
			
			// 조회수 증가
			String sql = "update board set hit = hit + 1 where seq = ?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString(1, seq);
			
			pstmt.executeUpdate();
			
			sql = "select subject, writer, mail, wip,wdate, hit, content from board where seq = ?";
			pstmt = conn.prepareStatement( sql );
			pstmt.setString(1, seq);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				subject = rs.getString("subject");
				writer = rs.getString("writer");
				mail = rs.getString("mail");
				wip = rs.getString("wip");
				wdate = rs.getString("wdate");
				hit = rs.getString("hit");
				content = rs.getString("content").replaceAll("\n", "<br>");
			}
			
		} catch( NamingException e ) {
			System.out.println( "[에러] " + e.getMessage() );
		} catch( SQLException e ) {
			System.out.println( "[에러] " + e.getMessage() );
		} finally {
			if( pstmt != null ) pstmt.close();
			if( conn != null ) conn.close();
		}
		
	
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"ko\">\n");
      out.write("<head>\n");
      out.write("<meta charset=\"UTF-8\">\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0\">\n");
      out.write("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n");
      out.write("<title>Insert title here</title>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"../../css/board.css\">\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("<!-- 상단 디자인 -->\n");
      out.write("<div class=\"con_title\">\n");
      out.write("	<h3>게시판</h3>\n");
      out.write("	<p>HOME &gt; 게시판 &gt; <strong>게시판</strong></p>\n");
      out.write("</div>\n");
      out.write("<div class=\"con_txt\">\n");
      out.write("	<div class=\"contents_sub\">\n");
      out.write("		<!--게시판-->\n");
      out.write("		<div class=\"board_view\">\n");
      out.write("			<table>\n");
      out.write("			<tr>\n");
      out.write("				<th width=\"10%\">제목</th>\n");
      out.write("				<td width=\"60%\">");
      out.print( subject );
      out.write("</td>\n");
      out.write("				<th width=\"10%\">등록일</th>\n");
      out.write("				<td width=\"20%\">");
      out.print( wdate );
      out.write("</td>\n");
      out.write("			</tr>\n");
      out.write("			<tr>\n");
      out.write("				<th>글쓴이</th>\n");
      out.write("				<td>");
      out.print( writer );
      out.write(' ');
      out.write('(');
      out.print( mail );
      out.write(')');
      out.write(' ');
      out.write('(');
      out.print( wip );
      out.write(")</td>\n");
      out.write("				<th>조회</th>\n");
      out.write("				<td>");
      out.print( hit );
      out.write("</td>\n");
      out.write("			</tr>\n");
      out.write("			<tr>\n");
      out.write("				<td colspan=\"4\" height=\"200\" valign=\"top\" style=\"padding: 20px; line-height: 160%\">");
      out.print( content );
      out.write("</td>\n");
      out.write("			</tr>\n");
      out.write("			</table>\n");
      out.write("		</div>\n");
      out.write("\n");
      out.write("		<div class=\"btn_area\">\n");
      out.write("			<div class=\"align_left\">\n");
      out.write("				<input type=\"button\" value=\"목록\" class=\"btn_list btn_txt02\" style=\"cursor: pointer;\" onclick=\"location.href='board_list1.jsp'\" />\n");
      out.write("			</div>\n");
      out.write("			<div class=\"align_right\">\n");
      out.write("				<input type=\"button\" value=\"수정\" class=\"btn_list btn_txt02\" style=\"cursor: pointer;\" onclick=\"location.href='board_modify1.jsp?seq=");
      out.print( seq );
      out.write("'\" />\n");
      out.write("				<input type=\"button\" value=\"삭제\" class=\"btn_list btn_txt02\" style=\"cursor: pointer;\" onclick=\"location.href='board_delete1.jsp?seq=");
      out.print( seq );
      out.write("'\" />\n");
      out.write("				<input type=\"button\" value=\"쓰기\" class=\"btn_write btn_txt01\" style=\"cursor: pointer;\" onclick=\"location.href='board_write1.jsp'\" />\n");
      out.write("			</div>\n");
      out.write("		</div>	\n");
      out.write("		<!--//게시판-->\n");
      out.write("	</div>\n");
      out.write("</div>\n");
      out.write("<!-- 하단 디자인 -->\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
