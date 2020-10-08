import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductApp {

	public static void main(String args[]) {

		Product p = new Product();
		p.setCode("java");
		p.setDescription("Murach's Java");
		p.setPrice(50.0);

		Product completeProduct = new Product("java", "Murach's Java", 50.00);
		Book completeBook = new Book("jsp", "JSP", 5.0, "Joel");

		List<Product> products = new ArrayList<>();
		products.add(completeProduct);
		products.add(completeBook);

		for (Product product : products) {
			System.out.println(product);
		}

//		// display a welcome message
//		System.out.println("Welcome to the Product Viewer");
//		System.out.println();
//
//		// perform 1 or more selections
//		@SuppressWarnings("resource")
//		Scanner sc = new Scanner(System.in);
//		String choice = "y";
//		while (choice.equalsIgnoreCase("y")) {
//			System.out.print("Enter product code: ");
//			String productCode = sc.nextLine(); // read the product code
//
//			// get the Product object
//			Product p = ProductDB.getProduct(productCode);
//
//			// display the output
//			System.out.println();
//			if (p != null) {
//				System.out.println("Description: " + p.toString());
//				System.out.println("Price:       " + p.getPriceFormatted());
//			} else {
//				System.out.println("No product matches this product code.");
//			}
//
//			System.out.println();
//			System.out.println("Product count: " + Product.getCount() + "\n");
//
//			// see if the user wants to continue
//			System.out.print("Continue? (y/n): ");
//			choice = sc.nextLine();
//			System.out.println();
//		}
	}
}
