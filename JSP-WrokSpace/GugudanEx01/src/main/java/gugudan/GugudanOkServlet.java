package gugudan;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GugudanOkServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int start = Integer.parseInt(req.getParameter("start"));
		int end = Integer.parseInt(req.getParameter("end")); 
		
		resp.setContentType("text/html");
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Gugudan</title>");
		out.println("<style>");
		out.println("table { border-collapse: collapse; }");
		out.println("td, th { border: 1px solid black; padding: 10px; text-align: center; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table>");
		
		for (int i = start; i <= end; i++) {
			out.println("<tr>");
			for (int j = 1; j <= 9; j++) {
				if (j == 1) {
					out.println("<th>X " + i + "</th>");
				}
				out.println("<td>" + i + " X " + j + " = " + (i * j) + "</td>");
			}
			out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	}
}
