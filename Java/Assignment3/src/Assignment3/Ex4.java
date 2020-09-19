package Assignment3;

import java.util.Scanner;

public class Ex4 {
	static Scanner sc = new Scanner(System.in);
	static String str = "";
	static String s1 = "";
	static String s2 = "";
	static String s3 = "";
	static String[] word;

	public static void main(String[] args){
//Q1
		System.out.println("Nhập chuỗi: ");
		str = sc.nextLine();
		word = str.split(" "); //Tách các từ được cách bởi space làm một phần tử mảng
		System.out.println("Số lượng các từ: " + word.length);
	
//Q2
		System.out.println("Nhập chuỗi s1: ");
		s1 = sc.nextLine();
		System.out.println("Nhập chuỗi s2: ");
		s2 = sc.nextLine();
		s3 = s1.concat(s2);
		System.out.println(s3);

//Q3
		System.out.println("Nhập tên: ");
		str = sc.nextLine();
		if(str.charAt(0) > 96 && str.charAt(0) < 123){
			str = str.substring(0,1).toUpperCase() + str.substring(1);
		}
		System.out.println(str);	
		

//Q4
		System.out.println("Nhập tên: ");
		str = sc.nextLine();
		for (int i = 0; i < str.length(); i++) {
			System.out.println("Ký tự thứ "+ (i+1) + " là: "+ str.toUpperCase().charAt(i));
		}

		
//Q5
		System.out.println("Nhập họ: ");
		s1 = sc.nextLine();
		System.out.println("Nhập tên: ");
		s2 = sc.nextLine();
		System.out.println("Họ và tên: " + s1+ " "+ s2);
	
//Q6
		System.out.println("Nhập họ và tên: ");
		str = sc.nextLine();
		word = str.split(" ");
		System.out.println("Họ là: " + word[0].substring(0,1).toUpperCase() + word[0].substring(1));
		System.out.println("Đệm là: "+ word[1].substring(0,1).toUpperCase() + word[1].substring(1));
		System.out.println("Tên là: "+ word[2].substring(0,1).toUpperCase() + word[2].substring(1));
	
//Q7
		System.out.println("Nhập họ tên đầy đủ");
		str = sc.nextLine();
		System.out.println(str.trim());
		word = str.split(" ");
		for (int i = 0; i < word.length; i++) {
			System.out.print( word[i].substring(0,1).toUpperCase() + word[i].substring(1)+ " ");
		}

//Q10
		System.out.println("Nhập chuỗi s1: ");
		s1 = sc.nextLine();
		System.out.println("Nhập chuỗi s2: ");
		s2 = sc.nextLine();
		String reverse = new StringBuffer(s2).reverse().toString();
		if(reverse.equals(s1) == true){
			System.out.println("OK");
		}
		else{
			System.out.println("KO");
		}

//Q11
		System.out.println("Nhập chuỗi");
		str = sc.nextLine();
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'a'){
				count++;
			}
		}
		System.out.println("Ký tự 'a' xuất hiện "+count+" lần");
		
//Q12
		String reverse1 = "";
		System.out.println("Nhập chuỗi");
		str = sc.nextLine();
		for (int i = str.length() - 1; i >= 0; i--) {
			reverse1 += str.charAt(i);
		}
		System.out.println(reverse1);
		
//Q13
		System.out.println("Nhập chuỗi");
		str = sc.nextLine();
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9'){
				System.out.println("False");
				return;
			}		
		}
		System.out.println("True");
		
//Q14
		System.out.println("Nhập chuỗi");
		str = sc.nextLine();
		String replace1 = str.replace('e', '*');
		System.out.println(replace1);
		
//Q15
		System.out.println("Nhập chuỗi");
		str = sc.nextLine();
		String[] splits = str.split(" ");
		String[] arr = new String[splits.length];
		int ai = 0;
		for (int i = splits.length - 1; i >= 0; i--) 
		{
			if(!"".equals(splits[i])){
				arr[ai] = splits[i];
				ai+=1;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null)
				if(arr[i+1] != null)
				System.out.print(arr[i] + " ");
				else
					System.out.println(arr[i]);
		}
	}
}
