package com.arvers.algo.dp;

public class BinarySearchTree {
	public static void main(String[] args) {
		float[] p = new float[] { .05f, .40f, .08f, .04f, .10f, .10f, .23f };
		int n = p.length;
		float A[][] = new float[n + 1][n + 1];

		for (int s = 0; s <= n - 1; ++s) {
			for (int i = 1; i <= n; ++i) {
				float result = Float.MAX_VALUE;
				float sum = 0.0f;
				if (i + s > n)
					continue;
				for (int k = i; k <= i + s; ++k) {
					sum += p[k - 1];
				}
				for (int r = i; r <= i + s; ++r) {
					float b = (r + 1 > n) ? 0.0f : A[r + 1][i + s];
					result = Math.min(sum + A[i][r - 1] + b, result);
				}
				A[i][i + s] = result;
			}
		}

		System.out.println(A[1][n]);
	}
}
