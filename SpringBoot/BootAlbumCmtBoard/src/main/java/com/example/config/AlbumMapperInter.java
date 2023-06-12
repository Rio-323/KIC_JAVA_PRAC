package com.example.config;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.AlbumTO;

public interface AlbumMapperInter {
	
	@Update( "update album_cmt_board2 set hit = hit+1 where seq = #{seq}" )
	public void hitUpdate(int seq);

	@Select( "select seq, subject, writer, cmtcnt, date_format(wdate, '%Y-%m-%d') wdate, hit, datediff(now(), wdate) wgap from album_cmt_board2 order by seq desc" )
	public ArrayList<AlbumTO> albumList();
	
	@Select( "select seq, subject, writer, cmtcnt, date_format(wdate, '%Y-%m-%d') wdate, hit, wip, mail, content, datediff(now(), wdate) wgap from album_cmt_board2 where seq = #{seq} order by seq desc" )
	public AlbumTO getAlbum(int seq);
	
	@Update( "update album_cmt_board2 SET subject = #{subject}, writer = #{writer}, mail = #{mail}, password = #{password}, content = #{content} WHERE seq = #{seq}" )
	public int updateAlbum(AlbumTO albumTO);
	
	@Insert( "insert into album_cmt_board2 values (0, #{subject}, #{writer}, #{mail}, #{password}, #{content}, 0, #{cmtMail}, 0, #{wip}, now() )" )
	@Options( useGeneratedKeys=true, keyProperty="seq" )
	public int albumWriteOk(AlbumTO to);
	
}
