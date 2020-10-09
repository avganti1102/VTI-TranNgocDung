package com.vti.final_exam.backend.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.final_exam.backend.service.IUserService;
import com.vti.final_exam.backend.service.UserService;
import com.vti.final_exam.entity.Employee;
import com.vti.final_exam.entity.Manager;

public class UserController {
	private IUserService userService;
	
	public UserController() throws FileNotFoundException, IOException {
		userService = new UserService();
	}

	public List<Employee> showProjectByEmployee(int id) throws SQLException {
		return userService.showProjectByEmployee(id);
	}

	public List<Manager> showProjectByManager(int id) throws SQLException {
		return userService.showProjectByManager(id);
	}

	public List<Manager> showListManager() throws SQLException {
		return userService.showListManager();
	}

	public boolean isManagerExists(String email,String psw) throws SQLException {
		return userService.isManagerExists(email, psw);
	}

	public boolean isEmployeeExists(String email, String psw) throws SQLException {
		return userService.isEmployeeExists(email,psw);
		
	}
	
	
}
