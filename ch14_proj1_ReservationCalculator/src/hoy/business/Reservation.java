package hoy.business;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

/*
public String getPricePerNightFormatted()
public double getTotalPrice()
public String getTotalPriceFormatted()
*/

public class Reservation {

	private final double NIGHTLY_RATE = 145.0;

	// Fields
	private LocalDate arrivalDate;
	private LocalDate departureDate;

	// Constructors
	public Reservation() {
		arrivalDate = null;
		departureDate = null;
	}

	public Reservation(LocalDate arrivalDate, LocalDate departureDate) {
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
	}

	// Getters and setters
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public String getArrivalDateFormatted() {
		DateTimeFormatter dtFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		String dateFormatted = dtFormat.format(arrivalDate);
		return dateFormatted;
	}

	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public String getDepartureDateFormatted() {
		DateTimeFormatter dtFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		String dateFormatted = dtFormat.format(departureDate);
		return dateFormatted;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	// Business methods
	public int getNumberOfNights() {
		return (int) arrivalDate.until(departureDate, ChronoUnit.DAYS);
	}

	public String getPricePerNightFormatted() {
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		return currencyFormat.format(NIGHTLY_RATE);
	}

	public double getTotalPrice() {
		return NIGHTLY_RATE * getNumberOfNights();
	}

	public String getTotalPriceFormatted() {
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		return currencyFormat.format(getTotalPrice());
	}

}
