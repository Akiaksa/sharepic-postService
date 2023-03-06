package com.sharepic.PostService.Dto;

import java.util.Date;

public class FileDto {
	
	private String fileName;
	private String fileUrl;
	private Date postedDate;
	private String contentType;
	private Integer likes;
	
	public FileDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getContentType() {
		return contentType;
	}


	public void setContentType(String contentType) {
		this.contentType = contentType;
	}


	public FileDto(String fileName, String fileUrl,  String contentType) {
		super();
		this.fileName = fileName;
		this.fileUrl = fileUrl;
		
		this.contentType = contentType;
	}

	
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	
	
	
}
