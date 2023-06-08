package com.example.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.BoardDAO;
import com.example.model.BoardTO;

@RestController
public class BoardController {
	
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping("/")
	public ModelAndView root(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_index");
		
		return modelAndView;
	}
	
	@RequestMapping("/list.do")
	public ModelAndView list(HttpServletRequest request) {
		
		ArrayList<BoardTO> lists = dao.boardList();
		System.out.println("데이터 개수 : " + lists.size());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_list1");
		modelAndView.addObject("lists", lists);
		
		return modelAndView;
	}
	
	@RequestMapping("/write.do")
	public ModelAndView write(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_write1");
		
		return modelAndView;
	}
	
	@RequestMapping("/write_ok.do")
	public ModelAndView write_ok(HttpServletRequest request) {
		
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
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_write1_ok");
		modelAndView.addObject("flag", flag);
		
		return modelAndView;
	}
	
	@RequestMapping("/view.do")
	public ModelAndView view(HttpServletRequest request) {
		BoardTO to = new BoardTO();
		to.setSeq(request.getParameter("seq"));
		to = dao.boardView(to);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_view1");
		modelAndView.addObject("to", to);
		
		return modelAndView;
	}
	
	@RequestMapping("/modify.do")
	public ModelAndView modify(HttpServletRequest request) {
		BoardTO to = new BoardTO();
		to.setSeq(request.getParameter("seq"));
		to = dao.boardView(to);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_modify1");
		modelAndView.addObject("to", to);
		
		
		return modelAndView;
	}
	
	@RequestMapping("/modify_ok.do")
	public ModelAndView modify_ok(HttpServletRequest request) {
		
		BoardTO to = new BoardTO();
		to.setSubject( request.getParameter( "subject" ) );
		to.setMail( "" ) ;
		
		if( !request.getParameter("mail1").equals("") 
				&& !request.getParameter("mail2").equals("") ) {
			to.setMail( request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" ) );	
		}
		to.setContent( request.getParameter( "content" ) );
		int flag = dao.boardModifyOk(to);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_modify1_ok");
		modelAndView.addObject("flag", flag);
		
		return modelAndView;
	}
}
