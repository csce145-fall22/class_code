import java.util.Scanner;

public class WeightlossCalculator1 {

	private static double poundsToKg(double poundWeight) {
		return poundWeight/2.2;
	}
	
	private static double kgToPounds(double kgWeight) {
		return kgWeight*2.2;
	}
	
	private static double inchesToCm(double inches) {
		return 2.54*inches;
	}
	
	private static double cmToInches(double cm) {
		return cm/2.54;
	}
	
	private static double BMI(double kgWeight, double cmHeight) {
		return kgWeight/Math.pow(cmHeight/100, 2);
	}
	
	private static double BMR(double kgWt, double cmHeight, int ageYears, boolean male) {
		if (male) {
			return 66.5 +13.75*kgWt+5.003*cmHeight-6.75*ageYears;
		}
		return 655.1+9.563*kgWt+1.850*cmHeight-4.676*ageYears;
	}
	
	
	public static void main(String[] args) {
		System.out.println("What is your name?");
		
		Scanner in = new Scanner(System.in);
		String name = in.nextLine();
		
		System.out.println("Nice to meet you "+name);
		
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
			weight = poundsToKg(weight);//2.2 pounds per kilo
		}
		System.out.println("Your weight in kg = "+weight);
		System.out.println("What is your height?( in inches or cm)");
		double height = Double.parseDouble(in.nextLine());
		System.out.println("Is this in inches or cm?");
		String heightUnit = in.nextLine();
		if(! heightUnit.toLowerCase().equals("cm")) {
			height = inchesToCm(height);
		}
		double bmi = BMI(weight,height);
		
		System.out.println("Your bmi is: "+bmi);
		
		System.out.println("Would you like to see recommendations? (y)es/(n)o ");
		String hearRecommendations = in.nextLine();
		if (hearRecommendations.toLowerCase().charAt(0)=='n') {
			System.out.println("Thanks you for using this calculator!!!");
		} 
		
		//collect recommendation information
		System.out.println("How old are you?");
		int age = Integer.parseInt(in.nextLine());
		System.out.println("Are you (M)ale or (F)emale?");
		boolean male = in.nextLine().toLowerCase().charAt(0)=='m';
		double bmr = BMR(weight,height,age,male);
		
		int activityLevel = -1;
		boolean validLevel = false;
		while(! validLevel) {
			System.out.println("What would you consider your activity level? (1-5)"
				+"1. Sedentary"
				+"2. Lightly active"
				+"3. Moderately active"
				+"4. Very Active"
				+"5. Extra/Extremely active (physical job, etc.)");
			activityLevel = Integer.parseInt(in.nextLine());
			if (activityLevel>0&&activityLevel<=5) {
				validLevel = true;
			} else {
				System.out.println("Please enter a number 1-5");
			}
		}
		
		double dailyCaloricIntake = bmr;
		switch(activityLevel) {
		case 1:
			dailyCaloricIntake *= 1.2;
			break;
		case 2:
			dailyCaloricIntake *= 1.375;
			break;
		case 3:
			dailyCaloricIntake *= 1.55;
			break;
		case 4:
			dailyCaloricIntake *= 1.725;
			break;
		default:
			dailyCaloricIntake *= 1.9;
			break;
		}
		
		System.out.println("Your daily caloric intake, to maintain your weight is "
				+dailyCaloricIntake+" calories.");
		if (bmi<18.5) {
			System.out.println("Since your BMI is less than 18.5, you might consider:");
			System.out.println("Eating "+ dailyCaloricIntake+500.0
					+ " calories to gain 1 pound/week");
			System.out.println("Eating "+ dailyCaloricIntake+1000.0
					+ " calories to gain 2 pounds/week");
		} else if (bmi >= 25) {
			System.out.println("Since your BMI is greater than 25, you might consider:");
			System.out.println("Eating "+ (dailyCaloricIntake-500.0)
					+ " calories to lose 1 pound/week");
			System.out.println("Eating "+ (dailyCaloricIntake-1000.0)
					+ " calories to lose 2 pounds/week");
		} else {
			System.out.println("You are considered a healthy weight.");
			System.out.println("If you are interested in gaining and losing "
					+"a little weight, consider adding or subtracting around "
					+"500 calories per day.");
		}
		
		
		
		
	}

}
