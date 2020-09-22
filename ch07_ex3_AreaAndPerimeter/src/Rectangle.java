import java.text.NumberFormat;

public class Rectangle {

	// Fields (instance variables) (member variables)
	private double length;
	private double width;

	private static int instanceCount = 0;

	// Constructors
	public Rectangle() {
		this(0, 0);
		// length = 0;
		// width = 0;
	}

	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;

		instanceCount++;
	}

	// Setters and getters
	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	// Helper methods
	public double getArea() {
		return length * width;
	}

	public String getAreaFormatted() {
		NumberFormat number = NumberFormat.getNumberInstance();
		number.setMinimumFractionDigits(3);
		return number.format(this.getArea());
	}

	public static int getInstanceCount() {
		return instanceCount;
	}

}
