package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model1.ExampleDAO;

@Controller
public class ConfigController {
	
	@Autowired
	private ExampleDAO dao;
	
	@RequestMapping("/write1.do")
	public String write1() {
		System.out.println("write1 : " + dao);
		
		System.out.println(dao.selectNow());
		
		return "writeview1";
	}
}
