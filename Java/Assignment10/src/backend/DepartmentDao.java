package backend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.JdbcUtils;

public class DepartmentDao {
	private JdbcUtils jdbcUtils;
	
	public DepartmentDao() {
		jdbcUtils = new JdbcUtils();
	}
	
	public List<Department> getDepartments() throws FileNotFoundException, IOException, SQLException{
		List<Department> departments = new ArrayList<>();
		//Connect DB
		Connection con = jdbcUtils.connect();
		//Create Statement
		Statement stm = con.createStatement();
		//Select
		String sql = "SELECT * FROM Department";
		ResultSet resultSet = stm.executeQuery(sql);
		//Add vao List<>
		while (resultSet.next()) {
			Department department = new Department();
			department.setId(resultSet.getInt("DepartmentId"));
			department.setName(resultSet.getString("DepartmentName"));

			departments.add(department);
		}
		//disconnect
		jdbcUtils.disconnect();
		return departments;
	}
	
	public void getDepartmentByID() throws Exception {
		//Connect DB
		Connection con = jdbcUtils.connect();
		// Create a statement object
		Statement stm = con.createStatement();
		//Execute Query
		String sql = "SELECT * FROM Department WHERE DepartmentId = 5";
		ResultSet rs = stm.executeQuery(sql);
		
		// Step 5: handling result set
		if (rs.next()) {
			Department department = new Department();
			department.setId(rs.getInt("DepartmentId"));
			department.setName(rs.getString("DepartmentName"));
			department.toString();
			jdbcUtils.disconnect();

		} else {
			jdbcUtils.disconnect();
			System.out.println("//");
		}
	}
	
	public void getDepartmentByID(int id) throws FileNotFoundException, IOException, SQLException {
		//Connect DB
		Connection con = jdbcUtils.connect();
		// Create a statement object
		String sql = "select * from department where departmentID = ?";
		PreparedStatement preStm = con.prepareStatement(sql);
		preStm.setInt(1, id);
		ResultSet rs = preStm.executeQuery();
		//Handling result set
		if (rs.next()) {
			Department department = new Department();
			department.setId(rs.getInt("DepartmentId"));
			department.setName(rs.getString("DepartmentName"));
			department.toString();
			jdbcUtils.disconnect();

		} else {
			jdbcUtils.disconnect();
			System.out.println("//");
		}
	}
	
	public boolean isDepartmentNameExists(String name) throws FileNotFoundException, IOException, SQLException {
		//Connect DB
		Connection con = jdbcUtils.connect();
		// Create a statement object
		String sql = "select * from department where departmentName = ?";
		PreparedStatement preStm = con.prepareStatement(sql);
		preStm.setString(1, name);
		ResultSet rs = preStm.executeQuery();
		//Handling result set
		if (rs.next()) {
			jdbcUtils.disconnect();
			return true;

		} else {
			jdbcUtils.disconnect();
			return false;
		}
	}
	
	public boolean isDepartmentIDExists(int id) throws FileNotFoundException, IOException, SQLException {
		//Connect DB
		Connection con = jdbcUtils.connect();
		// Create a statement object
		String sql = "select * from department where departmentID = ?";
		PreparedStatement preStm = con.prepareStatement(sql);
		preStm.setInt(1, id);
		ResultSet rs = preStm.executeQuery();
		//Handling result set
		if (rs.next()) {
			jdbcUtils.disconnect();
			return true;

		} else {
			jdbcUtils.disconnect();
			return false;
		}
	}
	
	public void createDepartment(String name) throws FileNotFoundException, IOException, SQLException {
		if(isDepartmentNameExists(name)) {
			System.out.println("Department is Exists");
		}
		else {
			//Connect DB
			Connection con = jdbcUtils.connect();
			// Create a statement object
			String sql = "insert into department (departmentName) values (?)";
			PreparedStatement preStm = con.prepareStatement(sql);
			preStm.setString(1, name);
			int effecedRows = preStm.executeUpdate();
			 if(effecedRows == 1) {
				 System.out.println("Them thanh cong");
			 }
			 else {
				 System.out.println("Them khong thanh cong");
			 }
		}
	}
	
	public void updateDepartmentName(int id,String name) throws FileNotFoundException, IOException, SQLException {
		if(isDepartmentIDExists(id)) {
			//Connect DB
			Connection con = jdbcUtils.connect();
			// Create a statement object
			String sql = "update department"
					+ "		set departmentName = ?"
					+ "		where departmentID = ?";
			PreparedStatement preStm = con.prepareStatement(sql);
			preStm.setInt(1, id);
			preStm.setString(2, name);
			int effecedRows = preStm.executeUpdate();
			 if(effecedRows == 1) {
				 System.out.println("Sua ten thanh cong");
			 }
			 else {
				 System.out.println("Sua ten khong thanh cong");
			 }
		}
		else {
			System.out.println("Department is not Exists");
		}
	}
	
	public void deleteDepartment(int id) throws FileNotFoundException, IOException, SQLException {
			//Connect DB
			Connection con = jdbcUtils.connect();
			// Create a statement object
			String sql = "delete from department where departmentID = ?";
			PreparedStatement preStm = con.prepareStatement(sql);
			preStm.setInt(1, id);
			int effecedRows = preStm.executeUpdate();
			 if(effecedRows > 0) {
				 System.out.println("Da xoa ID: " + id);
			 }
			 else {
				 System.out.println("DepartmentID is not Exists");
			 }
		}
	
	
	
	// Call Procedure
	public void deleteDepartmentUsingProcedure(int id) throws SQLException, FileNotFoundException, IOException {
		//Connect DB
		Connection con = jdbcUtils.connect();
		// Create a statement object
		String sql = "call sp_delete_department(?)";
		PreparedStatement preStm = con.prepareStatement(sql);
		preStm.setInt(1, id);
		int effecedRows = preStm.executeUpdate();
		 if(effecedRows > 0) {
			 System.out.println("Da xoa ID: " + id);
		 }
		 else {
			 System.out.println("Department is not Exists");
		 }
	}	
	
	
	
}
