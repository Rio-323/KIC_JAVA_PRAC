package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model2.BoardAction;
import model2.ListAction;
import model2.WriteAction;
import model2.WriteOkAction;


@WebServlet("/controller")
public class BoardCotroller extends HttpServlet {
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
			
			BoardAction action = null;
			
			if(path == null || path.equals("") || path.equals("list")) {
				action = new ListAction();
				action.execute(request, response);
				
				url = "/WEB-INF/views/board_list1.jsp";
			} else if(path.equals("write")) {
				action = new WriteAction();
				action.execute(request, response);
				
				url = "/WEB-INF/views/board_write1.jsp";
			} else if(path.equals("write_ok")) {
				action = new WriteOkAction();
				action.execute(request, response);
				
				url = "/WEB-INF/views/board_write1_ok.jsp";
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			
		} catch (UnsupportedEncodingException e) {
			System.out.println("[Error] : " +  e.getMessage());
		} catch (ServletException e) {
			System.out.println("[Error] : " +  e.getMessage());
		} catch (IOException e) {
			System.out.println("[Error] : " +  e.getMessage());
		}

	}

}
