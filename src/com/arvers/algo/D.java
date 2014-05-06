package com.arvers.algo;
import java.util.*;

public class D {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] line = sc.nextLine().split(" ");
		int n = Integer.parseInt(line[0]);
		int[] l = new int[] { Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]) };
		Arrays.sort(l);
		Set<Integer> coins = new HashSet<Integer>();
		for (int i = 0; i < l.length; i++) {
			coins.add(l[i]);
		}
		int[][] dp = new int[n + 1][4];

		Arrays.fill(dp[0], 0);

		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= coins.size(); ++j) {
				int max = Integer.MIN_VALUE;
				for (int c : coins) {
					if (i - c > -1) {
						max = Math.max(max, dp[i - c][j - 1] + 1);
					}
				}
				dp[i][j] = max;
			}
		}

		System.out.println(dp[n][coins.size()]);
	}
}
