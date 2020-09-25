
public class Employee extends Person {

	// Fields
	private String ssn;

	// Constructors
	public Employee(String firstName, String lastName, String ssn) {
		super(firstName, lastName);
		this.ssn = ssn;
	}

	// Getter and setters
	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	// Overrides
	@Override
	public String toString() {
		String maskedSsn = "xxx-xxxx-" + ssn.substring(ssn.length() - 4);

		return super.toString() + "\nSSN: " + maskedSsn;
	}

}
