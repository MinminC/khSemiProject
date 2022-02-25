package com.kh.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuth extends Authenticator{
	
	
	PasswordAuthentication pa;
	
	
	public MailAuth() {
		
		Properties prop = new Properties();
		
		
		// 읽어들이고자하는 파일의 물리적인 경로
		String fileName = MailAuth.class.getResource("/sql/driver/driver.properties").getPath();
		
		try {
			prop.load(new FileInputStream(fileName));
			String mail_id = prop.getProperty("email");
			String mail_pw = prop.getProperty("emailPwd");
			pa = new PasswordAuthentication(mail_id, mail_pw);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

	public PasswordAuthentication getPasswordAuthentication() {
		
        return pa;
    }
	
	
}
