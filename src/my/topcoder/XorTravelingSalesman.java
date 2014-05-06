package my.topcoder;
import java.math.*;
import java.util.*;

public class XorTravelingSalesman {

	public int maxProfit(int[] cityValues, String[] roads) {
		int n = cityValues.length;
		char[][] road = new char[n][n];

		for (int i = 0; i < roads.length; i++) {
			road[i] = roads[i].toCharArray();

		}
		int currentCity = 0;
		BigInteger profit = new BigInteger(cityValues[currentCity] + "");

		int[][] dp = new int[n][n];
		Queue<Integer> next = new LinkedList<Integer>();

		while (!next.isEmpty()) {

			currentCity = next.poll();

			for (int i = 0; i < n; ++i) {
				if (road[currentCity][i] == 'Y') {
					next.add(i);
					dp[currentCity][i] = profit.xor(new BigInteger("" + cityValues[i])).intValue();
				} else {
					dp[currentCity][i] = -1;
				}
			}
		}

		return 0;
	}
}
