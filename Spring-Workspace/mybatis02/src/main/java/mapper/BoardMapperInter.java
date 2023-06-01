package mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import model1.BoardTO;

@Mapper
public interface BoardMapperInter {

	@Select( "select seq, subject, writer, date_format(wdate, '%Y-%m-%d') wdate, hit, datediff(now(), wdate) wgap from board order by seq desc" )
	public ArrayList<BoardTO> boardList();
}
