package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model2.Action;
import model2.FormAction;
import model2.FormOkAction;

/**
 * Servlet implementation class ControllerEx01
 */
@WebServlet("/controller")
public class ControllerEx01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			request.setCharacterEncoding("utf-8");
			
			String path = request.getParameter("path");
			
			String url = "/WEB-INF/views/error.jsp";
			
			Action model = null;
			
			if(path == null || path.equals("") || path.equals("form")) {
				// 모델 호출	
				model = new FormAction();
				model.execute(request, response);
				
				url = "/WEB-INF/views/form.jsp";
			} else if(path.equals("form_ok")) {
				// 모델 호출	
				model = new FormOkAction();
				model.execute(request, response);
				
				url = "/WEB-INF/views/form_ok.jsp";
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (ServletException e) {
			System.out.println("[Error] : " + e.getMessage());
		} catch (IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		}
		
	}

}
