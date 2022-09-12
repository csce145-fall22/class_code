import java.util.Scanner;

public class WeightCalculator {
	
	private static void print(String s) {
		System.out.println(s);
	}
	
	private static double BMI(double kgWeight, double cmHeight) {
		double bmi = kgWeight/Math.pow(cmHeight/100,2);
		return bmi;
	}
	
	private static double BMR(double weight,double height,int age,boolean male) {
		if(male) {
			return 66.5+13.75*weight+5.003*height-6.75*age;
		}
		else {
			return 655.1+9.563*weight+1.850*height-4.676*age;
		}
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
			print("your height in cm is "+height);
		} 
		
		double bmi = BMI(weight,height);
		
		print("Your BMI is "+bmi);
		
		print("Would you like to see recommendations? (yes/no)");
		
		boolean hearRecommendations = in.nextLine().toLowerCase().trim().equals("yes");
		
		if(!hearRecommendations) {
			System.out.println("Thank you for using this calculator");
			System.exit(0);//0 for normal exit, 1+ for irregular
		}
		
		print("How old are you in years?");
		int age = Integer.parseInt(in.nextLine());
		
		print("Are you male or female?");
		boolean isMale = in.nextLine().toLowerCase().trim().charAt(0)=='m';
		
		double bmr = BMR(weight,height,age,isMale);
		
		print("Your BMR is "+bmr);
		
		int activityLevel = -1;
		boolean validLevel = false;
		while(!validLevel) {
			System.out.println("What would you consider your activity level? (1-5)"
					+"\n1.Sedentary"
					+"\n2.Lightly Active"
					+"\n3.Moderately Active"
					+"\n4.Very Active"
					+"\n5.Extremely active (Physical Job)");
			activityLevel = Integer.parseInt(in.nextLine());
			if(1<=activityLevel && activityLevel<=5) {
				validLevel = true;
			}
			else {
				print("please enter a valid integer 1,2,3, 4, or 5");
			}
		}
		
		double dailyCaloricIntake = bmr;
		switch(activityLevel) {
		case 1:
			dailyCaloricIntake = dailyCaloricIntake*1.2;
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
		print("Your daily caloric intake to maintain your weight at "
				+"\n your activity level is :"+dailyCaloricIntake);
		
		if(bmi<18.5) {
			System.out.println("Since your BMI is less than 18.5, you might consider:");
			print("Eating 500 more calories, "
					+(dailyCaloricIntake+500) 
					+"/day, to gain one pound per week.");
		} else if(bmi >25) {
			print("Since your BMI is greater than 25, you might consider:");
			print("Eating 500 fewer calories,"
					+(dailyCaloricIntake-500)
					+"/day to lose one pound per week");
		}else {
			print("You are at a healthy weight.");
		}
		
		
	}
}
