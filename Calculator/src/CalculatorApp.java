import java.util.Scanner;

public class CalculatorApp {

	public static void main(String[] args) {
		System.out.println("Welcome to calc");

		Scanner sc = new Scanner(System.in);

		boolean keepGoing = true;

		while (keepGoing) {
			System.out.print("Enter an integer: ");
			int firstOperand = sc.nextInt();

			System.out.print("Enter another integer: ");
			int secondOperand = sc.nextInt();

			System.out.print("Enter an operation (+ or -): ");
			String operator = sc.next();

			int result = 0;

			if (operator.equals("+")) {
				result = firstOperand + secondOperand;
			} else if (operator.equals("-")) {
				result = firstOperand - secondOperand;
			}

			System.out.println(firstOperand + " " + operator + " " + secondOperand + " = " + result);
			System.out.println(); // Blank line

			System.out.println("Continue? (y/n) ");
			String continueAnswer = sc.next();

			keepGoing = continueAnswer.equalsIgnoreCase(continueAnswer);
		}

		System.out.println("Later!");

		sc.close();
	}

}
