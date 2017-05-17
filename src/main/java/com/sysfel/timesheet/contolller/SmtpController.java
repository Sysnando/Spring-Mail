package com.sysfel.timesheet.contolller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysfel.timesheet.model.Mail;
import com.sysfel.timesheet.service.SmtpMailSenderService;

@RestController
public class SmtpController {

	@Autowired
	public SmtpMailSenderService service;
	
	@RequestMapping("send-mail")
	public void sendMail(Mail mail){
		
		try{
			service.send(mail);	
		}
		catch (Exception e) {
			//TODO TRATAR ESSA EXECESSAO
			e.printStackTrace();
		}
	}
}
