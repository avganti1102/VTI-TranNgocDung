package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;

import backend.entity.Student;

public class FileUtils {
	private static Writer txtWrite = null;
	private static Reader txtRead = null;
	private static BufferedReader bufRead;
	private static int c = -1;
	/**
	 * Mục đích function, mô tả các case cụ thể trong code
	 * @param st : chỉ rõ từng thuộc tính là gì
	 * @param i : só thứ tự
	 * @param filePath : đường dẫn tới file
	 * @throws IOException : Có thể có ngoại lệ xảy ra
	 */
	public static void writeStudent(Student st,int i, String filePath) throws IOException {
		txtWrite = new FileWriter(new File(filePath),true);
		txtWrite.write("Student " + i + ": " + st.toString() + "\n");
		txtWrite.close();
	}
	
	public static void writeStudentList(Student[] sts,String filePath) throws IOException {
		for (int i = 0; i < sts.length; i++) {
			writeStudent(sts[i],i+1,filePath);
		}
	}
	
	public static void readStudent(String filePath) throws IOException {
		txtRead = new FileReader(new File(filePath));
		while((c = txtRead.read()) != -1) {
			System.out.println((char) c);
		}
		txtRead.close();
	}
	//Doc tat ca cac Student tu file va tra ve 1 danh sach cac Student
	//filePath: Duong dan toi file
	/**
	 * 
	 * @param filePath
	 * @return
	 * @throws IOException 
	 */
	public static ArrayList<Student> readStudentsIntoArray(String filePath) throws IOException{
		ArrayList<Student> stList = new ArrayList<Student>();
		txtRead = new FileReader(new File(filePath));
		bufRead = new BufferedReader(txtRead);
		String line = null;
		while((line = bufRead.readLine()) != null) {
			Student currentStudent = converStringToStudent(line);
			stList.add(currentStudent);
			}
		return stList;
	}
	
	public static Student converStringToStudent(String line) {
		String id = null;
		String name = null;
		//Phan tich cú pháp text để lấy được id và name
		//Substring(beginIndex, endIndex) : "Dzung".substring(1,5) <=> "zung"
		//beginIndex cua id la sau dau : 1 ki tu
		int beginIndexOfID = line.indexOf(":") + 1;
		int endIndexOfID = line.indexOf("-");
		int beginIndexOfName = endIndexOfID + 1;
		id = line.substring(beginIndexOfID, endIndexOfID);
		name = line.substring(beginIndexOfName);
		return new Student(id, name);
	}
}
