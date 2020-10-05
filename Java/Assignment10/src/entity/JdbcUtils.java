package entity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {
	private Connection con;
	private Properties pr;
	
	public Connection connect() throws FileNotFoundException, IOException, SQLException {
		pr = new Properties();
		pr.load(new FileInputStream("src/backend/ConfigDataBase.properties"));
		String dbUrl = pr.getProperty("dbUrl");
		String user = pr.getProperty("username");
		String pass = pr.getProperty("password");

		con = DriverManager.getConnection(dbUrl, user, pass);
		
		return con;
	}
	
	public void disconnect() throws SQLException {
		con.close();
	}
}
