package model1;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardDAO {
	private SqlSession sqlSession;
	
	public BoardDAO() {
		// TODO Auto-generated constructor stub
		String resource = "myBatisConfig.xml";

		InputStream is = null ;

		try {
			is = Resources.getResourceAsStream( resource );
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build( is );
           
			this.sqlSession = sqlSessionFactory.openSession( true );
		} catch( IOException e ) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] : " + e.getMessage() );
		} finally {
			if( is != null ) try { is.close(); } catch( IOException e ) {}
		}
	}
	
	public void boardWrite() {	
	}
	
	public int boardWriteOk(BoardTO to) {
		int flag = 1;
		
		int result = sqlSession.insert( "write_ok", to );
		if( result == 1 ) {
			flag = 0;
		}
		
		if( sqlSession != null ) sqlSession.close();
		return flag;				
	}
	
	public ArrayList<BoardTO> boardList() {
		ArrayList<BoardTO> datas = (ArrayList)sqlSession.selectList( "list" );
		
		if( sqlSession != null ) sqlSession.close();
		return datas;
	}
	
	public BoardTO boardView(BoardTO to) {
		
		sqlSession.update( "view_hit", to );
		
		to = sqlSession.selectOne( "view", to );
		
		if( sqlSession != null ) sqlSession.close();
		return to;
	}
	
	public BoardTO boardModify(BoardTO to) {
		to = sqlSession.selectOne( "modify", to );
		
		if( sqlSession != null ) sqlSession.close();
		return to;
	}
    
	public int boardModifyOk(BoardTO to) {
		int flag = 2;
		int result = sqlSession.update( "modify_ok", to );

		if( result == 1 ) {
			flag = 0;
		} else if( result == 0 ) {
			flag = 1;               
		}
		
		if( sqlSession != null ) sqlSession.close();
		return flag;
	}
	
	public BoardTO boardDelete(BoardTO to) {
		return to;
	}
	
	public int boardDeleteOk(BoardTO to) {
		int flag = 2;
		return flag;
	}
}






