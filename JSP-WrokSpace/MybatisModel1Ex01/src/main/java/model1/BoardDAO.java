package model1;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAO {
	private SqlSession sqlSession = null;
	
	
	public BoardDAO() {
		String resource = "myBatisConfig.xml";
		
		InputStream is = null;
		
		try {
			
			is = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			
			this.sqlSession = sqlSessionFactory.openSession(true);
			
			
		} catch (IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally {
			if(is != null) { try { is.close(); } catch (IOException e) { System.out.println("[Error] : " + e.getMessage()); } }
		}
	}
	
	public void boardWrite() {
		
	}
	
	public int boardWriteOk(BoardDTO dto) {
		
		// flag -> 0 : 정상 /  1 -> 비정상
		int flag = 1;
		
		int result = sqlSession.insert("write_ok", dto);
		
		if(result == 1) {
			flag = 0;
		}
		
		if(sqlSession != null) sqlSession.close();
		
		return flag;
	}
	
	public ArrayList<BoardDTO> boardList() {
		ArrayList<BoardDTO> datas = (ArrayList)sqlSession.selectList("list");
		
		if(sqlSession != null) sqlSession.close();
		
		return datas;
	}
	
	public BoardDTO boardView(BoardDTO dto) {
		
		sqlSession.update("view_hit", dto);
		
		dto = sqlSession.selectOne("view", dto);
		
		if(sqlSession != null) sqlSession.close();
		
		return dto;
	}
	
	public BoardDTO boardModify(BoardDTO dto) {
		dto = sqlSession.selectOne("modify", dto);
		
		if(sqlSession != null) sqlSession.close();
		
		return dto;
	}
	
	public int boardModifyOk(BoardDTO dto) {
		
		// flag -> 0 : 정상 /  1 -> 비정상
		int flag = 2;
		
		return flag;
	}
	
	public BoardDTO boardDelete(BoardDTO dto) {
		
		return dto;
	}
	
	public int boardDeleteOk(BoardDTO dto) {

		int flag = 2;
		
		return flag;
	}

}