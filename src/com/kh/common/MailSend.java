package com.kh.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailSend {
   
   public void welcomeMailSend(String email, Object temporary, int num) {
      
      Properties prop1 = System.getProperties();

      // 로그인시 TLS를 사용할 것인지 설정
      prop1.put("mail.smtp.starttls.enable", "true");

      // 이메일 발송을 처리해줄 SMTP서버
      prop1.put("mail.smtp.host", "smtp.gmail.com");

      // SMTP 서버의 인증을 사용한다는 의미
      prop1.put("mail.smtp.auth", "true");

      // TLS의 포트번호는 587이며 SSL의 포트번호는 465이다.
      prop1.put("mail.smtp.port", "587");

      Authenticator auth = new MailAuth();

      Session session = Session.getDefaultInstance(prop1, auth);

      MimeMessage msg = new MimeMessage(session);

      try {
         Properties prop2 = System.getProperties();
         
         // 읽어들이고자하는 파일의 물리적인 경로
         String fileName = MailSend.class.getResource("/sql/driver/driver.properties").getPath();
         
         try {
            prop2.load(new FileInputStream(fileName));
            // 발송자를 지정한다. 발송자의 메일, 발송자명
            msg.setFrom(new InternetAddress(prop2.getProperty("sendemail"), prop2.getProperty("sendtitle")));
         } catch (FileNotFoundException e) {
            
            e.printStackTrace();
         } catch (IOException e) {
            
            e.printStackTrace();
         }
         
         // 보내는 날짜 지정
         msg.setSentDate(new Date());
         
         // 수신자의 메일을 생성한다.
         InternetAddress to = new InternetAddress(email);

         // Message 클래스의 setRecipient() 메소드를 사용하여 수신자를 설정한다. setRecipient() 메소드로 수신자, 참조,
         // 숨은 참조 설정이 가능하다.
         // Message.RecipientType.TO : 받는 사람
         // Message.RecipientType.CC : 참조
         // Message.RecipientType.BCC : 숨은 참조
         msg.setRecipient(Message.RecipientType.TO, to);
         // 메일의 제목 지정
         msg.setSubject("환영합니다.", "UTF-8");

         // Transport는 메일을 최종적으로 보내는 클래스로 메일을 보내는 부분이다.
         if(num == 1) {
            
            msg.setText("인증 번호는 : " + temporary + " 입니다.", "UTF-8");
         }else {
            msg.setText("임시 비밀  번호는 : " + temporary + " 입니다.", "UTF-8");
            
         }

         Transport.send(msg);
      } catch (AddressException ae) {
         System.out.println("AddressException : " + ae.getMessage());
      } catch (MessagingException me) {
         System.out.println("MessagingException : " + me.getMessage());
      }
      
      
   }

}