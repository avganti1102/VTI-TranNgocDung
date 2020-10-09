package com.vti.final_exam.backend.repository;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.nimbus.State;

import com.vti.final_exam.entity.Employee;
import com.vti.final_exam.entity.Manager;
import com.vti.final_exam.utils.JdbcUtils;

public class UserReponsitory implements IUserReponsitory {
	private JdbcUtils jdbcUtils;

	public UserReponsitory() throws FileNotFoundException, IOException {
		jdbcUtils = new JdbcUtils();
	}

	@Override
	public List<Manager> showProjectByManager(int id) throws SQLException {
		List<Manager> mngs = new ArrayList<>();
		Connection con = jdbcUtils.connect();
		String sql = "SELECT managerID,fullName,email,projectID,expInYear FROM Manager where projectID = ?";
		// Select
		PreparedStatement prs = con.prepareStatement(sql);
		prs.setInt(1, id);
		// Add vao List<>
		ResultSet rs = prs.executeQuery();
		while (rs.next()) {
			Manager mng = new Manager();
			mng.setId(rs.getInt("managerID"));
			mng.setFullName(rs.getString("fullName"));
			mng.setEmail(rs.getString("email"));
			mng.setProjectID(rs.getInt("projectID"));
			mng.setExpInYear(rs.getInt("expInYear"));
			mngs.add(mng);
		}
		if(mngs.isEmpty())
			System.out.println("Khong co Manager nao thuoc projectID nay");
		return mngs;
	}

	@Override
	public List<Employee> showProjectByEmployee(int id) throws SQLException {
		List<Employee> emps = new ArrayList<>();
		Connection con = jdbcUtils.connect();
		//Select
		String sql = "SELECT employeeID,fullName,email,projectID,proSkill FROM Employee where projectID = ?";
		PreparedStatement prs = con.prepareStatement(sql);
		prs.setInt(1, id);
		ResultSet rs = prs.executeQuery();
		//Add vao List<>
		while(rs.next()) {
			Employee emp = new Employee();
			emp.setId(rs.getInt("employeeID"));
			emp.setFullName(rs.getString("fullName"));
			emp.setEmail(rs.getString("email"));
			emp.setProjectID(rs.getInt("projectID"));
			emp.setProSkill(rs.getString("proSkill"));
			emps.add(emp);
			}
		if(emps.isEmpty()) {
			System.out.println("Khong co Employee nao thuoc projectID nay");
			jdbcUtils.disconnect();
		}
		return emps;
	}

	@Override
	public List<Manager> showListManager() throws SQLException {
		List<Manager> mngs = new ArrayList<>();
		Connection con = jdbcUtils.connect();
		//Create statement
		Statement stm = con.createStatement();
		String sql = "Select * from manager where projectID is not null";
		ResultSet rs = stm.executeQuery(sql);
		while(rs.next()) {
			Manager mng = new Manager();
			mng.setId(rs.getInt("managerID"));
			mng.setFullName(rs.getString("fullName"));
			mng.setEmail(rs.getString("email"));
			mng.setProjectID(rs.getInt("projectID"));
			mng.setExpInYear(rs.getInt("ExpInYear"));
			mngs.add(mng);
		}
		return mngs;
	}

	@Override
	public boolean isManagerExists(String email,String psw) throws SQLException {
		Connection con = jdbcUtils.connect();
		String sql = "select * from Manager where email = ? and passwd = ?";
		PreparedStatement prs = con.prepareStatement(sql);
		prs.setString(1,email);
		prs.setString(2,psw);
		
		boolean check = false;
		ResultSet set = prs.executeQuery();
		
		if(set.next())
			check = true;

		jdbcUtils.disconnect();
		return check;
	}

	@Override
	public boolean isEmployeeExists(String email, String psw) throws SQLException {
		Connection con = jdbcUtils.connect();
		String sql = "select * from Employee where email = ? and passwd = ?";
		PreparedStatement prs = con.prepareStatement(sql);
		prs.setString(1,email);
		prs.setString(2,psw);
		
		boolean check = false;
		ResultSet set = prs.executeQuery();
		
		if(set.next())
			check = true;

		jdbcUtils.disconnect();
		return check;
	}
}
