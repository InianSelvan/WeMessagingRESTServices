package com.communicator.we.resources;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

//import com.communicator.we.resources.dao.*;
import com.communicator.we.resources.model.Message;
import com.communicator.we.resources.service.MessageService;

@Path("/messages")
public class MessagesResource {
	MessageService messageservice = new MessageService();
	
	//Learning basic CRUD operations
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<Message> getMessages(@QueryParam("date") String date) throws ClassNotFoundException
	{
		if(date!=null){
			return messageservice.getAllMessagesfordate(date);
		}
		return messageservice.getAllMessages(); 
	}
	
	//Learning basic CRUD operations
	//@pathParam values
	
	@GET
	@Path("/{messageid}")
	@Produces(MediaType.APPLICATION_XML)
	public Message getAMessage(@PathParam("messageid") int id) throws ClassNotFoundException{
		return messageservice.getMessage(id);		
	}
	
	//Learning basic CRUD operations
	
	@DELETE
	@Path("/{messageid}")
	@Produces(MediaType.APPLICATION_XML)
	public void deleteMessage(@PathParam("messageid") int id) throws ClassNotFoundException{
		 messageservice.deleteMessage(id);	
	}

	//Learning basic CRUD operations
	@PUT
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Message updateMessage(Message message) throws ClassNotFoundException
	{		
		return messageservice.updateMessage(message);		
	}

	//Learning basic CRUD opertations
	@POST
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public Message createMessage(Message message) throws ClassNotFoundException
	{
		return messageservice.createMessage(message);
	}
	
	//Delegation of resource
	@GET
	@Path("/{messageid}/comments")
	public CommentsResource getCommentResource()
	{
		return new CommentsResource();
	}
}
