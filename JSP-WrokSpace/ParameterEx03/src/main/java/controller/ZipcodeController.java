package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model2.Action;
import model2.ZipcodeAction;
import model2.ZipcodeOkAction;


@WebServlet("/controller")
public class ZipcodeController extends HttpServlet {
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
			String path = request.getParameter( "path" );
			
			String url = "/WEB-INF/views/error.jsp";
			Action action = null;
			
			if(path == null || path.equals("") || path.equals("zipcode")) {
				action = new ZipcodeAction();
				action.execute(request, response);
				
				url = "/WEB-INF/views/zipcode.jsp";
			} else if(path.equals("zipcode_ok")) {
				action = new ZipcodeOkAction();
				action.execute(request, response);
				
				url = "/WEB-INF/views/zipcode_ok.jsp";
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
