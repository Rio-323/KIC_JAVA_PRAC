package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class FormOK implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println( "FormOk 호출 : " + request.getParameter( "data" ) );
		
		// 전통방식
		//request.setAttribute( "data", request.getParameter( "data" ) );
		
		// Spring 방식
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "form_ok" );
		modelAndView.addObject( "data", request.getParameter( "data" ) );
		
		return modelAndView;
	}

}
