package my.topcoder;

public class Xosceles {
	public static String[] draw(int xCount) {

		int n;
		int An;
		String[] result ;

		n = (int) Math.sqrt(xCount);
		An = (n - 1) * 2 + 1;
		if (n * n != xCount) {
			n = ((int) (-1 + Math.sqrt(1 + 4 * xCount))) / 2;

			An = (n - 1) * 2 + 2;

			if (n * (n + 1) != xCount)
				return null;
		}

		result = new String[n];
		int j = n - 1;
		for (int i = An - 1; j >= 0; --i) {
			char[] x = new char[An];
			for (int m = 0; m < An; ++m) {
				x[m] = '.';
			}
			for (int k = An - 1 - i; k < i + 1; ++k)
				x[k] = 'X';

			result[j] = String.valueOf(x);
			--j;

		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(draw(4));
	}
}
