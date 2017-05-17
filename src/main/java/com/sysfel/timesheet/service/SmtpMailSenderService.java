package com.sysfel.timesheet.service;

import javax.mail.MessagingException;

import com.sysfel.timesheet.model.Mail;

public interface SmtpMailSenderService {
	public void send(Mail mail) throws MessagingException;
}
