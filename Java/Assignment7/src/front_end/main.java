package front_end;

import java.io.IOException;
import java.util.ArrayList;

import backend.entity.Student;
import common.FileUtils;

public class main {

	public static void main(String[] args) throws IOException {
		Student s1 = new Student("1","Hung");
		Student s2 = new Student("2","Dzung");
		Student[] stList = {s1,s2};
		String filePath = "src/front_end/StudentInfo.txt";
		FileUtils.writeStudentList(stList, filePath);
		ArrayList<Student> sts = FileUtils.readStudentsIntoArray(filePath);
		for (Student student : sts) {
			System.out.println(student.toString());
		}
	}

}
