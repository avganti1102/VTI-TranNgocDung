package com.vti.final_exam.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.vti.final_exam.backend.controller.UserController;
import com.vti.final_exam.entity.Employee;
import com.vti.final_exam.entity.Manager;
import com.vti.final_exam.utils.ScannerUtils;

public class test {
	
	private static UserController userController;
	
	public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
		userController = new UserController();
		int choose;
		do {
			System.out.println("*******************************************");
			System.out.println("**                                       **");
			System.out.println("**        1. ShowProjectByID             **");
			System.out.println("**        2. ShowManager                 **");
			System.out.println("**        3. Login                       **");
			System.out.println("**        0. Thoat chuong trinh          **");
			System.out.println("**                                       **");
			System.out.println("*******************************************");
			System.out.println("**     Nhập lựa chọn của bạn             **");
			choose = ScannerUtils.inputInt("Vui lòng nhập vào một số. Nhập lại!");
			switch(choose) {
			case 1:
				System.out.println("Nhap ProjectID: ");
				int id = ScannerUtils.inputInt("Nhap lai");
				showProjectByID(id);
				break;
			case 2:
				System.out.println("List Manager:");
				showListManager();
				break;
			case 3:
				login();
				break;
			case 0:
				System.out.println("Da thoat chuong trinh");
				break;
			default:
				System.err.println("Không có lựa chọn này. Nhập lại !");
				break;
			}
		} while(choose != 0);
	}

	private static void login() throws SQLException, FileNotFoundException, IOException {
		UserController uC = new UserController();
		System.out.println("Nhap loai Account muon dang nhap(1-Manager ; 2-Employee; 3-Quay ve trang chu): ");
		int choose;
		choose = ScannerUtils.inputInt("Nhap lai!|");
		switch(choose) {
		case 1:
			System.out.println("Dang nhap Account Manager");
			System.out.println("Nhap Email:");
			String emailm = ScannerUtils.inputString("Nhap lai!");
			System.out.println("Nhap pass word:");
			String passm = ScannerUtils.inputString("Nhap lai!");
			if(userController.isManagerExists(emailm, passm))
				System.out.println("Dang nhap thanh cong");
			else
				System.out.println("Email or password sai. Kiem tra lai!");
			break;
		case 2:
			System.out.println("Dang nhap Account Employee");
			System.out.println("Nhap Email:");
			String emaile = ScannerUtils.inputString("Nhap lai!");
			System.out.println("Nhap pass word:");
			String passe = ScannerUtils.inputString("Nhap lai!");
			if(userController.isEmployeeExists(emaile, passe))
				System.out.println("Dang nhap thanh cong");
			else
				System.out.println("Email or password sai. Kiem tra lai!");
			break;
		case 3:
			System.out.println("Quay lai trang chu");
			break;
		default:
			System.out.println("Nhap lai!");
			login();
			break;
		}
	}

	private static void showListManager() throws SQLException, FileNotFoundException, IOException {
		UserController uC = new UserController();
		List<Manager> mngs = uC.showListManager();
		for (Manager mng : mngs) {
			System.out.println(mng.toString());
		}
	}

	private static void showProjectByID(int id) throws FileNotFoundException, IOException, SQLException {
		UserController uC = new UserController();
		List<Employee> employees = uC.showProjectByEmployee(id);
		for (Employee employee : employees) {
			System.out.println(employee.toString());
		}
		List<Manager> managers = uC.showProjectByManager(id);
		for (Manager manager : managers) {
			System.out.println(manager.toString());
		}
	}
	
	
}
