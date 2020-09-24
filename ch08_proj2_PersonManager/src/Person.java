public class Person {

	// Fields
	private String firstName;
	private String lastName;

	// Constructors
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	// Getters and setters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// Overrides
	@Override
	public String toString() {
		return "Name: " + firstName + " " + lastName;
	}

}
