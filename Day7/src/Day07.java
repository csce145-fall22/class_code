import java.util.Scanner;

public class Day07 {

	public static boolean isHeads(String coin) throws Exception {
		
		switch(coin) {
		case "heads":
			return true;
		case "tails":
			return false;
		default:
			throw new Exception();
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Scanner in = new Scanner(System.in);
		//little bit of code to demonstrate breakpoints
		/*
		System.out.println("Hello Day 7. ' test' ");
		System.out.println("...looking forward to day 8");
		System.out.println("...not day 8 yet");
		char c = '\'';
		System.out.println(c);
		int numDays = 0;
//		numDays 
 
		 */
//		try {
//			System.out.println(isHeads("heads"));
//		} catch(Exception e) {
//			System.out.println(e.getMessage());
//		}
		
		double roachVol = 0.002;
		double houseSquareFootage = 1500;
		double ceilingHeight = 8.5;
		double houseVol = houseSquareFootage * ceilingHeight;
		
		double GROWTH_RATE = 0.95;
		
		int numRoaches = 2; 
		
		int week = 0;
		
		while(numRoaches*roachVol <houseVol) {
			numRoaches += GROWTH_RATE*numRoaches;
			++week;
		}
		
		System.out.println("Calculating....");
//		Thread.sleep(3*1000);
		
		System.out.println("It took "+ week+" weeks to fill the house.");
		
		for( int count = 3; count >0 ; --count ) {
			System.out.print(count);
			System.out.println(" ...and counting");
//			Thread.sleep(1000);
		}
		System.out.print("... and LIFTOFF");
		for( int i = 0; i<1000; ++i ) {
			System.out.print("!");
		}
		System.out.println("");
		
		System.out.println("\nEnter a list of scores," 
					+" ending with a negative number");
		int min = -1;
		int next = in.nextInt();
		in.nextLine();
		while(next >= 0) {
			if(min <0 || next < min ) min = next; 
			next = in.nextInt();
			in.nextLine();
		}
		if(min == -1) {
			System.out.println("Please enter at least one number!");
		}
		else {
			System.out.println("THe minimum was "+ min);
		}
		
		
		System.out.println("Please enter 3 positive integers");
		int[] ns = new int[3];
		for(int i = 0; i < 3 ; ++i) {
			int j = in.nextInt();
			if(j <= 0) {
				System.out.println("Can't you count to three?????");
				System.exit(1);
			}
			ns[i] = j;
		}
		System.out.println("THe first number entered was "+ ns[0]);
		System.out.println("The last number entered was "+ ns[ns.length-1]);
					
		
	}

}
