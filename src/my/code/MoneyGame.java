package my.code;

public class MoneyGame {

	/*
	 * public static int maxMoney(int[] coins) {
	 * 
	 * 
	 * return 0; }
	 */

	public static int maxMoney(int[] coins) {
		
		int n = coins.length;
		int[][] dp = new int[n+1][n+1];
		int i, j, k;

		for (i = 0; i < n; i++)
			dp[i][i] = 0;

		for (k = 2; k <= n; k++) {

			for (i = 0; i < n; i++) {

				j = i + k - 1;

				if (j < n) {
					if (k % 2 == 0) {
						dp[i][j] = Math.max(dp[i + 1][j] + coins[i],
								dp[i][j - 1] + coins[j]);
					} else {
						dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]);
					}
				}
System.out.println("step:"+i);
				for (int g = 0; g < n+1; ++g) {
					for (int h = 0; h < n+1; ++h)
						System.out.print(dp[g][h] + ",");
					System.out.println();
				}
			}
		}

		return dp[0][n - 1];
	}

	/*
	 * package my.code;
	 * 
	 * public class MoneyGame { public static int maxMoney(int[] coins) { int
	 * sum[][] = new int[20][20]; int best[][] = new int[20][20];
	 * 
	 * for (int i = 0; i < 20; i++) for (int j = 0; j < 20; j++) { sum[i][j] =
	 * best[i][j] = 0; }
	 * 
	 * for (int i = 0; i < coins.length; i++) { sum[i][i] = coins[i]; best[i][i]
	 * = coins[i]; }
	 * 
	 * for (int i = 0; i < coins.length; i++) for (int j = i + 1; j <
	 * coins.length; j++) { sum[i][j] = sum[i][j - 1] + coins[j]; //
	 * System.out.println(i + "  " + j + "  " + sum[i][j]); }
	 * 
	 * // length if board for (int l = 1; l < coins.length; l++) for (int i = 0;
	 * i + l < coins.length; i++) { best[i][i + l] = Math.max(sum[i][i + l] -
	 * best[i + 1][i + l], sum[i][i + l] - best[i][i + l - 1]); }
	 * 
	 * return best[0][coins.length - 1]; }
	 */
	public static void main(String[] args) {

		int[] a = { 5,2,3,8,6,8,9,11,23 };
		System.out.println(maxMoney(a));
	}
}