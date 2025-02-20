package com.gc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class MailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(String to, String subject,String body)
	{
		
		SimpleMailMessage msg= new SimpleMailMessage();
		msg.setTo(to);
		msg.setSubject(subject);
		msg.setText(body);
		msg.setFrom("rishikeshjawale01@gmail.com");
		
		mailSender.send(msg);
		System.out.println("Email Sent");
	}

}
