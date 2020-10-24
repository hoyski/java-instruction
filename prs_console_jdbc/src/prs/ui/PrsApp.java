package prs.ui;

import java.util.List;

import prs.business.Product;
import prs.business.User;
import prs.db.ProductDb;
import prs.db.UserDb;
import prs.exception.PrsDataException;

public class PrsApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the PRS App");
		System.out.println();

		System.out.println("COMMANDS");
		System.out.println("prod_la - List all products");
		System.out.println("user_la - List all users");
		System.out.println("exit - Exit the application");
		System.out.println();

		String command = "";
		while (!command.equalsIgnoreCase("exit")) {
			command = Console.getString("Enter command: ");

			switch (command.toLowerCase()) {
			case "prod_la":
				listProducts();
				break;

			case "user_la":
				listUsers();
				break;

			case "exit":
				// Nothing to do
				break;

			default:
				System.out.println("Invalid command");
				break;
			}
		}
	}

	private static void listProducts() {
		try {
			ProductDb productDb = new ProductDb();
			List<Product> products = productDb.getAll();

			System.out.println("Products:");
			for (Product product : products) {
				System.out.println(product);
			}
			System.out.println();
		} catch (PrsDataException e) {
			System.err.println("Couldn't retrieve products. Msg: " + e.getMessage());
		}
	}

	private static void listUsers() {
		try {
			UserDb userDb = new UserDb();
			List<User> users = userDb.getAll();

			System.out.println("Users:");
			for (User user : users) {
				System.out.println(user);
			}
			System.out.println();
		} catch (PrsDataException e) {
			System.err.println("Couldn't retrieve users. Msg: " + e.getMessage());
		}
	}

}
