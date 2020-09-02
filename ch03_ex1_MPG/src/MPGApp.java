import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class MPGApp {

	public static void main(String[] args) {
		System.out.println("Welcome to the Miles Per Gallon calculator");
		System.out.println(); // print a blank line

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			System.out.print("Enter miles driven: ");
			double miles = sc.nextDouble();

			System.out.print("Enter gallons of gas used: ");
			double gallons = sc.nextDouble();

//          double mpg = miles/gallons;
//          System.out.println("Miles per gallon is " + mpg + ".");

//			long mpg = Math.round(miles / gallons);
//			System.out.println("Miles per gallon is " + mpg + ".");

//			double mpg = miles / gallons;
//			NumberFormat mpgFormat = NumberFormat.getNumberInstance();
//			mpgFormat.setMaximumFractionDigits(2);
//			System.out.println("Miles per gallon is " + mpgFormat.format(mpg) + ".");

			double mpg = miles / gallons;
			BigDecimal mpgBD = new BigDecimal(mpg);
			mpgBD = mpgBD.setScale(2, RoundingMode.HALF_UP);
			System.out.println("Miles per gallon is " + mpgBD.toString() + ".");

			System.out.println();
			System.out.print("Calculate another MPG? (y/n): ");
			choice = sc.next();
			System.out.println();
		}

		System.out.println("Later!");
	}

}
