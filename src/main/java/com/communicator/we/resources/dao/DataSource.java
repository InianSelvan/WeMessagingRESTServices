package com.communicator.we.resources.dao;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DataSource {

	   private String jdbc_driver;
	   private String db_url;
	   private String db_name;
	   private String user;
	   private String pswd;
	   public Connection connection = null;
	   
	public DataSource() throws ClassNotFoundException{
        jdbc_driver = "com.mysql.jdbc.Driver";
        db_url = "jdbc:mysql://76.163.252.219/";
        db_name = "AAAln59_MessagingService";
        user = "AAAln59_UbcStu";
        pswd = "InianS03";
        Class.forName("com.mysql.jdbc.Driver");
	}
	
	public Connection createConnection(){
		Connection con = null;
		try
		{
			if(connection != null)
			{
				System.out.println("Can't create a new connection");
			}
			else
			{
				con = (Connection) DriverManager.getConnection(db_url+db_name,user,pswd);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
		
		
		return con;
		
	}
}
