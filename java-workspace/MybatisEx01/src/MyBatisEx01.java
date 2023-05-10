import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import model1.DeptTO;


public class MyBatisEx01 {

	public static void main(String[] args) {
		String resource = "myBatisConfig.xml";
		
		InputStream is = null;
		SqlSession sqlSession = null;
		
		try {
			
			is = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			System.out.println("설정 호출");
			
			// 연결은 session의 개념
			sqlSession = sqlSessionFactory.openSession();
			System.out.println("연결 성공");
			
			// 한줄의 데이터 : selectOne
			// 여러줄의 데이터 : selectList
			DeptTO to = (DeptTO)sqlSession.selectOne("deptlist");
			
		} catch (IOException e) {
			System.out.println("[Error] : " + e.getMessage());
		} finally {
			if(is != null) { try { is.close(); } catch(IOException e) { System.out.println("[Error] : " + e.getMessage()); } }
			if(sqlSession != null) sqlSession.close(); 
		}
			
			
	}

}
