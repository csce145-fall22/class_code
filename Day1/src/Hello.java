import java.util.Scanner;

public class Hello {

	private static void print(String s) {
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		System.out.println("Hello 145!");
		
		System.out.println("What is your name?");
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		System.out.println("Hello "+name+"!!");
		
		print("What is your age?");
		int age = in.nextInt();
		print(age+""); 
//		System.out.println(age);
		
		
	}
}
