package backend;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Basic {
	static Connection con;
	
	public static void connectDB() throws FileNotFoundException, IOException, SQLException, ClassNotFoundException {
		Properties pr = new Properties();
		pr.load(new FileInputStream("src/backend/ConfigDataBase.properties"));
		String dbUrl = pr.getProperty("dbUrl");
		String user = pr.getProperty("username");
		String pass = pr.getProperty("password");

		con = DriverManager.getConnection(dbUrl, user, pass);
		if(con != null ) {
			System.out.println("Connect Success!");
		}
		else {
			System.out.println("Cannot connect db");
		}
	}
	
	public static void positionInfo() throws SQLException {
		String sqlStatement = "Select * from position"; //Cau lenh ro rang
		Statement stm = con.createStatement(); // Thuc thi nhung cau lenh dc viet ro rang
		ResultSet rs = stm.executeQuery(sqlStatement); //thuc hien Query len Console
		 while(rs.next()) {
			 String id = rs.getString("positionID"); 
			 String name = rs.getString("positionName");
			 System.out.println(id + " | " + name);
		 }
	}
	
	public static void addPosition(int id,String name) throws SQLException {
		 String isStatement = "insert into position (positionID,positionName) values (?,?)";
		 PreparedStatement preStatement = con.prepareStatement(isStatement);
		 preStatement.setInt(1, id);
		 preStatement.setString(2, name);
		 int effecedRows = preStatement.executeUpdate();
		 if(effecedRows == 1) {
			 System.out.println("Them thanh cong");
		 }
		 else {
			 System.out.println("Them khong thanh cong");
		 }
	}
	
	public static void updatePosition() throws SQLException {
		String sqlStatement = "update position"
		 		+ "				set positionName = 'Vi tri 5"
		 		+ "				where positionID = 5";
		Statement stm = con.createStatement();
		int effecedRows = stm.executeUpdate(sqlStatement);
		if(effecedRows > 0) {
			System.out.println("Update thanh cong!");
		}
		else
		{
			System.out.println("Update khong thanh cong");
		}
	}
	
	public static void delPosition(int id) throws SQLException {
		 String isStatement = "delete from position where positioniID = ?";
		 PreparedStatement preStatement = con.prepareStatement(isStatement);
		 preStatement.setInt(1, id);
		 int effecedRows = preStatement.executeUpdate(isStatement);
			if(effecedRows > 0) {
				System.out.println("Del thanh cong!");
			}
			else
			{
				System.out.println("Del khong thanh cong");
			}
	}
	
}
