import java.util.Scanner;


public class TypesEtc {
	private static void print(String s) {
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		//go to primitive types
		int i = 2;//integral, 32b (32 bits), signed -2e9 -> 2e9
		double d = 1.234;//float point type 64b double precsion
		boolean b = true;
		char c = 'x';//single Unicode char, 16b
		
		//less used
		byte chomp = 16;//signed 8b, eight bits(b) to a byte(B)
		short s = 5; //signed 16b integral value
		long l = 123456789;//signed 64b integral value
		float f = (float) 3.14; // "(float)" is a cast
		//float is a 32b floating point value
		
		print("Demonstrating floating point value issues");
		double x = 0.1+0.2;
		System.out.println(x);
		print("Does 0.3 == 0.1+0.2?"+( 0.3 == 0.1+0.2));
		print("Does x == x? "+(x == x));
		print("Does x == 0.1+0.2"+(x == 0.1+0.2));
		
		print("int overflow");
		int reallyBig = 2000000000; //2e9 or ~2^31
		System.out.println(reallyBig+reallyBig);
		
		double doubleBig = 2e9;
		print("2*doubleBig="+(2*doubleBig));// * is multiplication
		double doubleReallyBig = 2e100;
		print("2*doubleReallyBig="+(2*doubleReallyBig));
		
		print("pi = "+Math.PI);
		print("2^10 = "+Math.pow(2, 10));
		
		print("4/3="+4/3);
		print("5/3="+5/3);
		print("-5/3="+-5/3);
		
		print("6/3="+6/3);
		
		print("5%3="+5%3);
		print("Here are our 4 common types:");
		print("i="+i);
		print("d="+d);
		print("b="+b);
		print("c="+c);
		print("let's update our values");
		i=in.nextInt();
		d=in.nextDouble();
		b=in.nextBoolean();
		c=in.nextLine().trim().charAt(0);
		print("Here are our updated 4 common types:");
		print("i="+i);
		print("d="+d);
		print("b="+b);
		print("c="+c);
		
		
	}
}
