package com.project.member.mail;

import java.util.*;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class SendMail {
	public static void main(String args[]){
		
		// SMTP = 이메일을 송수신하는 서버  // JavaMail 라이브러리 사용
		
		String host = "smtp.naver.com"; // 네이버 smtp 사용
		String user = "kws332@naver.com"; // 발신자의 이메일 입력
		String password = "wonsikwonsik";
		
		// 네이버 SMTP 서버 정보를 설정
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");
		
		
		// SMTP 서버정보와 사용자 정보를 기반으로 Session 클래스의 인스턴스를 생성
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
				return new javax.mail.PasswordAuthentication(user, password);
			}
		});
		
		
		// Message 클래스 객체를 사용하여 수신자와 내용, 제목의 메시지 작성
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("kws332@naver.com"));
		
			// 메일 제목
			message.setSubject("메일 간다!");
		
			// 메일 내용
			message.setText("성공!");
		
			// send the message
			Transport.send(message); 
			System.out.println("Success Message Send");
	
			}catch(MessagingException e) {
				e.printStackTrace();
			}
		}
}
