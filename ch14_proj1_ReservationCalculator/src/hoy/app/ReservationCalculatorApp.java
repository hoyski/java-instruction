package hoy.app;

import java.time.LocalDate;

import hoy.business.Reservation;

public class ReservationCalculatorApp {

	public static void main(String[] args) {
		System.out.println("Reservation Calculator");

		String choice = "y";
		while (choice.equalsIgnoreCase("y")) {

			LocalDate arrivalDate = Console.getLocalDate("arrival");
			LocalDate departureDate = Console.getLocalDate("departure");

			Reservation res = new Reservation(arrivalDate, departureDate);

			System.out.println("Arrival Date: " + res.getArrivalDateFormatted());
			System.out.println("Depature Date: " + res.getDepartureDateFormatted());
			System.out.println("Price: " + res.getPricePerNightFormatted());
			System.out.println(
					"Total Price: " + res.getTotalPriceFormatted() + " for " + res.getNumberOfNights() + " nights");
			System.out.println();

			choice = Console.getString("Continue? (y/n)");
		}

	}

}
