package old.code;

public class LCS {
	public static int lcs(String x, String y) {

		int n = x.length();
		int m = y.length();
		int[][] table = new int[n + 1][m + 1];
		for (int i = 0; i <= n; ++i)
			for (int j = 0; j <= m; ++j) {
				if (i == 0 || j == 0)
					table[i][j] = 0;
				else if ((x.charAt(i - 1)) == (y.charAt(j - 1)))
					table[i][j] = table[i - 1][j - 1] + 1;
				else
					table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
			}

		return table[n][m];
	}

	public static int lis_lenght(int[] a) {

		int max = 0;
		int n = a.length;
		int[] q = new int[n];
		for (int k = 0; k < n; ++k) {
			max = 0;
			for (int j = 0; j <= k - 1; ++j) {
				if (a[k] >= a[j])
					if (q[j] > max)
						max = q[j];
			}
			q[k] = max + 1;

		}
		max = 0;
		for (int i = 0; i < n; ++i)
			if (q[i] > max)
				max = q[i];

		return max;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] x = { -7, 98, 2, 2, 8, 6, 2, 3, 9 };
		System.out.println(lis_lenght(x));

	}

}
