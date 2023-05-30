package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class ZipcodeAction implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println( "Zipcode 호출" );
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("zipcode");
		

		return modelAndView;
	}

}
