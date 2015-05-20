package com.communicator.we.resources.dao;

import java.util.Date;

public class Msg {
	
    private int Id;
    private String message;
    private Date date;
    private String author;
    
    public Msg()
    {
    	
    }
    
    public Msg(int Id, String message,  String author) {

		this.Id = Id;
		this.message = message;
		this.author = author;
		this.date = new Date();
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
