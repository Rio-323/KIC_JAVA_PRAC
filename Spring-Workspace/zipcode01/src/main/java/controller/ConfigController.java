package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import model1.ZipcodeDAO;
import model1.ZipcodeTO;


@Controller
public class ConfigController {
	
	@Autowired
	private ZipcodeDAO dao;
	
	@RequestMapping("/zipcode.do")
	public String zipcode() {
		
		System.out.println("zipcode() 호출");
		
		return "zipcode";
	}
	
	
	@RequestMapping("/zipcode_ok.do")
	public String zipcode_ok(HttpServletRequest request) {
		
		System.out.println("zipcode_ok() 호출");
		
		String strDong = request.getParameter("dong");
		
		ArrayList<ZipcodeTO> lists = dao.zipcodeList(strDong);
		
		System.out.println("데이터 개수 : " + lists.size());
		
		return "zipcode_ok";
	}
}
