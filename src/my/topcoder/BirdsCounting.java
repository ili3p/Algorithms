package my.topcoder;

public class BirdsCounting {

	public double computeProbability(int birdsNumber, int caughtPerDay, int daysNumber, int birdsMarked) {

		if (birdsMarked <= caughtPerDay) {
			return 1.0;
		}
		double[][] dp = new double[daysNumber + 1][birdsNumber + 1];

		dp[1][caughtPerDay] = 1.0;

		for (int i = 2; i <= daysNumber; ++i) {

			for (int j = 1; j < birdsNumber; ++j) {

				double sum = 0.0;

				for (int k = 0; k <= caughtPerDay; ++k) {
					if (j - k < 0) {
						break;
					}
					double markProb = 1.0 * (j - k) / birdsNumber;
					double unMarkProb = 1 - markProb;
					sum += dp[i - 1][j - k] * Math.pow(unMarkProb, k) * Math.pow(markProb, caughtPerDay - k);
				}

				dp[i][j] = sum;
			}

		}

		// for (int i = 1; i < daysNumber; ++i) {
		//
		// for (int j = 1; j <= caughtPerDay; ++j) {
		// double sum = 0.0;
		// int c = i * caughtPerDay + j;
		// for (int k = 1; k <= caughtPerDay; ++k) {
		// int index = c - k;
		// double a = 1 - (1.0 * index / birdsNumber);
		// sum += dp[index] * Math.pow(a, c - index);
		// }
		// if (sum > 1.0) {
		// System.err.println("Probability > 1.0");
		// }
		// dp[c] = sum;
		// }
		// }
		// return dp[birdsMarked];

		return dp[daysNumber][birdsMarked];
	}
}
