package com.exam.mail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSender {
	private String fromEmail;
	private String fromPassword;
	
	public MailSender(String fromEmail, String fromPassword) {
		this.fromEmail = fromEmail;
		this.fromPassword = fromPassword;
	}
	
	public void sendMail(String toEmail, String toName, String subject, String content) {
		// Google SMTP서버에 대한 접속 환경 설정
		try {
			// SSL방식
			Properties props = new Properties();
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.transport.protocol", "smtp");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "465");
			
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			
			// 인증환경
			MyAuthenticator authenticator = new MyAuthenticator(fromEmail, fromPassword);
			
			Session session = Session.getDefaultInstance(props, authenticator);
			
			MimeMessage msg = new MimeMessage(session);
			// msg.setHeader("Content-type", "text/plain;charset=utf-8");
			msg.setHeader("Content-type", "text/html;charset=utf-8");
			
			msg.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail, toName, "utf-8"));
			msg.setSubject(subject);
			// msg.setContent(content, "text/plain; charset=utf-8");
			msg.setContent(content, "text/html; charset=utf-8");
			
			msg.setSentDate(new java.util.Date());
			
			Transport.send(msg);
			
			System.out.println("메일이 전송되었습니다.");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
