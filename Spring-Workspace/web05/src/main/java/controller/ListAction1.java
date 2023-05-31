package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import share.ShareClass;

public class ListAction1 implements Controller {
	private ShareClass shareClass;
	

	public void setShareClass(ShareClass shareClass) {
		this.shareClass = shareClass;
	}


	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ListAction1() 호출");
		
		System.out.println("shareClass : " + shareClass);
		
		// System.out.println("shareData1 : " + shareClass.getShareData1());
		
		
		return new ModelAndView("listview1");
	}

}
