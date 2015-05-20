package com.communicator.we.resources.model;



import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	
    private int Id;
    private String message;
    private String date;
    private String author;
	
    public Message()
    {
    	
    }
    
    public Message(int Id, String message,  String author) {

		this.Id = Id;
		this.message = message;
		this.author = author;
		this.date = new Date().toString();
	}
    
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
    

}
