package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConfigController {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/write1.do")
	public String write1() {
		// System.out.println("write1 : " + jdbcTemplate);
		
		// MyBatis와 유사
		// insert, update, delete -> update
		// select 개수에 따라
		// 		1개 - queryForXX() / 여러개 query(), queryForList(); 
		
		String result = jdbcTemplate.queryForObject("select now() as now", String.class);
		
		System.out.println("결과 : " + result);
		
		
		return "writeview1";
	}
	
}
