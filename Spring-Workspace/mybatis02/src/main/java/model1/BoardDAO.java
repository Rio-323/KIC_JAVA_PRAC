package model1;

import java.util.ArrayList;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mapper.BoardMapperInter;

@Repository
@MapperScan( "mapper" )
public class BoardDAO {

	@Autowired
	private BoardMapperInter mapper;
	
	public ArrayList<BoardTO> boardList() {
		ArrayList<BoardTO> boardLists = (ArrayList<BoardTO>)mapper.boardList();
		return boardLists;
	}
	
}
