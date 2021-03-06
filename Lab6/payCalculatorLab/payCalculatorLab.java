package payCalculatorLab;

public class payCalculatorLab {

	public static void main(String[] args) {
		// Declare variables
		double regTotal;
		double hazTotal;
		
		// Define objects
		RegularPay regPay = new RegularPay(7.5);
		HazardPay hazPay = new HazardPay(7.5);
		
		// Get pay for 40 hours on each object
		regTotal = regPay.getPay(40);
		hazTotal = hazPay.getPay(40);
		
		// Output results
		System.out.println("40 hours regular pay at 7.5 is " + regTotal);
		System.out.println("40 hours hazard pay at 7.5 is " + hazTotal);
		System.out.println();
		
		// Change pay rates to be 17 for each object
		regPay.changeRate(17);
		hazPay.changeRate(17);
		
		// Get pay for 40 hours on each object
		regTotal = regPay.getPay(40);
		hazTotal = hazPay.getPay(40);
		
		// Output results
		System.out.println("40 hours regular pay at 17 is " + regTotal);
		System.out.println("40 hours hazard pay at 17 is " + hazTotal);
	}

}
