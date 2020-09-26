
public class AreaCalculatorApp {

	private static void printArea(String shapeName, Shape shape) {
		System.out.println("The area of the " + shapeName + " you entered is " + shape.getArea());
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Area Calculator");

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			String csr = Console.getString("Calculate area of circle, square or rectange? (c/s/r)");

			switch (csr) {
			case "c":
			case "C":
				double radius = Console.getDouble("Enter radius: ");
				Circle circle = new Circle(radius);
				printArea("Circle", circle);

				break;

			case "s":
			case "S":
				double squareWidth = Console.getDouble("Enter width: ");
				Square square = new Square(squareWidth);
				printArea("Square", square);

				break;

			case "r":
			case "R":
				double rectangleWidth = Console.getDouble("Enter width: ");
				double height = Console.getDouble("Enter height: ");
				Rectangle rectangle = new Rectangle(rectangleWidth, height);
				printArea("Rectangle", rectangle);

				break;
			}

			choice = Console.getString("Continue? (y/n) ");
		}

	}

}
