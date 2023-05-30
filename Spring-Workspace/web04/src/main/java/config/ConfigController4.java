package config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConfigController4 {
	
	
	@RequestMapping("/form.do")
	public ModelAndView handleRequest1() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("form");
		
		return modelAndView;
	}
	/*
	// @RequestMapping(value = "/form_ok.do", method = RequestMethod.GET)
	@GetMapping("/form_ok.do")
	public ModelAndView form_get_ok() {
		
		System.out.println("form_get_ok() 호출");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("form_ok");
		
		return modelAndView;
	}
	
	
	// @RequestMapping(value = "/form_ok.do", method = RequestMethod.POST)
	@PostMapping("/form_ok.do")
	public ModelAndView form_post_ok() {
		
		System.out.println("form_post_ok() 호출");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("form_ok");
		
		return modelAndView;
	}
	
	*/
	
	/*
		@RequestMapping("/form_ok.do")
		public ModelAndView form_ok(HttpServletRequest request, HttpServletResponse response) {
			
			System.out.println("form_ok() 호출 : " + request.getParameter("data"));
			
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("form_ok");
			
			return modelAndView;
		}
		
	*/
	
	/*
	@RequestMapping("/form_ok.do")
	public ModelAndView form_ok(String data1, String data2) {
		
		System.out.println("form_ok() 호출 : " + data1);
		System.out.println("form_ok() 호출 : " + data2);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("form_ok");
		
		return modelAndView;
	}
	*/
	
	/*
	@RequestMapping("/form_ok.do")
	public ModelAndView form_ok(@RequestParam("data1") String pdata1, @RequestParam("data2") String pdata2) {
		
		System.out.println("form_ok() 호출 : " + pdata1);
		System.out.println("form_ok() 호출 : " + pdata2);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("form_ok");
		
		return modelAndView;
	}
	*/
	
	/*
	@RequestMapping("/form_ok.do")
	public String form_ok(HttpServletRequest request) {
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("form_ok");
		request.setAttribute("data1", request.getParameter("data1"));
		
		return "form_ok";
	}
	*/
	
	/*
	@RequestMapping("/form_ok.do")
	public ModelAndView form_ok(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("form_ok");
		modelAndView.addObject("data1", request.getParameter("data1"));
		
		return modelAndView;
	}
	*/
	
	@RequestMapping("/form_ok.do")
	public String form_ok(HttpServletRequest request, Model model) {
		
		model.addAttribute("data1", request.getParameter("data1"));
		
		return "form_ok";
	}
}
