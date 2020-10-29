import java.util.Scanner;
import java.text.NumberFormat;

public class FutureValueApp {

	public static void main(String[] args) {
		System.out.println("The Future Value Calculator\n");

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {
			// get the input from the user
			System.out.print("Enter monthly investment:   ");
			double monthlyInvestment = sc.nextDouble();
			System.out.print("Enter number of years:      ");
			int years = sc.nextInt();

			NumberFormat percentFormatter = NumberFormat.getPercentInstance();
			percentFormatter.setMinimumFractionDigits(1);
			percentFormatter.setMaximumFractionDigits(1);

			// Printer header row
			System.out.print("Year");
			for (double intRate = 0.05; intRate <= 0.065; intRate += 0.005) {
				System.out.print("\t" + percentFormatter.format(intRate));
			}
			System.out.println();

			// Loop thru the years: 1 to "years"
			for (int year = 1; year <= years; ++year) {
				System.out.print(year);
				// Loop thru the rates: 0.05 to 0.065 by 0.005
				for (double intRate = 0.05; intRate <= 0.065; intRate += 0.005) {
					// Convert the annual interest rate to monthly by dividing by 12
					double monthlyInterestRate = intRate / 12;
					// Calc the number of months as current year (from the outer loop) times 12
					int months = year * 12;
					// Do the calculation from the previous code
					double futureValue = 0.0;
					for (int i = 1; i <= months; i++) {
						futureValue = (futureValue + monthlyInvestment) * (1 + monthlyInterestRate);
					}

					NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

					System.out.print("\t" + currencyFormatter.format(futureValue));
				}
				System.out.println();
			}
			System.out.println();

			// see if the user wants to continue
			System.out.print("Continue? (y/n): ");
			choice = sc.next();
			System.out.println();
		}
		System.out.println("Bye!");
	}
}