package gugudan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GugudanServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html; charset=utf-8");
		
		StringBuilder sbHtml = new StringBuilder();
		sbHtml.append("<!doctype html>");
		sbHtml.append("<html>");
		sbHtml.append("<head>");
		sbHtml.append("<meta charset='utf-8'>");
		sbHtml.append("</head>");
		sbHtml.append("<body>");
		sbHtml.append("<form action=\"gugudan_ok.do\" method=\"post\">");
		sbHtml.append("시작단 : <input type=\"text\" name=\"start\" />");
		sbHtml.append("끝단 : <input type=\"text\" name=\"end\" />");
		sbHtml.append("<input type=\"submit\" value=\"구구단 실행\"/>");
		sbHtml.append("</form>");
		sbHtml.append("</body>");
		sbHtml.append("</html>");
		
		PrintWriter out = resp.getWriter();
		out.println(sbHtml);
		out.close();
	}
}
