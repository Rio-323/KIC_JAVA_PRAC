package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class ControllerEx01 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPrcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPrcess(request, response);
	}

	
	private void doPrcess(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("utf-8");
			
			// System.out.println(request.getRequestURL());
			// System.out.println(request.getContextPath());
			
			String path = request.getRequestURI().replaceAll(request.getContextPath(), "");
			// System.out.println(path);
			
			String url = "/WEB-INF/views/error.jsp";
			
			if(path.equals("/") || path.equals("/*.do") || path.equals("/view1.do")) {
				
				url = "/WEB-INF/views/view1.jsp";
				
			} else if(path.equals("/view2.do")) {
				
				url = "/WEB-INF/views/view2.jsp";
				
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
