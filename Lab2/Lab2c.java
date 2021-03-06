import java.util.*;

public class Lab2c {

	public static void main(String[] args) {
		// define Scanner object for input
		Scanner keyboard = new Scanner(System.in);
		
		// initialize variables
		int numerator = 0;
		int denominator = 0;
		int wholeNumber = 0;
		int remainder = 0;
		
		// loop through while the numerator is not 0
		do {
			
			// prompt and store numerator
			System.out.print("Enter a numerator: ");
			numerator = keyboard.nextInt();
			
			// break out if the numerator is 0
			if(numerator == 0){
				// close Scanner object
				keyboard.close();
				
				// print message and exit program
				System.out.println("program exited");
				System.exit(0);
			}
			
			// prompt and store denominator
			System.out.print("Enter a denominator: ");
			denominator = keyboard.nextInt();
			
			// if the denominator is not zero and the fraction is improper
			if((denominator > 0) && ((numerator / denominator) != 0)) {
				// process the fraction
				wholeNumber = numerator / denominator;
				remainder = numerator % denominator;
				
				// if there is a remainder the fraction is a mixed number
				if(remainder > 0) {
					System.out.printf("%d / %d is an improper fraction and its mixed fraction is %d + %d / %d\n\n", numerator, denominator, wholeNumber, remainder, denominator);
				} else {
					// otherwise, the fraction is improper
					System.out.printf("%d / %d is an improper fraction and it can be reduced to %d\n\n", numerator, denominator, wholeNumber);
				}
				
			} else {
				// or else print out the fraction as a proper
				System.out.printf("%d / %d is a proper fraction\n\n", numerator, denominator);
			}
			
		} while(true);
		
	}

}
