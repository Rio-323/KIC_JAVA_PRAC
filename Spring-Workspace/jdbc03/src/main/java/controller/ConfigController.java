package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ConfigController {
	
	@RequestMapping("/jdbc1.do")
	public String jdbc1() {
		
		return "jdbc1";
	}
	
}
