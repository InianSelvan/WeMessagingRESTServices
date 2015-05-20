package com.communicator.we.resources.service;

import java.util.ArrayList;

import com.communicator.we.resources.dao.MessageDaoImpl;
import com.communicator.we.resources.model.*;


public class MessageService {
	 
	/*
	 * To get all the messages
	 */
	public  ArrayList<Message> getAllMessages() throws ClassNotFoundException{
		MessageDaoImpl dao = new MessageDaoImpl();		
		return  dao.getAllMessages();
	}
	
	public ArrayList<Message> getAllMessagesfordate(String date) throws ClassNotFoundException {
		MessageDaoImpl dao = new MessageDaoImpl();
		ArrayList<Message> messages= new ArrayList<Message>();
		for(Message message : dao.getAllMessages()){
			if(message.getDate().equals(date)){
				messages.add(message);
			}
		}
		
		return messages;
	}
	
	public Message getMessage(int id) throws ClassNotFoundException{
		MessageDaoImpl dao = new MessageDaoImpl();
		return dao.getMessage(id);
	}

	public Message createMessage(Message cmsg) throws ClassNotFoundException
	{
		MessageDaoImpl dao = new MessageDaoImpl();
		cmsg.setId(dao.getAllMessages().size()+1);
		new Message(cmsg.getId(), cmsg.getMessage(), cmsg.getAuthor());
		
		if(cmsg.getId() <= 0){
			return null;
		}

		dao.addMessage(cmsg);
		
		return cmsg;
	}

	public Message updateMessage(Message message) throws ClassNotFoundException {
		MessageDaoImpl dao = new MessageDaoImpl();
		return dao.updateMessage(message);
	}
	
	public void deleteMessage(int id) throws ClassNotFoundException{
		MessageDaoImpl dao = new MessageDaoImpl();
		dao.deleteMessage(id);
		
	}


	
}
