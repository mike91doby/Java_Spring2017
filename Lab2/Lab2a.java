import java.util.*;

public class Lab2a {
	
	// define enumerator for use in switch
	public enum activityLetter {A, B, C, D}

	// main program
	public static void main(String[] args) {
		// define a scanner object for input
		Scanner keyboard = new Scanner(System.in);
		
		// initialize variables
		int age = 0;
		int height = 0;
		int weight = 0;
		String sex = "";
		String activityLevel = "";
		String catchNewLine = "";
		float result = 0;
		
		// output description of program
		System.out.println("This program will calculate the number of 230 calorie");
		System.out.println("candy bars to eat to maintain your weight.");
		
		// prompt for age and store in variable
		System.out.println("What is your age in years?");
		age = keyboard.nextInt();
		
		// prompt for height and store in variable
		System.out.println("What is your total height in inches?");
		height = keyboard.nextInt();
		
		// prompt for weight and store in variable
		System.out.println("What is your weight in pounds?");
		weight = keyboard.nextInt();
		
		// catch the newline character that is output after the user types an int
		catchNewLine = keyboard.nextLine();
		
		// prompt for sex and store in variable
		do {
			System.out.println("Enter 'M' for male calculation or 'F' for female calculation.");
			sex = keyboard.nextLine();
		} while(!sex.toUpperCase().equals("M") && !sex.toUpperCase().equals("F"));
		
		// prompt for activity level and store in variable
		do {
			System.out.println("Are you:");
			System.out.println("A. Sedentary");
			System.out.println("B. Somwhat active (exercise occasionally)");
			System.out.println("C. Active (exercise 3-4 days per week)");
			System.out.println("D. Highly active (exercise every day)");
			System.out.println("Enter A,B,C, or D.");
			activityLevel = keyboard.nextLine();
		} while(!activityLevel.toUpperCase().equals("A") && !activityLevel.toUpperCase().equals("B") && !activityLevel.toUpperCase().equals("C") && !activityLevel.toUpperCase().equals("D"));
		
		// calculate the result for gender without involving activity level
		if(sex.toUpperCase().equals("M")) {
			result = (float)(66 + (6.3 * weight) + (12.9 * height) - (6.8 * age));
		} else if(sex.toUpperCase().equals("F")) {
			result = (float)(655 + (4.3 * weight) + (4.7 * height) - (4.7 * age));
		}
		
		// define an enumeration to use in switch
		activityLetter letter = activityLetter.valueOf(activityLevel.toUpperCase());
		
		// use the evaluated letter to move ahead in the switch statement
		switch(letter) {
		case A:
			System.out.printf("A %s with those measurements should eat %.2f candy bars per day to maintain the same weight.", (sex.toUpperCase().equals("M") ? "male" : "female"), ((result * 1.2) / 230));
			break;
		case B:
			System.out.printf("A %s with those measurements should eat %.2f candy bars per day to maintain the same weight.", (sex.toUpperCase().equals("M") ? "male" : "female"), ((result * 1.3) / 230));
			break;
		case C:
			System.out.printf("A %s with those measurements should eat %.2f candy bars per day to maintain the same weight.", (sex.toUpperCase().equals("M") ? "male" : "female"), ((result * 1.4) / 230));
			break;
		case D:
			System.out.printf("A %s with those measurements should eat %.2f candy bars per day to maintain the same weight.", (sex.toUpperCase().equals("M") ? "male" : "female"), ((result * 1.5) / 230));
			break;
		}
		
		// close the keyboard
		keyboard.close();
	}

}
