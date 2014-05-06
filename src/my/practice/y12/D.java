package my.practice.y12;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class D {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[] c = new char[n];
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < c.length; i++) {
			c[i] = String.valueOf(sc.nextInt()).charAt(0);
		}
		Arrays.sort(c);
		if (c[0] != '0') {
			System.out.println("-1");
			System.exit(0);
		}

		for (int i = 0; i < c.length; i++) {
			sb.append(c[i]);
		}
		sb.reverse();
		String maxMax = sb.toString();
		System.out.println(maxMax);
		BigInteger maxInt = new BigInteger(maxMax);
		maxInt = maxInt.subtract(maxInt.mod(new BigInteger("30")));
		String max = "0";
		long div = 30;
		// while (true) {
		// if (check(c, maxInt)) {
		// max = maxInt.toString();
		// break;
		// } else {
		// maxInt = maxInt.subtract(new BigInteger("30"));
		// if (!maxInt.mod(new BigInteger("30")).equals(new BigInteger("0"))) {
		// System.out.println("HHH");
		// }
		//
		// if (maxInt.signum() == -1) {
		// break;
		// }
		// System.out.println(maxInt);
		// }
		// }

		System.out.println();
		System.out.println();
		System.out.println();
		for (int i = 0; i < 100; ++i) {
			for (int j = 0; j < 1000; ++j)
				System.out.print((int) (Math.random() * 10) + " ");
			System.out.println();
		}
		System.out.println(max);
	}

	private static boolean check(char[] c, BigInteger maxInt) {
		if (maxInt.signum() == -1) {
			return false;
		}
		char[] bc = maxInt.toString().toCharArray();
		Arrays.sort(bc);
		if (bc.length > c.length) {
			return false;
		}

		for (int i = 0; i < bc.length; i++) {
			if (c[i] != bc[i]) {
				return false;
			}
		}
		return true;
	}
}
