package my.topcoder;


import java.math.BigInteger;

public class OrderedNim {
	public static String winner(int[] layout) {

		int[][] dp = new int[51][51];
		int n = layout.length;
		if(n==1)return "Alice";
		int i, j, k;
		for (i = 0; i < n; i++)
			dp[i][i] = 0;
		for (k = 2; k <= n; k++) {
			for (i = 0; i < n; i++) {
				j = i + k - 1;
				if (j < n) {
					if (k % 2 == 0) {
						dp[i][j] = Math.max(dp[i + 1][j] + layout[i],
								dp[i][j - 1] + layout[i] - 1);
					} else {
						dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]);
					}
				}
			}
		}
		int result = dp[0][n - 1];
		BigInteger sum = BigInteger.ZERO;
		for (int e : layout) {

			sum = sum.add(BigInteger.valueOf(e));
			
		}
		BigInteger r = BigInteger.valueOf(result);
		r = r.multiply(BigInteger.valueOf(2));
		if (sum.compareTo(r) >= 0) {
			return "Bob";
		} else
			return "Alice";
	}

	public static void main(String[] args) {
		int[] layout = { 2, 1 };
		 System.out.println(winner(layout));
		
	}
}
