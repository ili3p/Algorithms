package my.code;

import java.util.ArrayList;
import java.util.List;

public class ForTesting {
	public static void main(String[] args) {

		List<Elephant> elephants = new ArrayList<Elephant>();
		String[] strings = { "6008 1300", "6000 2100", "500 2000", "1000 4000",
				"1100 3000", "6000 2000", "8000 1400", "6000 1200",
				"2000 1900", "1000 4000", "1100 3000", "6000 2000" };
		for (String line : strings) {
			int weight = Integer.parseInt(line.split(" ")[0]);
			int IQ = Integer.parseInt(line.split(" ")[1]);
			Elephant e = new Elephant(weight, IQ);
			elephants.add(e);

		}
		Solver solve = new Solver();

		int [] m = solve.getResult(elephants.toArray(new Elephant[0]));
		for(int i=0;i<m.length;++i)
		System.out.println(i);
	}

	public static class Solver {

		public boolean cond(Elephant e1, Elephant e2) {

			return (e1.weight > e2.weight && e1.IQ < e2.IQ);
		}

		public int[] getResult(Elephant[] elephants) {

			int n = elephants.length;
			int[][] dp = new int[n][2];
			dp[0][0] = 1;
			dp[0][1] = 1;

			for (int i = 1; i < n; ++i) {

				if (i == 1 && cond(elephants[1], elephants[0])) {

					dp[1][0] = dp[0][0] + 1;
					dp[1][1] = 1;

				} else if (cond(elephants[i], elephants[i - 1])) {

					dp[i][0] = dp[i - 1][0] + 1;
					dp[i][1] = i;
				} else {

					dp[i][0] = dp[i - 1][0];
					dp[i][1] = dp[i - 1][1];
				}
			}
			return dp[n - 1];
		}

	}

	private static class Elephant {

		int weight;
		int IQ;

		public Elephant(int weight, int iQ) {
			super();
			this.weight = weight;
			IQ = iQ;
		}
@Override
public String toString() {

	return String.valueOf(weight)+" "+String.valueOf(IQ)+"\n";
}
	}

	public static int factoriel(int n) {

		int[] r = new int[n + 1];
		r[1] = 1;
		for (int i = 2; i <= n; ++i)
			r[i] = i * r[i - 1];
		return r[n];
	}

	public static int recursiveFactoriel(int n) {
		if (n == 1)
			return 1;
		return n * recursiveFactoriel(n - 1);
	}

	public static void binominal() {
		int n = 4; /* computer n choose m */

		int i, j; /* counters */
		long[][] bc = new long[5][5]; /* table of binomial coefficients */
		for (i = 0; i <= n; i++)
			bc[i][0] = 1;
		for (j = 0; j <= n; j++)
			bc[j][j] = 1;
		for (i = 1; i <= n; i++)
			for (j = 1; j < i; j++)
				bc[i][j] = bc[i - 1][j - 1] + bc[i - 1][j];

	}
}
