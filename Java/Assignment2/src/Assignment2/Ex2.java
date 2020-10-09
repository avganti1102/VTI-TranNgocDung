package Assignment2;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;


public class Ex2 {
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
		Account[] accounts = { acc1, acc2, acc3 };
		//Department[] departments = { department1, department2, department3 };
		
// Q1
		int a = 5;
		System.out.printf("%d\n", a);

// Q2
		int b = 100000000;
		System.out.printf( "%,d\n", b);

// Q3
		float c = 1.56468f;
		System.out.printf("%5.4f\n", c);
		
//Q4
		Scanner sc = new Scanner(System.in);
		System.out.println("Họ và tên: ");
		String str = sc.nextLine();
		System.out.printf("Tên tôi là %s và tôi đang độc thân \n", str);
		
//Q5
		String pattern = "dd/MM/yyyy hh:mm:ss";
		SimpleDateFormat sd = new SimpleDateFormat(pattern);
		String date = sd.format(new Date());
		System.out.println(date);
		
//Q6
		for (Account account : accounts) {
			System.out.println("Email: " + account.email);
			System.out.println("FullName: " + account.fullName);
			System.out.println("Department Name: " + account.department.Name);
		}
	}

}
