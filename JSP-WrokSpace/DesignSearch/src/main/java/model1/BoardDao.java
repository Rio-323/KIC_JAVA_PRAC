package model1;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;

import mapper.BoardMapperInter;

public class BoardDao {
    private SqlSession sqlSession;
    private BoardMapperInter mapper;
    
    public BoardDao() {
		// TODO Auto-generated constructor stub
    	
    	String resource = "myBatisConfig.xml";

		InputStream is = null;
		
		try {
			
			
			is = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

			this.sqlSession = sessionFactory.openSession(true);

			this.sqlSession.getConfiguration().addMapper(BoardMapperInter.class);

			this.mapper = (BoardMapperInter)sqlSession.getMapper(BoardMapperInter.class);

		
		} catch (IOException e) {
			System.out.println("[에러]"+e.getMessage());
		} finally {
			if(is!=null) try {is.close();} catch(IOException e) {};
		}
		
    }
    /////////////////////////////////////////////////////////////////
		public List<BoardTo> selectBoardList() {

			//System.out.println("\n" +  "selectBoardList() 호출" + "\n");

			List<BoardTo> datas = mapper.selectBoardList();

			//System.out.println("\n" + "datas : " + datas + "\n");


			return datas;
		}
		
		//List 에서 session을 close해버리면 else문으로 실행될 searchList메서드가 실행이 안되버림.
	    /////////////////////////////////////////////////////////////////
		
		public List<BoardTo> searchList(String searchKey, String searchWord) {
			
			//System.out.println("\nsearchList() 호출\n");
			

		    List<BoardTo> datas = new ArrayList<>();

		    if (searchKey == null || searchKey.isEmpty()) {
		        return datas; 
		    }
			
			//List<BoardTo> datas = mapper.searchList(searchKey, searchWord);
			//List<BoardTo> datas;
			
			  switch (searchKey) {
		        case "subject":
		            datas = mapper.searchBySubject(searchWord);
		            break;
		        case "content":
		        	 datas = mapper.searchByContent(searchWord);
		             break;
		        case "writer":
		        	 datas = mapper.searchByWriter(searchWord);
		             break;
		        default:
		            throw new IllegalArgumentException("다시! : " + searchKey);
		            
			  }
			  
			if(sqlSession !=null)sqlSession.close();  
			return datas;
		}
		
		/////////////////////////////////////////
		
		public void boardWrite() {
		}

		/////////////////////////////////////////
		
		
		public int boardWriteOk(BoardTo to) {

			int flag = 1;

			int result = mapper.insertWriteOk(to);

			//System.out.println("\n" +  "writeok 호출" + "\n");

			if(result == 1) {
				flag = 0;
			}

			//System.out.println("\n" +  "flag :" + flag + "\n");

			if(sqlSession !=null)sqlSession.close();
			return flag;
		}
		
		public BoardTo boardView(BoardTo to) {

			//view hit 보여주는 것
			mapper.updateBoardViewHit(to);

			//System.out.println("\n" +  "boardViewHit()호출" + "\n");

			//view를 보여주는 것
			to = mapper.selectBoardView(to);

			//System.out.println("\n" +  "boardView()호출" + "\n");

			if(sqlSession !=null)sqlSession.close();
			return to;
		}
		
		public BoardTo boardModify(BoardTo to) {

			//System.out.println("\n" +  "boardModify()호출" + "\n");

			to = mapper.selectModify(to);

			if(sqlSession !=null)sqlSession.close();

			return to;
		}
		
		/////////////////////////////////////////

		public int boardModifyOk(BoardTo to) {

			int flag = 2;

			int result = mapper.updateModifyOk(to);

			//System.out.println("\n" +  "boardModifyOk()호출" + "\n");

			if(result == 1) {
				flag = 0;
			}else if(result ==0) {
				flag = 1;
			}

			if(sqlSession !=null)sqlSession.close();
			return flag;
		}
		/////////////////////////////////////////

		public BoardTo boardDelete(BoardTo to) {

			//System.out.println("\n" +  "boardDelete()호출" + "\n");

			to = mapper.selectDelete(to);

			if(sqlSession !=null)sqlSession.close();
			return to;
		}

		/////////////////////////////////////////

		public int boardDeleteOk(BoardTo to) {

			//System.out.println("\n" +  "boardDeleteOk()호출" + "\n");
			
			int flag=2;

			int result = mapper.deleteDeleteOk(to);

			if(result == 1) {
				flag = 0;
			}else if(result ==0) {
				flag = 1;
			}


			if(sqlSession !=null)sqlSession.close();
			return flag;
		}
		
		
//		public class searchList {
//			public String searchList(Map<String, Object> params) {
//		        String searchKey = (String) params.get("searchKey");
//		        String searchWord = (String) params.get("searchWord");
//
//		        StringBuilder sql = new StringBuilder();
//		        sql.append("SELECT seq, subject, writer, mail, password, content, hit, wip, date_format(wdate, '%Y-%m-%d') wdate, datediff(now(), wdate) wgap FROM board1 ");
//
//		        if (!searchWord.equals("")) {
//		            switch (searchKey) {
//		                case "subject":
//		                    sql.append("WHERE subject LIKE CONCAT('%', #{searchWord}, '%') ");
//		                    break;
//		                case "content":
//		                    sql.append("WHERE content LIKE CONCAT('%', #{searchWord}, '%') ");
//		                    break;
//		                case "writer":
//		                    sql.append("WHERE writer LIKE CONCAT('%', #{searchWord}, '%') ");
//		                    break;
//		                default:
//		                    throw new IllegalArgumentException("Invalid searchKey: " + searchKey);
//		            }
//		        }
//		        
//		        sql.append("ORDER BY seq DESC");
//
//		        return sql.toString();
//		    }
//		}
		//}
//	////////////////////////////////////////	
//	public List<BoardTo> searchWriter() {
//			
//			System.out.println("\n" +  "searchWriter() 호출" + "\n");
//
//			List<BoardTo> datas = mapper.SearchSubject();
//			if(sqlSession !=null)sqlSession.close();
//			
//			return datas;
//		}
//	////////////////////////////////////////
//	
//	public List<BoardTo> searchContent() {
//		
//		System.out.println("\n" +  "searchContent() 호출" + "\n");
//
//		List<BoardTo> datas = mapper.SearchSubject();
//		if(sqlSession !=null)sqlSession.close();
//		
//		return datas;
//	}
	
	}
