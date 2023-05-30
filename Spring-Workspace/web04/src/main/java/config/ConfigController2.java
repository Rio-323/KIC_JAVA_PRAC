package config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConfigController2 {
	
	@RequestMapping("/list3.do")
	public ModelAndView handleRequest3() {
		System.out.println("handleRequest3() 호출");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("listview3");
		
		return modelAndView;
	}
	
	@RequestMapping("/list4.do")
	public ModelAndView handleRequest4() {
		System.out.println("handleRequest4() 호출");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("listview4");
		
		return modelAndView;
	}
}
