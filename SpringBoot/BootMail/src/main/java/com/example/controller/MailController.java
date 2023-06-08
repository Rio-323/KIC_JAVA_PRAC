package com.example.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MailController {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@RequestMapping("/mail.do")
	public ModelAndView mail(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("mail");
		
		return modelAndView;
	}
	
	@RequestMapping("/mail_ok.do")
	public ModelAndView mail_ok(HttpServletRequest request) {
		System.out.println("JavaMailSender : " + javaMailSender);
		
		String toEmail = "받는 사람의 이메일";
		String toName = "테스터";
		String subject = "테스트 제목";
		String content = "테스트 내용";
		
		this.mailSender(toEmail, toName, subject, content);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("mail_ok");
		
		return modelAndView;
	}
	
	public void mailSender(String toEmail, String toName, String subject, String content) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		
		simpleMailMessage.setTo(toEmail);
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(content);
		simpleMailMessage.setSentDate(new Date());
		
		javaMailSender.send(simpleMailMessage);
		
		System.out.println("전송 완료");
	}
}
