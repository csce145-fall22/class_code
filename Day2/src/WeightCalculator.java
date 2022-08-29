import java.util.Scanner;

public class WeightCalculator {
	
	private static void print(String s) {
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		System.out.println("What is your name?");
		
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		
		print("Hello "+ name);
		print("How much do you weigh?");
		
//		double weight = in.nextDouble();
		double weight = Double.parseDouble(in.nextLine());
		
		print("Is this \"pound\"s or \"kilograms\"?");
		String wtUnit = in.nextLine();
//		print("Begin:"+wtUnit+":End");
		if(!wtUnit.equals("kilograms")) { //use .equals() to compare strings
			weight = weight/2.2;
		}
		
		print("Your weight in kg is "+weight+" kgs.");
		
		print("What is your height?");
		double height = Double.parseDouble(in.nextLine());
		print("Is this (i)nches or (c)entimeters");
		String htUnit = in.nextLine(); 
		if(htUnit.toLowerCase().charAt(0)=='i') {
			height = height * 2.54;
		} 
	}
}
