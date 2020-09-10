import java.text.NumberFormat;

public class ReferenceTypeDemo {

	public static void main(String[] args) {

		int x = 5;
		int y = x;

		System.out.println("Before: x = " + x + ". y = " + y);

		x++;

		System.out.println("After : x = " + x + ". y = " + y);

		System.out.println("\n******************************************\n");

		NumberFormat nfX = NumberFormat.getPercentInstance();
		NumberFormat nfY = nfX;

		System.out.println("Before: getMaximumFractionDigits for nxF = " + nfX.getMaximumFractionDigits() + ". nfY = "
				+ nfY.getMaximumFractionDigits());

		nfX.setMaximumFractionDigits(5);

		System.out.println("After : getMaximumFractionDigits for nxF = " + nfX.getMaximumFractionDigits() + ". nfY = "
				+ nfY.getMaximumFractionDigits());

	}

}
