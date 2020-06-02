package com.forms.wl.entity;

public class CommonEntity {
	
	private String sendType = null;
	private String filePath = null;
	private String fileName = null;
	
	//码表字段
	private String id = null;
	private String codeValue = null;
	private String codeDetail = null;
	private String codeType = null;
	private String smallType = null;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	private String codeContent = null;
	
	
	
	public String getSendType() {
		return sendType;
	}
	public void setSendType(String sendType) {
		this.sendType = sendType;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getCodeValue() {
		return codeValue;
	}
	public void setCodeValue(String codeValue) {
		this.codeValue = codeValue;
	}
	public String getCodeDetail() {
		return codeDetail;
	}
	public void setCodeDetail(String codeDetail) {
		this.codeDetail = codeDetail;
	}
	public String getCodeType() {
		return codeType;
	}
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}
	public String getSmallType() {
		return smallType;
	}
	public void setSmallType(String smallType) {
		this.smallType = smallType;
	}
	
	public String getCodeContent() {
		return codeContent;
	}
	public void setCodeContent(String codeContent) {
		this.codeContent = codeContent;
	}
	
}
