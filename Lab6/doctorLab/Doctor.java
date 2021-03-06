package doctorLab;

public class Doctor extends Person{
	// Define class properties
	private String name;
	private String specialty;
	private double officeVisitFee;
	
	// Define class constructor
	public Doctor(String name, String specialty, double officeVisitFee) {
		super(name);
		this.name = super.getName();
		this.specialty = specialty;
		this.officeVisitFee = officeVisitFee;
	}
	
	// Define class methods
	@Override
	public void writeOutput() {
		System.out.println("Name: " + this.name + "\nOffice Fee: $" + this.officeVisitFee + "\nSpecialty: " + this.specialty + "\n");
	}
	
	public double getOfficeVisitFee() {
		return this.officeVisitFee;
	}
}
