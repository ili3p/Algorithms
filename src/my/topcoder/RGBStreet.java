package my.topcoder;

public class RGBStreet {

	public int estimateCost(String[] houses) {
		int[][] dp = new int[houses.length + 1][3];
		dp[0] = new int[] { 0, 0, 0 };

		for (int i = 1; i < houses.length + 1; i++) {
			String[] string = houses[i - 1].split(" ");
			int[] c = new int[3];
			for (int j = 0; j < c.length; j++) {
				c[j] = Integer.parseInt(string[j]);
			}
			dp[i] = new int[3];
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + c[0];
			dp[i][1] = Math.min(dp[i - 1][2], dp[i - 1][0]) + c[1];
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + c[2];
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < dp[houses.length].length; i++) {
			min = Math.min(dp[houses.length][i], min);

		}
		return min;
	}

}
