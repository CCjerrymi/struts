package com.action;

import java.io.File;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.service.LoadService;

public class LoadAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private File file;
	private String fileName;
	private String fileContentType;
	
	@Resource(name="loadService")
	LoadService loadservice;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}


	public String uploadFile(){
		
		return "";
	}
	
	public InputStream getDownLoadFile(){
		//loadservice.
		return ServletActionContext.getServletContext().getResourceAsStream("");
	}

}
