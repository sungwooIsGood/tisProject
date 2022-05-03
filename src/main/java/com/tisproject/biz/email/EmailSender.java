package com.tisproject.biz.email;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;

// Email.java에서 정보를 get해서 보내주는 역할
public class EmailSender {

	@Autowired
	private JavaMailSender mailSender;
	
	
	public void sendEmail(EmailVO email) throws Exception {
		
		MimeMessage msg = mailSender.createMimeMessage();
		
		try {
			// MimeMessage 클래스의 제공되는 메소드
			msg.setSubject(email.getSubject()); // setSubject() => 메일 제목 설정
			msg.setText(email.getContent()); // setText() => 메일 내용 설정
			msg.setRecipients(MimeMessage.RecipientType.TO , InternetAddress.parse(email.getReceiver()));

		} catch (MessagingException e) {
			System.out.println("MessagingException 발생");
			e.printStackTrace();
		}
		
		try {
			mailSender.send(msg);
		} catch (MailException e) {
			System.out.println("MailException발생");
			e.printStackTrace();
		}
		
	}
}
