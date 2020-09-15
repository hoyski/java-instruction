import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Scanner;

public class TipCalculator {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Tip Calculator");
		System.out.println();

		NumberFormat currency = NumberFormat.getCurrencyInstance();
		NumberFormat percent = NumberFormat.getPercentInstance();

		String choice;

		do {
			System.out.print("Cost of the meal: ");
			BigDecimal cost = sc.nextBigDecimal();

			BigDecimal tipPercent = new BigDecimal("0.15");
			BigDecimal tipIncrement = new BigDecimal("0.05");

			for (int i = 0; i < 3; ++i) {
				// Calculate tip and total
				BigDecimal tipAmount = cost.multiply(tipPercent);
				BigDecimal totalCost = cost.add(tipAmount);

				System.out.println(percent.format(tipPercent));
				System.out.println("Tip amount:   " + currency.format(tipAmount));
				System.out.println("Total amount: " + currency.format(totalCost));
				System.out.println();

				// Increment to next tip amount
				tipPercent = tipPercent.add(tipIncrement);
			}

			System.out.println("Continue? (y/n)");
			choice = sc.next();
		} while (choice.equalsIgnoreCase("y"));

	}

}
