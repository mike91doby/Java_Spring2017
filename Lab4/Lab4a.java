import java.util.Scanner;

public class Lab4a {

	public static void main(String[] args) {
		// Create Scanner object
		Scanner keyboard = new Scanner(System.in);
		
		// Create required objects
		Ledger testingLedger = new Ledger(10);

		// Sample input/output
		System.out.println("Testing Ledger:");
		System.out.println("Adding sales 3.52, 2.43, 9.00, 3.5, 5.0");
		try {
			testingLedger.addSale(3.52);
			testingLedger.addSale(2.43);
			testingLedger.addSale(9.00);
			testingLedger.addSale(3.5);
			testingLedger.addSale(5.0);
		} catch(IndexOutOfBoundsException e) {
			System.out.println("Too many sales added.");
		}
		
		System.out.print("The total number of sales are: ");
		System.out.println(testingLedger.getNumberOfSales());
		
		System.out.print("The total amount of sales is: ");
		System.out.println(testingLedger.getTotalSales());
		
		System.out.print("The average sale amount is: ");
		try {
			System.out.println(testingLedger.getAverageSale());
		} catch(ArithmeticException e) {
			System.out.println("No sales have been made.");
		}
		
		System.out.print("The number of sales greater than 3.5 is: ");
		System.out.println(testingLedger.getCountAbove(3.5));
		
		System.out.print("The number of sales greater than 3 is: ");
		System.out.println(testingLedger.getCountAbove(3));
		
		// Close Scanner object
		keyboard.close();
	}

}
