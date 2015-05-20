package com.communicator.we.resources.database;

import java.util.HashMap;
import java.util.Map;

import com.communicator.we.resources.model.Message;

public class Database {
	
	private static Map<Integer, Message> messages = new HashMap<>();
	
	public static Map<Integer, Message> getMessages(){
		return messages;
	}
}
