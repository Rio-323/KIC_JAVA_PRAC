package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model1.BoardDAO;
import model1.BoardTO;

@Controller
public class BoardController {
	
	@RequestMapping( "/list.do" )
	public String list(HttpServletRequest request, Model model ) {
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardTO> lists = dao.boardList();
		
		model.addAttribute( "lists", lists );
		
		return "board_list1";
	}
	
	@RequestMapping( "/write.do" )
	public String write(HttpServletRequest request, Model model ) {
		return "board_write1";
	}
	
	@RequestMapping( "/write_ok.do" )
	public String write_ok(HttpServletRequest request, Model model ) {
		
		BoardTO to = new BoardTO();
		to.setSubject( request.getParameter( "subject" ) );
		to.setWriter( request.getParameter( "writer" ) );
		to.setMail( "" ) ;
		if( !request.getParameter("mail1").equals("") 
				&& !request.getParameter("mail2").equals("") ) {
			to.setMail( request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" ) );	
		}
		
		to.setPassword( request.getParameter( "password" ) );
		to.setContent( request.getParameter( "content" ) );
		
		to.setWip( request.getRemoteAddr() );
		
		BoardDAO dao = new BoardDAO();
		int flag = dao.boardWriteOk( to );

		model.addAttribute( "flag", flag );
		return "board_write1_ok";
	}
}
