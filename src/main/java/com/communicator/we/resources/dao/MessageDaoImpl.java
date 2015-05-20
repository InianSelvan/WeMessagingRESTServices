package com.communicator.we.resources.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.communicator.we.resources.model.Message;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class MessageDaoImpl implements MessageDao{
	public Message message = new Message();
	
	
	public ArrayList<Message> getAllMessages() throws ClassNotFoundException {
		DataSource datasource = new DataSource();
		Connection conn = datasource.createConnection();
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Message> messages = new ArrayList<>();
		
		try
		{
			String Qry = "SELECT * FROM message";
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery(Qry);
			while(rs.next())
			{
				Message message = new Message(rs.getInt("Id"), rs.getString("message"), rs.getString("author"));
				message.setDate(rs.getDate("date").toString());
				messages.add(message);
			}
			 
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(conn != null)
				{
					conn.close();
				}
				if(stmt != null)
				{
					stmt.close();
				}
				if(rs != null)
				{
					rs.close();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return  messages;
	}
	
	
	@Override
	public void addMessage(Message message) throws ClassNotFoundException {
		DataSource datasource = new DataSource();
		Connection conn = datasource.createConnection();
		Statement stmt = null;
		ResultSet rs = null;
		try
		{

			String Qry = "INSERT INTO message(`Id`, `message`, `date`,`author`) VALUES"
					+ "("+message.getId()+",'"+message.getMessage()+"','"+message.getDate()+"','"+message.getAuthor()+"')";
			
			stmt = (Statement) conn.createStatement();
			stmt.executeUpdate(Qry);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(conn != null)
				{
					conn.close();
				}
				if(stmt != null)
				{
					stmt.close();
				}
				if(rs != null)
				{
					rs.close();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	@Override
	public Message getMessage(int messageId) throws ClassNotFoundException {
		DataSource datasource = new DataSource();
		Connection conn = datasource.createConnection();
		Statement stmt = null;
		ResultSet rs = null;
		Message messages = null;
		
		try
		{
			String Qry = "SELECT * FROM message WHERE Id="+messageId;
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery(Qry);
			
			while(rs.next())
			{
				messages = new Message(rs.getInt("Id"), rs.getString("message"), rs.getString("author"));
				messages.setDate(rs.getDate("date").toString());
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(conn != null)
				{
					conn.close();
				}
				if(stmt != null)
				{
					stmt.close();
				}
				if(rs != null)
				{
					rs.close();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return  messages;
		
	}

	public static void main(String args[]) throws ClassNotFoundException{
		MessageDaoImpl m = new MessageDaoImpl();
		m.deleteMessage(2);
	}
	
	@Override
	public Message updateMessage(Message message) throws ClassNotFoundException {
		DataSource datasource = new DataSource();
		Connection conn = datasource.createConnection();
		Statement stmt1 = null;
		Statement stmt2 = null;
		ResultSet rs = null;
		Message messageGet = null;
		try
		{
			String QryU = "UPDATE message SET Id="+message.getId()+", message='"+message.getMessage()+"', "
					+ "date='"+message.getDate()+"', author = '"+message.getAuthor()+"'";
			stmt1 = (Statement) conn.createStatement();
			stmt1.executeUpdate(QryU);
			stmt1.close();
			String QryGet = "SELECT * FROM message WHERE Id="+message.getId();
			stmt2 = (Statement) conn.createStatement();
			rs = stmt2.executeQuery(QryGet);
			
			while(rs.next())
			{
				messageGet = new Message(rs.getInt("Id"), rs.getString("message"), rs.getString("author"));
				messageGet.setDate(rs.getDate("date").toString());

			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(conn != null)
				{
					conn.close();
				}
				if(stmt1 != null)
				{
					stmt1.close();
				}
				if(stmt2 != null)
				{
					stmt2.close();
				}				
				if(rs != null)
				{
					rs.close();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		return  messageGet;
		
	}

	@Override
	public void deleteMessage(int messageId) throws ClassNotFoundException {
		DataSource datasource = new DataSource();
		Connection conn = datasource.createConnection();
		Statement stmt = null;
		ResultSet rs = null;
		Message messages = null;
		
		try
		{
			String Qry = "DELETE FROM message WHERE Id="+messageId;
			stmt = (Statement) conn.createStatement();
			stmt.executeUpdate(Qry);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(conn != null)
				{
					conn.close();
				}
				if(stmt != null)
				{
					stmt.close();
				}
				if(rs != null)
				{
					rs.close();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

		
	}

}
