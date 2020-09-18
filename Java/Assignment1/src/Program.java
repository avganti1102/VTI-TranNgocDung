import java.time.LocalDate;

public class Program {
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

		// TypeQuestion
		typeQuestion tq1 = new typeQuestion();
		tq1.ID = 1;
		tq1.Name = TypeName.ESSAY;

		typeQuestion tq2 = new typeQuestion();
		tq2.ID = 2;
		tq2.Name = TypeName.MULTIPLE_CHOICES;
		// CategoryQuestion
		categoryQuestion cq1 = new categoryQuestion();
		cq1.ID = 1;
		cq1.Name = "JAVA";

		categoryQuestion cq2 = new categoryQuestion();
		cq2.ID = 2;
		cq2.Name = "ASP.NET";

		categoryQuestion cq3 = new categoryQuestion();
		cq3.ID = 3;
		cq3.Name = "ADO.NET";
		// Question
		Question quest1 = new Question();
		quest1.ID = 1;
		quest1.content = "Câu hỏi về JAVA";
		quest1.category = cq1;
		quest1.type = tq1;
		quest1.creator = acc1;
		quest1.createDate = LocalDate.of(2018, 12, 24);

		Question quest2 = new Question();
		quest2.ID = 2;
		quest2.content = "Câu hỏi về PHP";
		quest2.category = cq1;
		quest2.type = tq1;
		quest2.creator = acc1;
		quest2.createDate = LocalDate.of(2018, 12, 12);

		Question quest3 = new Question();
		quest3.ID = 3;
		quest3.content = "Câu hỏi về JAVA";
		quest3.category = cq3;
		quest3.type = tq2;
		quest3.creator = acc3;
		quest3.createDate = LocalDate.of(2019, 1, 11);

		// Answer
		Answer asw1 = new Answer();
		asw1.ID = 1;
		asw1.content = "Trả lời 01";
		asw1.question = quest1;
		asw1.isCorrect = false;

		Answer asw2 = new Answer();
		asw2.ID = 2;
		asw2.content = "Trả lời 02";
		asw2.question = quest1;
		asw2.isCorrect = false;

		Answer asw3 = new Answer();
		asw3.ID = 1;
		asw3.content = "Trả lời 03";
		asw3.question = quest3;
		asw3.isCorrect = true;

		// Exam
		Exam ex1 = new Exam();
		ex1.ID = 1;
		ex1.code = "V001";
		ex1.title = "Đề thi C#";
		ex1.category = cq2;
		ex1.duration = 90;
		ex1.creator = acc1;
		ex1.createDate = LocalDate.of(2020, 1, 13);

		Exam ex2 = new Exam();
		ex2.ID = 2;
		ex2.code = "V002";
		ex2.title = "Đề thi PHP";
		ex2.category = cq2;
		ex2.duration = 60;
		ex2.creator = acc3;
		ex2.createDate = LocalDate.of(2020, 2, 1);

		Exam ex3 = new Exam();
		ex3.ID = 3;
		ex3.code = "V001";
		ex3.title = "Đề thi JAVA";
		ex3.category = cq2;
		ex3.duration = 120;
		ex3.creator = acc2;
		ex3.createDate = LocalDate.of(2020, 1, 13);

		Question[] questOfExam1 = { quest1, quest2 };
		ex1.questions = questOfExam1;

		Question[] questOfExam2 = { quest2, quest3 };
		ex2.questions = questOfExam2;

		Question[] questOfExam3 = { quest1 };
		ex3.questions = questOfExam3;

		Exam[] examOfQuest1 = { ex1, ex3 };
		quest1.exams = examOfQuest1;

		Exam[] examOfQuest2 = { ex1, ex3 };
		quest2.exams = examOfQuest2;

		Exam[] examOfQuest3 = { ex2 };
		quest3.exams = examOfQuest3;

// IN
// Department
		System.out.println("Thông tin phòng ban 1:");
		System.out.println("  Department id: " + department1.ID);
		System.out.println("  Department name: " + department2.Name);

		System.out.println("Thông tin phòng ban 2: ");
		System.out.println("  Department id: " + department2.ID);
		System.out.println("  Department name: " + department2.Name);

		System.out.println("Thông tin phòng ban 3: ");
		System.out.println("  Department id: " + department3.ID);
		System.out.println("  Department name: " + department3.Name);
// Position
		System.out.println("Thông tin vị trí thứ 1: ");
		System.out.println("ID: " + position1.ID);
		System.out.println("Name: " + position1.Name);

		System.out.println("Thông tin vị trí thứ 2: ");
		System.out.println("ID: " + position2.ID);
		System.out.println("Name: " + position2.Name);

		System.out.println("Thông tin vị trí thứ 3: ");
		System.out.println("ID: " + position3.ID);
		System.out.println("Name: " + position3.Name);
// Account
		System.out.println("Thông tin account1: ");
		System.out.println("ID: " + acc1.ID);
		System.out.println("Email: " + acc1.email);
		System.out.println("UserName: " + acc1.userName);
		System.out.println("FullName: " + acc1.fullName);
		System.out.println("Department ID: " + acc1.department.ID);
		System.out.println("Position ID: " + acc1.position.ID);
		System.out.println("Create Date: " + acc1.createDate);
		System.out.println("List groups of Account1: ");
		for (int i = 0; i < acc1.groups.length; i++) {
			System.out.println(" " + acc1.groups[i].Name);
		}

		System.out.println("Thông tin account2: ");
		System.out.println("ID: " + acc2.ID);
		System.out.println("Email: " + acc2.email);
		System.out.println("UserName: " + acc2.userName);
		System.out.println("FullName: " + acc2.fullName);
		System.out.println("Department ID: " + acc1.department.ID);
		System.out.println("Position ID: " + acc2.position.ID);
		System.out.println("Create Date: " + acc2.createDate);
		System.out.println("List groups of Account2: ");
		for (int i = 0; i < acc2.groups.length; i++) {
			System.out.println(" " + acc2.groups[i].Name);
		}

		System.out.println("Thông tin account3: ");
		System.out.println("ID: " + acc3.ID);
		System.out.println("Email: " + acc3.email);
		System.out.println("UserName: " + acc3.userName);
		System.out.println("FullName: " + acc3.fullName);
		System.out.println("Department ID: " + acc1.department.ID);
		System.out.println("Position ID: " + acc3.position.ID);
		System.out.println("Create Date: " + acc3.createDate);
		System.out.println("List groups of Account3: ");
		for (int i = 0; i < acc3.groups.length; i++) {
			System.out.println(" " + acc3.groups[i].Name);
		}
// Group
		System.out.println("Thông tin Group 1: ");
		System.out.println("ID: " + gr1.ID);
		System.out.println("Name: " + gr1.Name);
		System.out.println("Người khởi tạo: " + gr1.creator.userName);
		System.out.println("Ngày tạo: " + gr1.createDate);
		System.out.println("List accounts of Group1:");
		for (int i = 0; i < gr1.accounts.length; i++) {
			System.out.println(" " + gr1.accounts[i].userName);
		}
// TypeQuestion
		System.out.println("Các dạng câu hỏi");
		System.out.println("ID: " + tq1.ID);
		System.out.println("Name: " + tq1.Name);
		System.out.println("ID: " + tq2.ID);
		System.out.println("Name: " + tq2.Name);
// CategoryQuestion
		System.out.println("Chủ đề câu hỏi: ");
		System.out.println("ID: " + cq1.ID);
		System.out.println("Name: " + cq1.Name);
		System.out.println("ID: " + cq2.ID);
		System.out.println("Name: " + cq2.Name);
// Question
		System.out.println("Câu hỏi thứ 1: ");
		System.out.println("ID: " + quest1.ID);
		System.out.println("Nội dung; " + quest1.content);
		System.out.println("Chủ đề: " + quest1.category.Name);
		System.out.println("Loại câu hỏi: " + quest1.type.Name);
		System.out.println("Người tạo: " + quest1.creator.userName);
		System.out.println("Ngày tạo: " + quest1.createDate);
		System.out.println("List exams of Question 1:");
		for (int i = 0; i < quest1.exams.length; i++) {
			System.out.println(" " + quest1.exams[i].title);
		}
// Answer
		System.out.println("Câu trả lời thứ 1");
		System.out.println("ID: " + asw1.ID);
		System.out.println("Nội dung câu hỏi: " + asw1.question.content);
		System.out.println("Nội dung câu trả lời: " + asw1.content);
		System.out.println("Đáp án: " + asw1.isCorrect);
// Exam
		System.out.println("Đề thi thứ 1: ");
		System.out.println("Code: " + ex1.ID);
		System.out.println("Tiêu đề: " + ex1.title);
		System.out.println("Chủ đề: " + ex1.category.Name);
		System.out.println("Thời gian thi: " + ex1.duration);
		System.out.println("Người tạo đề thi: " + ex1.creator.userName);
		System.out.println("Ngày khởi tạo: " + ex1.createDate);
		System.out.println("List questions of Exam 1: ");
		for (int i = 0; i < ex1.questions.length; i++) {
			System.out.println(" " + ex1.questions[i].content);
		}

	}
}