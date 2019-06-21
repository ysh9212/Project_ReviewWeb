package com.project.member.mail;

import java.util.*;


public class SendMail {
	public static void main(String args[]){
		
		// SMTP = �씠硫붿씪�쓣 �넚�닔�떊�븯�뒗 �꽌踰�  // JavaMail �씪�씠釉뚮윭由� �궗�슜
		
		String host = "smtp.naver.com"; // �꽕�씠踰� smtp �궗�슜
		String user = "kws332@naver.com"; // 諛쒖떊�옄�쓽 �씠硫붿씪 �엯�젰
		String password = "wons";
		
		// �꽕�씠踰� SMTP �꽌踰� �젙蹂대�� �꽕�젙
		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", "true");
		
		/*
		// SMTP �꽌踰꾩젙蹂댁� �궗�슜�옄 �젙蹂대�� 湲곕컲�쑝濡� Session �겢�옒�뒪�쓽 �씤�뒪�꽩�뒪瑜� �깮�꽦
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
				return new javax.mail.PasswordAuthentication(user, password);
			}
		});
		
		
		// Message �겢�옒�뒪 媛앹껜瑜� �궗�슜�븯�뿬 �닔�떊�옄�� �궡�슜, �젣紐⑹쓽 硫붿떆吏� �옉�꽦
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("kws332@naver.com"));
		
			// 硫붿씪 �젣紐�
			message.setSubject("硫붿씪 媛꾨떎!");
		
			// 硫붿씪 �궡�슜
			message.setText("�꽦怨�!");
		
			// send the message
			Transport.send(message); 
			System.out.println("Success Message Send");
	
			}catch(MessagingException e) {
				e.printStackTrace();
			}
		*/
		}
}
