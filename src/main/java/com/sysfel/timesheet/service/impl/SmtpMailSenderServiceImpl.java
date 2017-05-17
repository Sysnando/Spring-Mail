package com.sysfel.timesheet.service.impl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.sysfel.timesheet.model.Mail;
import com.sysfel.timesheet.service.SmtpMailSenderService;

@Service
public class SmtpMailSenderServiceImpl implements SmtpMailSenderService{

	@Autowired
	public JavaMailSender javaMailSender;
	
	public void send(Mail mail) throws MessagingException {
		MimeMessage message = javaMailSender.createMimeMessage();
		
				// use the true flag to indicate you need a multipart message
		MimeMessageHelper helper = new MimeMessageHelper(message, true);
		// use the true flag to indicate the text included is HTML
		helper.setTo(mail.getToAddress());
		helper.setSubject(mail.getSubject());
		
		helper.setText(mail.getMessage(), true);
		helper.addAttachment(mail.getAttachmentFilename(), mail.getInputStreamSource());
		
		// let's include the infamous windows Sample file (this time copied to c:/)
//		FileSystemResource res = new FileSystemResource(new File("c:/Sample.jpg"));
//		helper.addInline("identifier1234", res);
		
		javaMailSender.send(message);
	}

}
