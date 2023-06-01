package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model1.BoardDAO;
import model1.BoardTO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping( "/list.do" )
	public String list(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		ArrayList<BoardTO> lists = dao.boardList();
		System.out.println("결과 : " + lists.size());
		
		model.addAttribute("lists", lists);
		
		return "board_list1";
	}
	
	@RequestMapping("/write.do")
	public String write(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		return "board_write1";
	}
	
	@RequestMapping("/write_ok.do")
	public String write_ok(HttpServletRequest request, HttpServletResponse response, Model model) {
		
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
		
		int flag = dao.boardWriteOk( to );

		model.addAttribute( "flag", flag );
		
		return "board_write1_ok";
	}
	
	@RequestMapping("/view.do")
	public String view(HttpServletRequest request, HttpServletResponse response, Model model) {
		BoardTO to = new BoardTO();
		to.setSeq(request.getParameter("seq"));
		to = dao.boardView(to);
		
		model.addAttribute("to", to);
		
		return "board_view1";
	}
	
	@RequestMapping("/modify.do")
	public String modify(HttpServletRequest request, HttpServletResponse response, Model model) {
		BoardTO to = new BoardTO();
		to.setSeq(request.getParameter("seq"));
		to = dao.boardView(to);
		
		model.addAttribute("to", to);
		
		return "board_modify1";
	}
	
	@RequestMapping("/modify_ok.do")
	public String modify_ok(HttpServletRequest request, HttpServletResponse response, Model model) {
		
		BoardTO to = new BoardTO();
		to.setSubject( request.getParameter( "subject" ) );
		to.setMail( "" ) ;
		
		if( !request.getParameter("mail1").equals("") 
				&& !request.getParameter("mail2").equals("") ) {
			to.setMail( request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" ) );	
		}
		to.setContent( request.getParameter( "content" ) );
		int flag = dao.boardModifyOk(to);
		
		model.addAttribute("flag", flag);
		
		return "board_modify1_ok";
	}
}















