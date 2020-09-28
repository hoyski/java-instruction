
public class AreaCalculatorApp {

	private static void printArea(String shapeName, Shape shape) {
		System.out.println("The area of the " + shapeName + " you entered is " + shape.getArea());
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the Area Calculator");

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			String csr = Console.getString("Calculate area of circle, square or rectange? (c/s/r)");

			if (csr.equalsIgnoreCase("c")) {
				double radius = Console.getDouble("Enter radius: ");
				Circle circle = new Circle(radius);
				printArea("Circle", circle);
			} else if (csr.equalsIgnoreCase("s")) {
				double squareWidth = Console.getDouble("Enter width: ");
				Square square = new Square(squareWidth);
				printArea("Square", square);
			}

//			switch (csr) {
//			case "c":
//			case "C":
//				double radius = Console.getDouble("Enter radius: ");
//				Circle circle = new Circle(radius);
//				printArea("Circle", circle);
//
//				break;
//
//			case "s":
//			case "S":
//				double squareWidth = Console.getDouble("Enter width: ");
//				Square square = new Square(squareWidth);
//				printArea("Square", square);
//
//				break;
//
//			case "r":
//			case "R":
//				double rectangleWidth = Console.getDouble("Enter width: ");
//				double height = Console.getDouble("Enter height: ");
//				Rectangle rectangle = new Rectangle(rectangleWidth, height);
//				rectangle.setHeight(17.0);
//				printArea("Rectangle", rectangle);
//
//				break;
//				
//			default:
//				System.out.println("Input is invalid");
//				break;
//			}

			choice = Console.getString("Continue? (y/n) ");
		}
	}

}
