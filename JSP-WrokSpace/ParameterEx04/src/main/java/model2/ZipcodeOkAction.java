package model2;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model1.ZipcodeDAO;
import model1.ZipcodeTo;

public class ZipcodeOkAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String strDong = request.getParameter("dong");
		System.out.println(strDong);
		
		ZipcodeDAO dao = new ZipcodeDAO();
		ArrayList<ZipcodeTo> datas = dao.listZipcode(strDong);
		
		System.out.println("갯수 : " + datas.size());
		
		request.setAttribute("datas", datas);
	}

}
