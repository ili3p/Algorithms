package my.codefu.y11.winter;

public class KeepTheChange {
	public static String getOptimumChange(int amount, int[] types) {

		int n = types.length - 1;
		int[][] c = new int[n + 1][amount + 1];
		int j, k;
		int coin[] = new int[n + 1];
		for (k = 0; k <= amount; ++k) {
			c[0][k] = 0;
		}
		for (j = 1; j <= n; ++j) {
			coin[j] = 0;
			c[j][0] = 0;

			for (k = 1; k <= amount; ++k) {
				if (j == 1) {
					if (k < types[j]) {
						c[j][k] = Integer.MAX_VALUE;
					} else {
						c[j][k] = 1 + c[j][k - types[j]];
					}
				} else {
					if (k < types[j]) {
						c[j][k] = c[j - 1][k];
					} else {
						c[j][k] = Math.min(c[j - 1][k], 1 + c[j][k - types[j]]);
					}
				}
			}
		}

		j = n;
		k = amount;

		while (k > 0 && j > 0) {
			if (c[j][k] == c[j - 1][k]) {
				j = j - 1;
			} else {
				++coin[j];
				k = k - types[j];
			}
		}
		for (int i = 0; i < types.length; ++i) {
			while (coin[i]-- > 0)
				System.out.println(types[i]);
		}

		return "";
	}

	public static void main(String[] args) {
		System.out.println(getOptimumChange(6, new int[] { 1, 3, 5 }));
	}
}
