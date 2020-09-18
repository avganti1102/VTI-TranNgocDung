package Assignment2;
import java.time.LocalDate;

public class Ex1 {
	public static void main(String[] args) {
// Department
		Department department1 = new Department();
		department1.ID = 1;
		department1.Name = "Sale";

		Department department2 = new Department();
		department2.ID = 2;
		department2.Name = "Marketting";

		Department department3 = new Department();
		department3.ID = 3;
		department3.Name = "Security";
		// Position
		Position position1 = new Position();
		position1.ID = 1;
		position1.Name = positionName.DEV;

		Position position2 = new Position();
		position2.ID = 2;
		position2.Name = positionName.TEST;

		Position position3 = new Position();
		position3.ID = 3;
		position3.Name = positionName.SCRUM_MASTER;
// Account
		Account acc1 = new Account();
		acc1.ID = 1;
		acc1.email = "account1@gmail.com";
		acc1.userName = "sokhanh";
		acc1.fullName = "Tong Quang Anh";
		acc1.department = department1;
		acc1.position = position1;
		acc1.createDate = LocalDate.of(2019, 6, 12);

		Account acc2 = new Account();
		acc2.ID = 2;
		acc2.email = "account2@gmail.com";
		acc2.userName = "dongian";
		acc2.fullName = "Phan Minh Quy";
		acc2.department = department2;
		acc2.position = position2;
		acc2.createDate = LocalDate.of(2019, 5, 16);

		Account acc3 = new Account();
		acc3.ID = 3;
		acc3.email = "account3@gmail.com";
		acc3.userName = "sokhanh";
		acc3.fullName = "Tong Quang Anh";
		acc3.department = department1;
		acc3.position = position3;
		acc2.createDate = LocalDate.now();

// Group
		Group gr1 = new Group();
		gr1.ID = 1;
		gr1.creator = acc2;
		gr1.Name = "Group 1";
		gr1.createDate = LocalDate.of(2019, 1, 15);

		Group gr2 = new Group();
		gr2.ID = 2;
		gr2.creator = acc2;
		gr2.Name = "Group 2";
		gr2.createDate = LocalDate.of(2019, 2, 1);

		Group gr3 = new Group();
		gr3.ID = 3;
		gr3.creator = acc1;
		gr3.Name = "Group 3";
		gr3.createDate = LocalDate.of(2019, 1, 10);

		Group[] groupOfAccount1 = { gr1, gr2, gr3 };
		acc1.groups = groupOfAccount1;

		Group[] groupOfAccount2 = { gr1 };
		acc2.groups = groupOfAccount2;

		Group[] groupOfAccount3 = { gr1, gr2 };
		acc3.groups = groupOfAccount3;

		Account[] accOfGroup1 = { acc1, acc2, acc3 };
		gr1.accounts = accOfGroup1;

		Account[] accOfGroup2 = { acc1, acc3 };
		gr2.accounts = accOfGroup2;

		Account[] accOfGroup3 = { acc1 };
		gr3.accounts = accOfGroup3;
		Account[] accounts = { acc1, acc2, acc3}; 
		Department[] departments = { department1, department2, department3 };
/*
//IF
//Q1
		if (acc2.department.Name == null) {
			System.out.println("Nhân viên này chưa có phòng ban");
		} else
			System.out.println("Phòng ban của nhân viên này là: " + acc2.department.Name);

//Q2
		if (acc2.groups.length == 0 || acc2.groups == null)
			System.out.println("Nhân viên này chưa có group");
		else if (acc2.groups.length == 1)
			System.out.printf("Group của nhân viên này là %s", acc2.groups[0].Name);
		else if (acc2.groups.length == 2)
			System.out.printf("Group của nhân viên này là %s, %s", acc2.groups[0].Name, acc2.groups[1].Name);
		else if (acc2.groups.length == 3)
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
		else
			System.out.println("Nhân viên này là người hóng chuỵện");

//Q3
		String check = (acc2.department.Name == null ? "Nhân viên này chưa có phòng ban"
				: "Phòng ban của nhân viên này là: " + acc2.department.Name);
		System.out.println(check);

//Q4
		String check1 = (acc1.position.Name == positionName.DEV ? "Đây là Developer" : "Người này không phải Developer");
		System.out.println(check1);

//SWITCH CASE
//Q5
		switch (gr1.accounts.length) {
		case 0:
			System.out.println("Group này chưa có thành viên");
			break;
		case 1:
			System.out.println("Nhóm có 1 thành viên");
			break;
		case 2:
			System.out.println("Nhóm có 2 thành viên");
			break;
		case 3:
			System.out.println("Nhóm có 3 thành viên");
			break;
		default:
			System.out.println("Nhóm có nhiều thành viên");
			break;
		}
	
//Q6
		switch (acc2.groups.length) {
		case 0:
			System.out.println("Nhân viên này chưa có group");
			break;
		case 1:
			System.out.printf("Group của nhân viên này là %s", acc2.groups[0].Name);
			break;
		case 2:
			System.out.printf("Group của nhân viên này là %s, %s", acc2.groups[0].Name, acc2.groups[1].Name);
			break;
		case 3:
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
			break;
		default:
			System.out.println("Nhân viên này là người hóng chuyện");
			break;
		}

//Q7
		switch (acc1.position.ID) {
		case 1:
			System.out.println("Đây là Developer");
			break;
		default:
			System.out.println("Người này không phải là developer");
			break;
		}

//FOREACH
// Q8.
	for (Account account : accounts) {
		System.out.println("Email: " + account.email);
		System.out.println("FullName: " + account.fullName);
		System.out.println("Department Name: " + account.department.Name);
	}

// Q9.
	
	for (Department department : departments) {
		System.out.println("ID Department: " + department.ID);
		System.out.println("Department Name: " + department.Name);
	}		
	
//FOR
//10
		for(int i=0; i < accounts.length; i++){
			System.out.println("Thông tin account thứ " + (i+1) + " là:");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Full name: "+accounts[i].fullName);
			System.out.println("Phòng ban: "+accounts[i].department.Name);
		}
		
//Q11
		for(int i=0; i<departments.length; i++){
			System.out.println("Thông tin department thứ " + (i+1) +" là:");
			System.out.println("Id: "+departments[i].ID);
			System.out.println("Name: "+departments[i].Name);
		}
		
//Q12
		for(int i=0; i < 2; i++){
			System.out.println("Thông tin department thứ " + (i+1) +" là:");
			System.out.println("Id: "+departments[i].ID);
			System.out.println("Name: "+departments[i].Name);
		}
		
//Q13
		for(int i=0; i < accounts.length; i++){
			if(i==1){
				continue;
			}
			System.out.println("Thông tin account thứ " + (i+1) + " là:");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Full name: "+accounts[i].fullName);
			System.out.println("Phòng ban: "+accounts[i].department.Name);
		}
		
//Q14
		for(int i = accounts[0].ID ; i < 4;i++  ){
			System.out.println("Thông tin account thứ " + (i) + " là:");
			System.out.println("Email: " + accounts[i-1].email);
			System.out.println("Full name: "+accounts[i-1].fullName);
			System.out.println("Phòng ban: "+accounts[i-1].department.Name);
		}
		
//Q15
		for(int i=0; i<20 ;){
			System.out.println(i+2);
			i+=2;
		}
		
//Q16-10.
		int i = 0;
		while (i < accounts.length) {
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Fullname: " + accounts[i].fullName);
			System.out.println("Department: " + accounts[i].department.Name);
			i++;
		}

//Q16-11.
		i = 0;
		while (i < accounts.length) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("ID: " + departments[i].ID);
			System.out.println("Name: " + departments[i].Name);
			i++;
		}

//Q16-12.
		i = 0;
		while (i < 2) {
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("ID: " + departments[i].ID);
			System.out.println("Name: " + departments[i].Name);
			i++;
		}

//Q16-13.
		i = 0;
		while (i < departments.length) {
			if (i == 1) {
				i++;
				continue;
			}
			System.out.println("Thông tin department thứ " + (i + 1) + " là:");
			System.out.println("ID: " + departments[i].ID);
			System.out.println("Name: " + departments[i].Name);
			i++;
		}

//Q16-14.
		i = 0;
		while (i < accounts.length) {
			if (accounts[i].ID >= 4) {
				i++;
				continue;
			}
			System.out.println("Thông tin account thứ " + (i + 1) + " là:");
			System.out.println("Email: " + accounts[i].email);
			System.out.println("Fullname: " + accounts[i].fullName);
			System.out.println("Department: " + accounts[i].department.Name);
			i++;
		}

//Q16-15.
		i = 2;
		while (i <= 20) {
			System.out.println(i);
			i = i + 2;
		}
*/
	}
}