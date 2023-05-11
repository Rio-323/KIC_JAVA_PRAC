package mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import model1.BoardTO;

public interface BoardMapperInter {
	
	@Select("select seq, subject, writer, date_format(wdate, '%Y-%m-%d') wdate, hit, datediff(now(), wdate) wgap from board order by seq desc")
	public ArrayList<BoardTO> boardList();
	
	@Select("select seq, subject, writer, mail, wip, wdate, hit, content from board where seq=#{seq}")
	public BoardTO boardView(BoardTO to);
	
	@Update("update board set hit=hit+1 where seq=#{seq}")
	public int boardViewHit(BoardTO to);
	
	@Insert("insert into board values ( 0, #{subject}, #{writer}, #{mail}, #{password}, #{content}, 0, #{wip}, now() )")
	public int boardWriteOk(BoardTO to);
	
	@Select("select seq, subject, writer, mail, content from board where seq=#{seq}")
	public BoardTO boardModify(BoardTO to);
	
	@Update("update board set subject=#{subject}, mail=#{mail}, content=#{content} where password=#{password} and seq=#{seq}")
	public int boardModifyOk(BoardTO to);
	
	@Select("select seq, subject, writer from board where seq = #{seq}")
	public BoardTO boardDelete(BoardTO to);
	
	@Delete("delete from board where seq = #{seq} and password = #{password}")
	public int boardDeleteOk(BoardTO to);
}
