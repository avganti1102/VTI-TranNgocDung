package backend.entity;

import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {
	private static final long serialVersionUID = 123L;
	private String id;
	private String name;
	
	public Student() {	}
	
	public Student(String id,String name) {
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhập id học sinh: ");
		setId(sc.nextLine());
		//sc.nextLine();
		System.out.println("Nhập tên học sinh: ");
		setName(sc.nextLine());
	}
	public void show() {
		System.out.println(" 	Id: " + getId());
		System.out.println("	Name: "+ getName());
	}
	public String toString() {
		return getId() +"-"+  getName();
	}
	
}	
