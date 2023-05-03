package model2;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model1.BoardDAO;
import model1.BoardDTO;

public class ListAction implements BoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ListAction");
		
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardDTO> datas = dao.boardList();
		
		request.setAttribute("datas", datas);
	}

}
