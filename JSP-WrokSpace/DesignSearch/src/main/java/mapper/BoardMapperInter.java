package mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import model1.BoardTo;
import model1.BoardTo;

public interface BoardMapperInter {
	
	//subject검색
//	@Select("SELECT seq, subject, writer, mail, password, content, hit, wip, wdate FROM board1 WHERE #{searchKey} LIKE CONCAT('%', #{searchWord}, '%'")
//	public List<BoardTo> searchList(String searchKey, String searchWord);
	
	@Select("SELECT seq, subject, writer, mail, password, content, hit, wip, date_format(wdate, '%Y-%m-%d') wdate, datediff(now(), wdate) wgap FROM board WHERE subject LIKE CONCAT('%', #{searchWord}, '%') ORDER BY seq DESC")
	List<BoardTo> searchBySubject(String searchWord);

	@Select("SELECT seq, subject, writer, mail, password, content, hit, wip, date_format(wdate, '%Y-%m-%d') wdate, datediff(now(), wdate) wgap FROM board WHERE content LIKE CONCAT('%', #{searchWord}, '%') ORDER BY seq DESC")
	List<BoardTo> searchByContent(String searchWord);

	@Select("SELECT seq, subject, writer, mail, password, content, hit, wip, date_format(wdate, '%Y-%m-%d') wdate, datediff(now(), wdate) wgap FROM board WHERE writer LIKE CONCAT('%', #{searchWord}, '%') ORDER BY seq DESC")
	List<BoardTo> searchByWriter(String searchWord);

	
//	//writer검색
//	@Select("select seq, subject, writer, mail, password, content, hit, wip, wdate from board1 where #{searchKey}=#{searchw}")
//	public List<BoardTo> SearchWriter();
//		
//	//content검색
//	@Select("select seq, subject, writer, mail, password, content, hit, wip, wdate from board1 where #{searchWriter}=#{searchw}")
//	public List<BoardTo> SearchContent();
	
	//list.jsp
	@Select("select seq, subject, writer, date_format(wdate, '%Y-%m-%d') wdate, hit, datediff(now(), wdate) wgap from board order by seq desc")
	public List<BoardTo> selectBoardList();
	
	//view.jsp
	@Select("select seq, subject, writer, mail, wip, wdate, hit, content from board where seq=#{seq}")
	public BoardTo selectBoardView(BoardTo to);
	
	//viewHit.jsp
	@Update("update board set hit=hit+1 where seq=#{seq}")
	public int updateBoardViewHit(BoardTo to);
	
	//writeOk.jsp
	@Insert("insert into board values ( 0, #{subject}, #{writer}, #{mail}, #{password},#{content}, 0, #{wip}, now() )")
	public int insertWriteOk(BoardTo to);
	
	//Modify.jsp
	@Select("select seq, subject, writer, mail, content from board where seq=#{seq}")
	public BoardTo selectModify(BoardTo to);
	
	//ModifyOk.jsp
	@Update("update board set subject=#{subject}, mail=#{mail}, content=#{content} where seq=#{seq} and password=#{password}")
	public int updateModifyOk(BoardTo to);
	
	//Delete.jsp
	@Select("select seq, subject, writer from board where seq=#{seq}")
	public BoardTo selectDelete(BoardTo to);
	
	//DeleteOk.jsp
	@Delete("delete from board where seq=#{seq} and password=#{password}")
	public int deleteDeleteOk(BoardTo to);
}
