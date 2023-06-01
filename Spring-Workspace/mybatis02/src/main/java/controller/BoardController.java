package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import model1.BoardDAO;
import model1.BoardTO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO dao; 
	
	@RequestMapping( "/list.do" )
	public String list( HttpServletRequest request, HttpServletResponse response, Model model ) {
		
		ArrayList<BoardTO> lists = dao.boardList();
	
		model.addAttribute( "lists", lists );
		
		return "board_list1";
	}
}