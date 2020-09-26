
public class Circle extends Shape {
	// Fields
	private double radius;
	
	// Constructors
	public Circle(double radius) {
		this.radius = radius;
	}
	
	// Getters and setters
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	// Overrides
	@Override
	public double getArea() {
		double area = Math.PI * radius * radius;
		return area;
	}
}
