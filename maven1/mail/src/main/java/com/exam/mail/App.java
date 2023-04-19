package com.exam.mail;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MailSender mailsender = new MailSender("구글 로그인 이메일", "앱비밀번호");
        
        String toEmail = "받는 사람 이메일";
        String toName = "테스터";
        String subject = "테스트 메일 제목";
        String content = "테스트 메일 내용";
        
        mailsender.sendMail(toEmail, toName, subject, content);
    }
}
