package Assignment3;

import java.util.Random;

public class Ex1 {
	public static int Question4(int a,int b){
		return a-b;
	}
	
	public static void main(String[] args){
		
//Q1
		float a = 5240.5f;
		float b = 10970.055f;
		
		int c = (int)a;
		int d = (int)b;
		System.out.println("Lương Account 1 làm tròn: " + c + "$");
		System.out.println("Lương Account 2 làm tròn: " + d+ "$");
		
//Q2
		Random rd = new Random();
		int random = rd.nextInt(100000);
		String test = String.valueOf(random);
		String so = "";
		String result = "";
		switch(test.length()){
		case 5:
			so = "";
			result = so.concat(test);
			System.out.println(result);
			break;
		case 4:
			so = "0";
			result = so.concat(test);
			System.out.println(result);
			break;
		case 3:
			so = "00";
			result = so.concat(test);
			System.out.println(result);
			break;
		case 2:
			so = "000";
			result = so.concat(test);
			System.out.println(result);
			break;
		default:
			so = "0000";
			result = so.concat(test);
			System.out.println(result);
			break;
		}
//Q3
		System.out.println("Hai số cuối: " + result.substring(3));
//Q4
		System.out.println(Question4(2,3));
	}
}
