
public class ContactApp {

	private static void printWelcomeMessage() {
		System.out.println("Welcome to the Contact List application");
		System.out.println();
	}

	private static void printFarewellMessage() {
		System.out.println("Have a fan-friggin-tastic day!");
	}

	public static void main(String[] args) {

		printWelcomeMessage();

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			String firstName = Console.getString("Enter first name: ");
			String lastName = Console.getString("Enter last name:  ");
			String email = Console.getString("Enter email:      ");
			String phone = Console.getString("Enter phone:      ");

			// Contact contact = new Contact();
			// contact.setFirstName(firstName);
			// contact.setLastName(lastName);
			// contact.setEmail(email);
			// contact.setPhone(phone);

			Contact contact = new Contact(firstName, lastName, email, phone);

			System.out.println();
			System.out.println(contact.displayContact());
			System.out.println();

			choice = Console.getString("Continue? (y/n): ");
		}

		printFarewellMessage();
	}

}
