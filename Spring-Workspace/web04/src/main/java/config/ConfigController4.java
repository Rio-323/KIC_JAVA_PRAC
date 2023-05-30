package config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class ConfigController4 {
	
	@RequestMapping("/form.do")
	public ModelAndView handleRequest1() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("form");
		
		return modelAndView;
	}
	
	@RequestMapping("/form_ok.do")
	public ModelAndView handleRequest2() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("form_ok");
		
		return modelAndView;
	}
}
