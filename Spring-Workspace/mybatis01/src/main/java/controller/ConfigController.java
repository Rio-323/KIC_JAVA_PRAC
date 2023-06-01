package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model1.JdbcDAO;


@Controller
public class ConfigController {
	
	@Autowired
	private JdbcDAO dao;
	
	@RequestMapping("/jdbc1.do")
	public String jdbc1() {
		System.out.println("jdbc1() 호출 : " + dao.getMapper());
		
		String result = dao.selectNow();
		System.out.println("결과 : " + result);
		
		return "jdbc1";
	}
	
}
