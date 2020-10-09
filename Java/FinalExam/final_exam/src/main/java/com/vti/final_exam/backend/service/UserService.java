package com.vti.final_exam.backend.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.final_exam.backend.repository.IUserReponsitory;
import com.vti.final_exam.backend.repository.UserReponsitory;
import com.vti.final_exam.entity.Employee;
import com.vti.final_exam.entity.Manager;
import com.vti.final_exam.utils.ScannerUtils;

public class UserService implements IUserService{
	private IUserReponsitory userReponsitory;
	
	public UserService() throws FileNotFoundException, IOException {
		userReponsitory = new UserReponsitory();
	}

	@Override
	public List<Employee> showProjectByEmployee(int id) throws SQLException {
		return userReponsitory.showProjectByEmployee(id);
	}


	@Override
	public List<Manager> showProjectByManager(int id) throws SQLException {
		return userReponsitory.showProjectByManager(id);
	}

	@Override
	public List<Manager> showListManager() throws SQLException {
		return userReponsitory.showListManager();
	}

	@Override
	public boolean isManagerExists(String email,String psw) throws SQLException {
		return userReponsitory.isManagerExists(email, psw);
	}

	@Override
	public boolean isEmployeeExists(String email, String psw) throws SQLException {
		String email1 = email;
		String pass1 = psw;
		boolean check = false;
		
		while(!check) {
			if (dinhDangEmail(email1)) {
				check = true;
			}
			else {
				System.out.println("Email nhap chua dung dinh dang. Nhap lai!");
				email1 = ScannerUtils.inputString("Vui long nhap!");
			}
		}
		check = false;
		while(!check) {
			if (dinhDangPsw(pass1)) {
				check = true;
			}
			else {
				System.out.println("Pass nhập từ 6 tới 12 ký tự, có ít nhất 1 ký tự viết hoa. Nhap lai!");
				pass1 = ScannerUtils.inputString("Vui long nhap!");
			}
		}
		return userReponsitory.isEmployeeExists(email,psw);
	}

	private boolean dinhDangEmail(String email) {
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		String email1 = email;
		Boolean check = email1.matches(EMAIL_REGEX);
		return check;
	}
	
	private boolean dinhDangPsw(String pass) {
		boolean check1 = false;
		boolean check2 = false;
		for (int i =0; i<pass.length(); i++) {
			if(Character.isUpperCase(pass.charAt(i)))
				check1 = true;
		}
		if(pass.length()>5 && pass.length()<13 && check1 ==true) {
			check2 = true;
		}
		return check2;
	}
}
