package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

// @Controller
@RestController
public class ConfigController {
	
	@RequestMapping("/hello1")
	@ResponseBody
	public ModelAndView hello1() {
		return new ModelAndView("hello1");
	}
}
