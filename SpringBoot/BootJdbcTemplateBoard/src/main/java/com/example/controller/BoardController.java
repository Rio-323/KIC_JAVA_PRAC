package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class BoardController {
	
	@RequestMapping("/")
	public ModelAndView root(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_index");
		
		return modelAndView;
	}
	
	@RequestMapping("/list.do")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_list1");
		
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
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("board_write1_ok");
		
		return modelAndView;
	}
	
	
}
