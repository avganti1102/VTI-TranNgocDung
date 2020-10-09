package front_end;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import backend.entity.Student;

public class Program1 {
	public static void main(String[] args){
		Student[] s = {
				new Student(1,"Dzung"),
				new Student(2,"Hoang"),
				new Student(3,"Tai")
		};
		String filePath = "F:\\StudentInfo.txt";
		File file = new File(filePath);
		if(file.exists() == false) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileWriter fw = null;
		FileInputStream fis = null;
		try {
			fw = new FileWriter(file);
			for (int i = 0; i < s.length; i++) {
				fw.write("Id: " + s[i].getId() + "\n");
				fw.write("Name: "+s[i].getName() + "\n");
			}
			fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				fis.close();
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
}
