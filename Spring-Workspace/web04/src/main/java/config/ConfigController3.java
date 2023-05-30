package config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/board")
public class ConfigController3 {
	
	@RequestMapping("/list1.do")
	public String handleRequest1() {
		return "listview1";
	}
	
	@RequestMapping("/list2.do")
	public String handleRequest2() {
		return "listview2";
	}
}
