
public class Contact {
	// Fields
	private String firstName;
	private String lastName;
	private String email;
	private String phone;

	// Constructors
	public Contact() {
		this("", "", "", "");
	}

	public Contact(String firstName, String lastName, String email, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	// Helper methods
	public String displayContact() {
		String retVal = "---------------------------------------------\n"
				+ "---- Current Contact ------------------------\n" + "---------------------------------------------\n"
				+ "Name:               " + this.firstName + " " + this.lastName + "\n" + "Email Address:      "
				+ this.email + "\n" + "Phone Number:       " + this.phone + "\n"
				+ "---------------------------------------------";

		return retVal;
	}
}
