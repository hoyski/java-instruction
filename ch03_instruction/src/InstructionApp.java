import java.math.BigDecimal;
import java.text.NumberFormat;

public class InstructionApp {

	public static void main(String[] args) {
		BigDecimal pi = new BigDecimal("3.1459");
		BigDecimal myBD = new BigDecimal("56.0");

		myBD = myBD.add(pi);

		System.out.println(myBD);
	}
//	public static void main(String[] args) {
//		double percent = 0.506;
//		NumberFormat perFormatter = NumberFormat.getPercentInstance();
//		String formattedPercent = perFormatter.format(percent);
//		System.out.println(formattedPercent);
//	}

//	public static void main(String[] args) {
//		double x = 10.315;
//
//		x = (double) Math.round(x * 100) / 100.0;
//
//		System.out.println(x);
//	}

//	public static void main(String[] args) {
//
//		int parsedInt = Integer.parseInt("123");
//		parsedInt++;
//		System.out.println(parsedInt);
//
//	}

//	public static void main(String[] args) {
//		int i = 86, j = 91;
//		double result = (double) i / (double) j;
//
//		System.out.println(result);
//
//		int k = 4;
//		double d = 4.5;
//		k += (int) d;
//
//		System.out.println(k);
//	}
//	public static void main(String[] args) {
//		double curVal = 5000.0;
//		double monthInv = 100.0;
//		double yearlyIntRate = 0.12;
//
//		curVal = (curVal + monthInv) * (1 + (yearlyIntRate / 12));
//
//		System.out.println(curVal);
//	}
//	public static void main(String[] args) {
//		int x = 5;
//
//		x %= 3;
//
//		System.out.println(x);
//	}
//	
//	public static void main(String[] args) {
//		int x = -10;
//
//		int y = ++x;
//		
//		System.out.println("x = " + x);
//		System.out.println("y = " + y);
//	}

//	public static void main(String[] args) {
//		int x = 7;
//		int y = 3;
//
//		int remainder = x % y;
//		System.out.println(remainder);
//
//		float dblX = 8.0F;
//		float dblY = 3.0F;
//
//		float divResult = dblX / dblY;
//		System.out.println(divResult);
//	}

}
