package com.vti.final_exam.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {
	private Connection con;
	private DatabaseProperties databaseProperties;
	
	public JdbcUtils() throws FileNotFoundException, IOException {
		databaseProperties = new DatabaseProperties();
	}
	
	public Connection connect() throws SQLException {
		String url = databaseProperties.getProperty("dbUrl");
		String username = databaseProperties.getProperty("username");
		String pass = databaseProperties.getProperty("password");
		
		con = DriverManager.getConnection(url, username, pass);
		return con;
	}
	
	public void disconnect() throws SQLException {
		con.close();
	}
}
