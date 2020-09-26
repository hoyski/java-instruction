
public class Square extends Shape {
	// Fields
	private double width;

	// Constructors
	public Square(double width) {
		this.width = width;
	}

	// Getters and setters
	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public double getArea() {
		return Math.pow(width, 2.0);
	}
}
