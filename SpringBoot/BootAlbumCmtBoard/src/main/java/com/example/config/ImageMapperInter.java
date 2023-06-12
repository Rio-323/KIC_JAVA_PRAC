package com.example.config;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.model.ImageTO;

public interface ImageMapperInter {

	@Select( "select seq, pseq, imagename, imagesize from album_cmt_image2 where seq in ( select max(seq) from album_cmt_image2 group by pseq )" )
	public ArrayList<ImageTO> imageLatestList();
	
	@Select( "select seq, pseq, imagename, imagesize, latitude, longitude from album_cmt_image2 where seq = #{seq}" )
	public ImageTO getImage(int seq);
	
	@Update( "update album_cmt_image2 set imageName = #{imageName}, imageSize = #{imageSize}, latitude = #{latitude}, longitude = #{longitude} where seq = #{seq}" )
	public int updateImage(ImageTO imageTO);
	
	@Select( "select imagename, imagesize from album_cmt_image2 where pseq=#{pseq}" )
	public ArrayList<ImageTO> imageAllList();

	@Insert( "insert into album_cmt_image2 values (0, #{pseq}, #{imageName}, #{imageSize}, #{latitude}, #{longitude}, now() )" )
	public int imageWriteOk(ImageTO to);
}
