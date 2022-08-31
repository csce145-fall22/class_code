import java.util.Scanner;

public class BoolsOpsCompsRandom {
	private static void print(String s) {
		System.out.println( s);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		boolean True = true;
		boolean False = false;
		
		//short-circuit and,&&
		print("logical and &&");
		print("True&&True="+(True&&True));
		print("False&&True="+(False&&True));
		print("True&&False="+(True&&False));
		print("False&&False="+(False&&False));
		print("");
		//short-circuit or, ||
		print("\"logical or\" ||");
		print("True||True="+(True||True));
		print("False||True="+(False||True));
		print("True||False="+(True||False));
		print("False||False="+(False||False));
		
		//logical not, !
		print("\nLogical not, !");
		print("!True="+(!True));
		print("!False="+(!False));
		
		//logical XOR (exclusive or): or but not and, ^, bit-wise 
		print("\nLogical XOR, ^");
		print("True^True="+(True^True));
		print("False^True="+(False^True));
		print("True^False="+(True^False));
		print("False^False="+(False^False));
		
//Password code
//		print(""+in.nextLine().equals("supersecret") );
		
		//DO NOT COMPARE STRINGS with ==
//		if(in.nextLine()=="supersecret") {
//			print("that's correct!");
//		}
		print("\nDo you want password or temp?");
		String ans = in.nextLine();
		if(ans.trim().equals("password") ) {
			print("\nwhat is your password:");
			if(in.nextLine().equals("supersecret")) {
				print("that's correct!");
			} 
			else {//else optional
				print("that's incorrect!");
			}
		}
		else {
			print("What is the temperature of your coffee?");
			int temp = Integer.parseInt(in.nextLine());
			if(temp>=120) {
				print("Wow, too hot!");
			} else if(temp <= 80 ) {
				print("Too cold, put in microwave");
			} else {
				print("Just right! Get some biscuits");
			}
		}
		
		print("let's roll a six-sided die...");
		//Math.random() returns a random double between 0 and 1,
		//the 1 is exclusive, 0 inclusive, i.e. [0,1)
		//we multiply it by six to get the range from 0-5
		//we "cast", meaning convert, it to int by using (int)
		//we add 1 to change the range from 0-5 to 1-6
		int roll = (int)Math.random()*6+1;
		print("Our roll is ... "+roll);
		//if you need a random integer from 1-3, then change 6 to 3
		//if you need a random integer from 0-5, then remove the "+1"
		
	}
}
