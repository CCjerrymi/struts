package com.action;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.apache.struts2.ServletActionContext;

import com.entity.Student;
import com.opensymphony.xwork2.ActionSupport;
import com.tool.BASE64Encoder;

public class DownLoadAction extends ActionSupport{
	   private String filename;
	   private String contentType;
	   private String filepath = "E:/download/struts2.txt";
	    	
	    public DownLoadAction(){
	    	ArrayList<Student> list = SearchAction.result;
	    
	    	String content = "";
	    	for(Student student:list){
	    		content += "班级:" + student.getStuClassNumber() + ";姓名:" + student.getStuName() + ";学号:" + student.getStuNumber() + ";年龄:" + student.getAge() + "\n";
	    	}
	    	
	    	try{
	    		File file = new File(filepath);
		    	FileWriter fw = new FileWriter(file.getAbsoluteFile());
		    	BufferedWriter bw = new BufferedWriter(fw);
		    	bw.write(content);
		    	bw.close();
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	
	    	
	    	
	    }
	    
	    public String getFilename() throws IOException{
	        return encodeDownloadFilename(filename, ServletActionContext.getRequest().getHeader("User-Agent"));
	    }

	    public void setFilename(String filename) throws UnsupportedEncodingException{
	        filename=new String(filename.getBytes("iso8859-1"),"utf-8");
	        this.filename=filename;
	    }

	    public String getContentType(){
	        return ServletActionContext.getServletContext().getMimeType(filename);
	    }

	    public void setContentType(String contentType){
	        this.contentType = contentType;
	    }
	    
	   public InputStream getDownloadFile2() throws IOException{
	    	System.out.println(filename);
	        System.out.println(filepath);
	        
	        File file = new File(filepath);
	        System.out.println( );
	        FileInputStream input=new FileInputStream(filepath);     
	        
	        
	        System.out.println(input == null);
	        
	        return input;
	        
	       /* return ServletActionContext.getServletContext()
	                .getResourceAsStream(filepath);*/
	    }

	    public String execute() throws Exception{
	        return SUCCESS;
	    }

	    public String encodeDownloadFilename(String name,String agent) throws IOException{
	        if(agent.contains("Firefox")){
	            name="=?UTF-8?B?"+new BASE64Encoder().encode(name.getBytes("utf-8"))+"?=";
	        }else {
	            name= URLEncoder.encode(name,"utf-8");
	        }
	        return name;
	    }
}
