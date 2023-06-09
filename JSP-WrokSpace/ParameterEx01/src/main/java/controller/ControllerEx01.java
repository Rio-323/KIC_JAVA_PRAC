package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model2.View1Action;
import model2.View2Action;
import model2.ViewAction;


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
			
			String action = request.getParameter("action");
			
			String url = "/WEB-INF/views/error.jsp";
			
			ViewAction model = null;
			
			if(action == null || action.equals("") || action.equals("view1")) {
				// 모델 호출	
				model = new View1Action();
				model.execute(request, response);
				
				url = "/WEB-INF/views/view1.jsp";
			} else if(action.equals("view2")) {
				// 모델 호출	
				model = new View2Action();
				model.execute(request, response);
				
				url = "/WEB-INF/views/view2.jsp";
			} else if(action.equals("form")) {
				url = "/WEB-INF/views/form.jsp";
			} else if(action.equals("form_ok")) {
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
