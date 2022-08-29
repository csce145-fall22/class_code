import java.util.Scanner;

public class TypesEtc {

	private static void print(String s) {
		System.out.println(s);
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		//Our go-to primitive types for now:
		int i = 2; // signed, 32b integer -~2B -> ~2B (2^10 = 1024)
		double d = 1.234; //signed, 64-bit DOUBLE precision"floating point". 
		boolean b = true; //booleans are true/false values. 
		char c = 'c'; //Unicode characters, 16 bits, often used with strings
		
		//less used types
		byte chomp = 2; // signed 8-bit integral value -128->127
		short s = 5;  //signed 16-bit integral value max min is about +/- 32K
		long l = 123456789; //signed 64b integral value
		float f = (float) 3.14; // cast necessary (decimal values default double)
		
		//Important
		print("Demonstrating floating point \"rounding\" error");
		double x = 0.1+0.2;
		System.out.println(x);
		System.out.println("Does 0.3 == 0.1+0.2?"+(0.3 == x) );
		//NEVER compare double/float values for EQUALITY (with one minor caveat -- assignment exact)
		System.out.println("Does x == x "+(x==x));
		//..or even
		System.out.println("Does x == 0.1+0.2?"+(x == 0.1+0.2) );
		//this is not RANDOM error, but rather the limits of having only so many bits
		
		//Integral operations are free of this issue as long as your
		//results don't "overflow" or "underflow"
		int reallyBig = 2000000000; //2e9 ~2^31
		System.out.println(reallyBig+reallyBig);
		//Takeaway: Unless we have a LOT of data, we want to use
		//the larger types to avoid most of these issues
		//long is a little too big for most integral data but
		//floating point values benefit from extra bits 
		
		double doubleBig = 2e9;
		System.out.println("2* doubleBig= "+2* doubleBig);
		//oh, hey, '*' is multiplication 
		double doubleReallyBig = 2e50;
		System.out.println(2*doubleReallyBig);
		double doubleReallyReallyBig = 2e100;
		System.out.println(2*doubleReallyReallyBig);
		
		//common operations and constants  you would expect are 
		//either predefined or in Math class
		print("pi ="+Math.PI);
		print("2^10 = "+Math.pow(2.0, 10.0));
		
		//there are some issues with using integral values too:
		print ("4/3="+(4/3)); //note, parentheses are required
		print("5/3="+(5/3));// always "rounds down"
		print("-5/3="+(-5/3));// "down" here means towards zero
		print("6/3="+(6/3));
		
		print("Here are our 4 common types");
		print("i="+i);
		print("d="+d);
		print("b="+b);
		print("c="+c);
		print("Let update our common types, enter them all on one line");
		i=in.nextInt();
		d=in.nextDouble();
		b=in.nextBoolean();
		// good idea to follow the next<PrimitiveType>() calls with nextLine()
		String rest=in.nextLine();  
		//trim() get's rid of the leading/following whitespace
		//returns a string
		//charAt() returns then first non-
		c=rest.trim().charAt(0);
		print("Here are our 4 common type variables,updated");
		print("i="+i);
		print("d="+d);
		print("b="+b);
		print("c="+c);
		//What about String?
		//string has special language support, e.g. '+' for concatenation
		// and also "I make a String"
		//...but it is just an Object
		//Everything not one of the primitive types is an Object (subtype)


		
		
	}

}
