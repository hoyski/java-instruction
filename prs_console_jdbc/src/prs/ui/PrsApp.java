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
		System.out.println("login - Login");
		System.out.println("logout - Logout");
		System.out.println("prod_la - List all products");
		System.out.println("prod_a - Add a new product");
		System.out.println("user_la - List all users");
		System.out.println("exit - Exit the application");
		System.out.println();

		User authenticatedUser = null;

		String command = "";
		while (!command.equalsIgnoreCase("exit")) {
			command = Console.getString("Enter command: ");

			if (command.equalsIgnoreCase("login")) {
				authenticatedUser = login();

				if (authenticatedUser == null) {
					System.out.println("Username/password not found");
				} else {
					System.out.println("Welcome, " + authenticatedUser.getFirstName());
				}
			} else if (command.equalsIgnoreCase("logout")) {
				authenticatedUser = null;
			} else if (authenticatedUser != null) {

				switch (command.toLowerCase()) {
				case "prod_la":
					listProducts();
					break;

				case "prod_a":
					addProduct();
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
			} else {
				System.out.println("Must login to perform this action");
			}
		}
	}

	private static User login() {
		try {
			String userName = Console.getString("User Name: ");
			String password = Console.getString("Password: ");

			UserDb userDb = new UserDb();
			User user = userDb.authenticateUser(userName, password);

			return user;
		} catch (PrsDataException e) {
			System.err.println("Error logging in. Msg: " + e.getMessage());
			return null;
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

	private static void addProduct() {
		try {
			ProductDb productDb = new ProductDb();
			int vendorId = Console.getInt("Vendor ID: ");
			String partNumber = Console.getString("Part Number: ");
			String name = Console.getString("Name: ");
			double price = Console.getDouble("Price: ");
			String unit = Console.getString("Unit: ");
			String photoPath = Console.getString("Photo Path: ");

			Product product = new Product(0, vendorId, partNumber, name, price, unit, photoPath);

			productDb.add(product);

			System.out.println("Added product named " + product.getName() + " to the database");
			System.out.println();

		} catch (PrsDataException e) {
			System.err.println("Error adding new product. Msg: " + e.getMessage());
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
