package com.example.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.AlbumDAO;
import com.example.model.AlbumTO;
import com.example.model.CommentDAO;
import com.example.model.CommentTO;
import com.example.model.ImageDAO;
import com.example.model.ImageTO;

@RestController
public class AlbumController {

	@Autowired
	private AlbumDAO albumDAO;
	@Autowired
	private ImageDAO imageDAO;
	@Autowired
	private CommentDAO commentDAO;
	
	@RequestMapping( "/" )
	public ModelAndView mail(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_index1" );
		return modelAndView;
	}
	
	@RequestMapping( "/list.do" )
	public ModelAndView list(HttpServletRequest request) {
		
		ArrayList<AlbumTO> albumLists = albumDAO.albumList();
		ArrayList<ImageTO> imageLists = imageDAO.imageLatestList();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_list1" );
		modelAndView.addObject( "albumLists", albumLists );
		modelAndView.addObject( "imageLists", imageLists );
		return modelAndView;
	}
	
	@RequestMapping( "/view.do" )
	public ModelAndView view(HttpServletRequest request) {
		int seq = Integer.parseInt(request.getParameter( "seq" ));
		
		// 조회수 증가
		albumDAO.hitUpdate(seq);
		AlbumTO album = albumDAO.getAlbum(seq);
		ImageTO image = imageDAO.getImage(seq);
		ArrayList<CommentTO> commentList = commentDAO.getList(seq);
		
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_view1" );
		modelAndView.addObject( "album", album );
		modelAndView.addObject( "image", image );
		modelAndView.addObject( "commentList", commentList );
		return modelAndView;
	}
	
	@RequestMapping( "/modify.do" )
	public ModelAndView modify(HttpServletRequest request) {
		int seq = Integer.parseInt(request.getParameter( "seq" ));
		AlbumTO album = albumDAO.getAlbum(seq);
		ImageTO image = imageDAO.getImage(seq);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_modify1" );
		modelAndView.addObject( "album", album );
		modelAndView.addObject( "image", image );
		return modelAndView;
	}
	
	@RequestMapping( "/modify_ok.do" )
	public ModelAndView modify_ok(HttpServletRequest request, MultipartFile upload) {
		int seq = Integer.parseInt(request.getParameter( "seq" ));
		
		AlbumTO albumTO = albumDAO.getAlbum(seq);
		String writer =  request.getParameter("writer");
		String subject = request.getParameter("subject");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		// 첨부파일
		String latitude = request.getParameter("latitude");
		String longitude = request.getParameter("longitude");
		String mail1 = request.getParameter("mail1");
		String mail2 = request.getParameter("mail2");
		String mail = mail1 + "@" + mail2;
		
		albumTO.setWriter(writer);
		albumTO.setSubject(subject);
		albumTO.setPassword(password);
		albumTO.setContent(content);
		albumTO.setMail(mail);
		int flag = albumDAO.updateAlbum(albumTO);
		if(flag == 1) {
			String extension = upload.getOriginalFilename().substring( upload.getOriginalFilename().lastIndexOf( "." ) );
			String filename = upload.getOriginalFilename().substring( 0, upload.getOriginalFilename().lastIndexOf( "." ) );
			
			String uploadPath = "/Users/ksy/Desktop/KIC_JAVA_PRAC/SpringBoot/BootAlbumCmtBoard/src/main/webapp/upload";
			String newfilename = filename + "-" + System.currentTimeMillis() + extension;
			File uploadFile = new File(uploadPath + "/" + newfilename);
			
			try {
				upload.transferTo( uploadFile );
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				System.out.println( "[에러] " + e.getMessage() );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println( "[에러] " + e.getMessage() );
			}
			
			ImageTO imageTO = imageDAO.getImage(seq);
			imageTO.setImageName( newfilename );
			imageTO.setImageSize(upload.getSize());
			imageTO.setLatitude(latitude);
			imageTO.setLongitude(longitude);
			flag = imageDAO.updateImage(imageTO);
		}
		
		if(flag == 1) {
			flag = 0; // 글 수정 성공
		} else {
			flag = -1; // 글 수정 실패
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_modify1_ok" );
		modelAndView.addObject( "flag", flag );
		modelAndView.addObject( "seq", String.valueOf(seq) );
		return modelAndView;
	}
	
	@RequestMapping( "/write.do" )
	public ModelAndView write(HttpServletRequest request) {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_write1" );
		return modelAndView;
	}
	
	@RequestMapping( "/write_ok.do" )
	public ModelAndView write_ok(MultipartFile[] uploads, HttpServletRequest request) {
		
		AlbumTO albumTO = new AlbumTO();
		albumTO.setSubject( request.getParameter( "subject" ) );
		albumTO.setWriter( request.getParameter( "writer" ) );
		
		String mail = "";
		if( !request.getParameter( "mail1" ).equals("") && !request.getParameter( "mail2" ).equals("") ) {
			mail = request.getParameter( "mail1" ) + "@" + request.getParameter( "mail2" );	
		}
		albumTO.setMail( mail );
		albumTO.setPassword( request.getParameter( "password" ) );
		albumTO.setContent( request.getParameter( "content" ) );
		albumTO.setCmtMail( request.getParameter( "cmtmail" ) );
		albumTO.setWip( request.getRemoteAddr() );
		
		int flag1 = albumDAO.albumWriteOk( albumTO );
		
		for( MultipartFile upload : uploads ) {
			
			String extension = upload.getOriginalFilename().substring( upload.getOriginalFilename().lastIndexOf( "." ) );
			String filename = upload.getOriginalFilename().substring( 0, upload.getOriginalFilename().lastIndexOf( "." ) );
			
			String uploadPath = "/Users/ksy/Desktop/KIC_JAVA_PRAC/SpringBoot/BootAlbumCmtBoard/src/main/webapp/upload";
			String newfilename = filename + "-" + System.currentTimeMillis() + extension;
			File uploadFile = new File(uploadPath + "/" + newfilename);
			
			try {
//				upload.transferTo( new File( newfilename ) );
				upload.transferTo( uploadFile );
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				System.out.println( "[에러] " + e.getMessage() );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println( "[에러] " + e.getMessage() );
			}
			
			ImageTO imageTO = new ImageTO();
			imageTO.setPseq( albumTO.getSeq() );
			imageTO.setImageName( newfilename );
//			imageTO.setImageName( uploadFile.getAbsolutePath() );
			imageTO.setImageSize( upload.getSize() );
			imageTO.setLatitude( request.getParameter( "latitude" ) );
			imageTO.setLongitude( request.getParameter( "longitude" ) );
			
			int flag2 = imageDAO.imageWriteOk( imageTO );
		}
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_write1_ok" );
		modelAndView.addObject( "flag", flag1 );
		return modelAndView;
	}
	
	@RequestMapping( "/commentOk.do" )
	public ModelAndView commentOk(HttpServletRequest request) {
		String seq = request.getParameter("seq");
		String cwriter = request.getParameter("cwriter");
		String password = request.getParameter("cpassword");
		String ccontent = request.getParameter("ccontent");
		
		CommentTO commentTO = new CommentTO();
		commentTO.setPseq(seq);
		commentTO.setWriter(cwriter);
		commentTO.setPassword(password);
		commentTO.setContent(ccontent);
		
		int flag = commentDAO.commentWriteOk(commentTO);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName( "board_view1_comment_ok" );
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("flag", flag);
		return modelAndView;
	}
}











