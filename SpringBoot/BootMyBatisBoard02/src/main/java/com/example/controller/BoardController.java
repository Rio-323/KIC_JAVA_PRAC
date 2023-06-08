package com.example.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.BoardDAO;
import com.example.model.BoardTO;

@RestController
public class BoardController {

	@Autowired
	private BoardDAO dao;
	
	@RequestMapping( "/" )
	public ModelAndView root(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_index1" );
		
		return modelAndView;
	}
	
	@RequestMapping( "/list.do" )
	public ModelAndView list(HttpServletRequest request) {
		
		ArrayList<BoardTO> lists = dao.boardList();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_list1" );
		modelAndView.addObject( "lists", lists );
		
		return modelAndView;
	}
	
	@RequestMapping( "/write.do" )
	public ModelAndView write(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_write1" );
		return modelAndView;
	}
	
	@RequestMapping( "/write_ok.do" )
	public ModelAndView write_ok(HttpServletRequest request) {
		
		BoardTO to = new BoardTO();
		to.setSubject( request.getParameter( "subject" ) );
		to.setWriter( request.getParameter( "writer" ) );
		
		String mail = "";
		if( !request.getParameter( "mail1" ).equals("") && !request.getParameter( "mail2" ).equals("") ) {
			mail = request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" );	
		}
		to.setMail( mail );
		to.setPassword( request.getParameter( "password" ) );
		to.setContent( request.getParameter( "content" ) );
		to.setWip( request.getRemoteAddr() );
		
		int flag = dao.boardWriteOk( to );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_write1_ok" );
		modelAndView.addObject( "flag", flag );
		
		return modelAndView;
	}
}
