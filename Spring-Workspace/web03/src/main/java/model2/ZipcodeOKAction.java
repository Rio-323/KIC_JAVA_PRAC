package model2;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model1.ZipcodeDAO;
import model1.ZipcodeTO;

public class ZipcodeOKAction implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println( "ZipcodeOk 호출");
		
		String strDong = request.getParameter("dong");
		// System.out.println(strDong);
		
		ZipcodeDAO dao = new ZipcodeDAO();
		ArrayList<ZipcodeTO> lists = dao.zipcodeList(strDong);
		
		// System.out.println(lists.size());
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("zipcode_ok");
		modelAndView.addObject("lists", lists);
		
		return modelAndView;
	}

}
