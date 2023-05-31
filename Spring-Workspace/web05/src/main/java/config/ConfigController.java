package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import share.ShareClass;

@Controller
public class ConfigController {
	
	@Autowired
	private ShareClass shareClass;
	
	@RequestMapping("/list1.do")
	public String list1() {
		System.out.println("list1() 호출 : " + shareClass);
		
		System.out.println("list1() 호출 : " + shareClass.getShareData1());
		
		return "listview1";
	}
	
	@RequestMapping("/list2.do")
	public String list2() {
		System.out.println("list2() 호출 : " + shareClass);
		
		System.out.println("list2() 호출 : " + shareClass.getShareData1());
		
		shareClass.setShareData1("난 listAction2에서 변경된 데이터");
		
		return "listview2";
	}
	
}
