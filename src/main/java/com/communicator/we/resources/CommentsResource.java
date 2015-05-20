package com.communicator.we.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class CommentsResource {

	@GET
	public String commentRes()
	{
		return "Delegated Resource";
	}
	
}
