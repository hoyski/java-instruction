public class ProductDB {

	public static Product getProduct(String productCode) {
		// In a more realistic application, this code would
		// get the data for the product from a file or database
		// For now, this code just uses if/else statements
		// to return the correct product data

		// create the Product object
		Product product;

		if (productCode.equalsIgnoreCase("java")) {
			product = new Product(productCode, "Murach's Java Programming", 57.50);
		} else if (productCode.equalsIgnoreCase("jsp")) {
			product = new Product(productCode, "Murach's Java Servlets and JSP", 57.50);
		} else if (productCode.equalsIgnoreCase("mysql")) {
			product = new Product(productCode, "Murach's MySQL", 54.50);
		} else if (productCode.equalsIgnoreCase("simple")) {
			product = new Product(productCode, "Coding for Dummies", 10.00);
		} else {
			product = new Product();
			product.setCode(productCode);
			product.setDescription("Unknown");
		}

		return product;
	}
}