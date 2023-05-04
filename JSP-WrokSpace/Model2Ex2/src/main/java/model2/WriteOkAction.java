package model2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model1.BoardDAO;
import model1.BoardDTO;

public class WriteOkAction implements BoardAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("WriteOkAction");
		
		
		BoardDTO dto = new BoardDTO();
		
		dto.setSubject(request.getParameter("subject"));
		dto.setWriter(request.getParameter("writer"));
		
		dto.setMail("");
		
		if(!request.getParameter("mail1").equals("") && !request.getParameter("mail2").equals("")) {
			dto.setMail( request.getParameter("mail1") + "@" + request.getParameter("mail2"));
		}
		
		dto.setPasword(request.getParameter("password"));
		dto.setContent(request.getParameter("content"));
		dto.setWip(request.getRemoteAddr());
		
		BoardDAO dao = new BoardDAO();
		int flag = dao.boardWriteOk(dto);
		
		request.setAttribute("flag", flag);
	}

}
