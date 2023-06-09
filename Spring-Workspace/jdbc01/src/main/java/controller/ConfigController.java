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
	
	@RequestMapping("/zipcode.do")
	public String zipcode() {
		
		System.out.println("zipcode() 호출");
		
		return "zipcode";
	}
	
	
	@RequestMapping("/zipcode_ok.do")
	public String zipcode_ok() {
		
		System.out.println("zipcode_ok() 호출");
		
		return "zipcode_ok";
	}
}
