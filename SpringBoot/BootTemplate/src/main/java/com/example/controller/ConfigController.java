package com.example.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.BoardTO;

@RestController
public class ConfigController {
	
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/view1.do")
	public ModelAndView view1() {
		return new ModelAndView("view1");
	}
	
	@RequestMapping("/view2.do")
	public ModelAndView view2() {
		BoardTO to = new BoardTO();
		to.setSeq("10");
		to.setSubject("제목 10");
		
		ArrayList<BoardTO> lists = new ArrayList<>();
		BoardTO to1 = new BoardTO();
		to1.setSeq("20");
		to1.setSubject("제목 20");
		
		BoardTO to2 = new BoardTO();
		to2.setSeq("30");
		to2.setSubject("제목 30");
		
		lists.add(to1);
		lists.add(to2);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("view2");
		modelAndView.addObject("data1", "값 1");
		modelAndView.addObject("to", to);
		modelAndView.addObject("lists", lists);
		
		return modelAndView;
	}
}
