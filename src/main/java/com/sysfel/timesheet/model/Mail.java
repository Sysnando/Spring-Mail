package com.sysfel.timesheet.model;

import java.util.Date;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamSource;

public class Mail {

	private String toAddress;
	private String subject;
	private String message;

	private byte[] attachmentBytes;

	private String attachmentFilename;

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public byte[] getAttachmentBytes() {
		return attachmentBytes;
	}

	public void setAttachmentBytes(byte[] attachmentBytes) {
		this.attachmentBytes = attachmentBytes;
	}

	public String getAttachmentFilename() {
		return attachmentFilename;
	}

	public void setAttachmentPDFFilename(Long idJob, Date dateTimesheet, Long idCustomer) {
		StringBuffer attachmentFilename = new StringBuffer();
		attachmentFilename.append(System.currentTimeMillis());
		if (idJob != null) {
			attachmentFilename.append("_").append(idJob);
		} 
		if (dateTimesheet != null) {
			attachmentFilename.append("_").append(dateTimesheet.getTime());
		} 
		if (idCustomer != null) {
			attachmentFilename.append("_").append(idCustomer);
		}
		
		attachmentFilename.append(".pdf");
		this.attachmentFilename = attachmentFilename.toString();
	}

	public InputStreamSource getInputStreamSource() {
		if (this.attachmentBytes != null) {
			final InputStreamSource attachmentSource = new ByteArrayResource(this.attachmentBytes);
			return attachmentSource;
		}
		return null;
	}
}
