import java.text.NumberFormat;

public class Product {

	// Fields, aka member variables, aka instance variables
	private String code;
	private String description;
	private double price;

	// Static variables
	private static int instanceCount = 0;

	// Constructors
	public Product() {
		code = "";
		description = "";
		price = 0;

		instanceCount++;
	}

	public Product(String codeParam, String descParam, double priceParam) {
		code = codeParam;
		description = descParam;
		price = priceParam;

		instanceCount++;
	}

	// Setters and getters
	public void setCode(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	// Helper methods
	public String getPriceFormatted() {
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		return currency.format(price);
	}

	public String getPriceNumberFormatted() {
		NumberFormat number = NumberFormat.getNumberInstance();
		number.setMaximumFractionDigits(2);
		number.setMinimumFractionDigits(2);
		return number.format(price);
	}

	// Static methods
	public static int getInstanceCount() {
		return instanceCount;
	}
}