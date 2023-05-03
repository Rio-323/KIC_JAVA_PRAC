package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormOkAction implements Action {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("FormOkAction");
	}
}
