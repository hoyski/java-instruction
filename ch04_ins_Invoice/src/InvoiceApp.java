
public class InvoiceApp {

	public static void main(String[] args) {
		String customerType = "r";
		double subtotal = 50.0;

		double discountPercent = 0.0;

		switch (customerType) {
		case "r":
		case "R":
			System.out.println("In case r/R");
			if (subtotal < 100) {
				discountPercent = 0.0;
			} else if (subtotal >= 100 && subtotal < 250) {
				discountPercent = 0.1;
			} else if (subtotal >= 250.0) {
				discountPercent = 0.2;
			}
			break;
		case "c":
		case "C":
			System.out.println("In case c/C");
			if (subtotal < 250) {
				discountPercent = 0.2;
			} else if (subtotal >= 250) {
				discountPercent = 0.3;
			}
			break;
		default:
			System.out.println("In default case");
			discountPercent = 0.1;
			break;
		}

		System.out.println("discountPercent = " + discountPercent);
	}

}
