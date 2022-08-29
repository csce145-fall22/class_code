import java.util.Scanner;

public class WeightlossCalculator0 {

	public static void main(String[] args) {
		System.out.println("What is your name?");
		
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		
		System.out.println("Nice to meet you "+name);
		
		System.out.println("How old are you?");
		int age = Integer.parseInt(in.nextLine());
		
		System.out.println("How much do you weigh?");
		//double weight = in.nextDouble();
		// talk about above ... leftovers mess up the unit's readLine.
		double weight = Double.parseDouble(in.nextLine());
		
		System.out.println("Is this pounds or kilograms?"
				+"Enter \"pounds\" or \"kilograms\".");
		String unit = in.nextLine();
		boolean inMetric = false;
		if(unit.toLowerCase().equals("kilograms")
				||unit.toLowerCase().equals("kilogram")){
			inMetric = true;
		}
		
		if (!inMetric) {
			weight = weight/2.2;//2.2 pounds per kilo
		}
		System.out.println("Your weight in kg = "+weight);
		System.out.println("What is your height?( in inches or cm)");
		double height = Double.parseDouble(in.nextLine());
		System.out.println("Is this in inches or cm?");
		String heightUnit = in.nextLine();
		if(! heightUnit.toLowerCase().equals("cm")) {
			height = height*2.54;
		}
		double bmi = weight/Math.pow(height/100,2);
		
		System.out.println("Your bmi is: "+bmi);
		
		System.out.println("Would you like to see recommendations? (y)es/(n)o ");
		String hearRecommendations = in.nextLine();
		if (hearRecommendations.charAt(0)=='n') {
			System.out.println("Thanks you for using this calculator!!!");
		} else {
			System.out.println("Try version 1.0!");
		}
		
		
	}

}
