package doctorLab;

public class doctorLab {

	public static void main(String[] args) {
		
		// Create two doctors
		Doctor doctor1 = new Doctor("FirstDoctor", "Doctoring", 50);
		Doctor doctor2 = new Doctor("SecondDoctor", "Doctoret", 25);
		
		// output doctor information
		System.out.println("Two doctors created: \n");
		doctor1.writeOutput();
		doctor2.writeOutput();
		
		// Create two patients
		Patient patient1 = new Patient("FirstPatient", "123-45-6789");
		Patient patient2 = new Patient("SecondPatient", "987-65-4321");
		
		// Output patient information
		System.out.println("Two patients created: \n");
		patient1.writeOutput();
		patient2.writeOutput();

		// Create billing records
		Billing billing1 = new Billing(doctor1, patient1);
		Billing billing2 = new Billing(doctor1, patient2);
		Billing billing3 = new Billing(doctor2, patient1);
		
		// Output billing information
		System.out.println("Three billing records created: \n");
		billing1.writeOutput();
		billing2.writeOutput();
		billing3.writeOutput();
		
		// Check if two billing records are equal
		System.out.println("First billing record equal to the second = " + billing1.equals(billing2));
		System.out.println("First billing record equal to itself = " + billing1.equals(billing1));
	}

}
