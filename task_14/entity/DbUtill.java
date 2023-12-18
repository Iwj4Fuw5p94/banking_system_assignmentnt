package com.hexaware.task_14.entity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtill {
	static Connection connection;
	public static Connection getMyconnection(){
		
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hexadb", "root", "root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

}
