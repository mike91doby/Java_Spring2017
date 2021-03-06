import java.util.*;

public class Lab2b {

	public static void main(String[] args) {
		// define scanner object to be used for input
		Scanner keyboard = new Scanner(System.in);
		
		// initialize variable
		int inputNumbers = 0;
		int largestNumber = 0;
		int occurrences = 0;
		
		// prompt for input
		System.out.print("Enter an integer (0 ends the input): ");
		
		// get and process a series of numbers
		while(true) {
			// read the next number in the input stream or allow for more input until 0 is reached
			inputNumbers = keyboard.nextInt();
			
			// find and count the largest number
			if(largestNumber < inputNumbers) {
				largestNumber = inputNumbers;
				occurrences = 1;
			} else if (largestNumber == inputNumbers) {
				occurrences++;
			}
			
			// break out of loop if number is 0
			if(inputNumbers == 0) {
				break;
			}
		}
		
		// print output
		System.out.printf("The largest number is %d", largestNumber);
		System.out.println();
		System.out.printf("The number %d appears %d times", largestNumber, occurrences);
		
		// close the Scanner object
		keyboard.close();
	}

}
