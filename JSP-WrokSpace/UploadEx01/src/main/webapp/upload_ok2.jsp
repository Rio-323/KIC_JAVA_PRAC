<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>

<%
	// 1. 업로드 경로 - 절대경로
	// 2. 업로드 제한 용량 - byte
	// 3. 인코딩
	String uploadPath = "/Users/ksy/Desktop/KIC_JAVA_PRAC/JSP-WrokSpace/UploadEx01/src/main/webapp/upload";
	int maxFileSize = 4 * 1024 * 1024; // MB
	String encodingType = "utf-8";
	
	MultipartRequest multipartRequest = new MultipartRequest(request, uploadPath, maxFileSize, encodingType, new DefaultFileRenamePolicy());
	
	out.println("전송 완료<br>");
	out.println("파일명 : " + multipartRequest.getFilesystemName("upload1") + "<br>");
	out.println("파일명 : " + multipartRequest.getOriginalFileName("upload1") + "<br>");
	
	out.println("파일명 : " + multipartRequest.getFilesystemName("upload2") + "<br>");
	out.println("파일명 : " + multipartRequest.getOriginalFileName("upload2") + "<br>");
	
%>
