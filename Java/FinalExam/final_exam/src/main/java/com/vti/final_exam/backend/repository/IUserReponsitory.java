package com.vti.final_exam.backend.repository;

import java.sql.SQLException;
import java.util.List;

import com.vti.final_exam.entity.Employee;
import com.vti.final_exam.entity.Manager;


public interface IUserReponsitory {
	List<Manager> showProjectByManager(int id) throws SQLException;
	List<Employee> showProjectByEmployee(int id) throws SQLException;
	List<Manager> showListManager() throws SQLException;
	boolean isManagerExists(String email, String psw) throws SQLException;
	boolean isEmployeeExists(String email, String psw) throws SQLException;
}
