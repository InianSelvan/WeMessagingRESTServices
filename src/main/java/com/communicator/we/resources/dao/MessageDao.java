package com.communicator.we.resources.dao;

import java.util.List;

import com.communicator.we.resources.model.Message;

public interface MessageDao {
	
	public List<Message> getAllMessages() throws ClassNotFoundException;
	
	public void addMessage(Message message) throws ClassNotFoundException;
	
	public Message getMessage(int messageId) throws ClassNotFoundException;
	
	public void deleteMessage(int messageId) throws ClassNotFoundException;

	public Message updateMessage(Message message) throws ClassNotFoundException;	

}
