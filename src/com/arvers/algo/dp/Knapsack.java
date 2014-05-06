package com.arvers.algo.dp;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Knapsack {

	public static class Item {
		protected int v;
		protected int w;

		public Item(int vv, int ww) {
			v = vv;
			w = ww;
		}

		@Override
		public String toString() {
			return "Value: " + v + " Weight: " + w;
		}

	}

	public static void main(String[] args) {

		try {
			// String fileName = "resource/knapsack1.txt";//solution 2493893
			String fileName = "resource/knapsack2.txt";// solution 2595819
			Scanner sc = new Scanner(new File(fileName));
			int W = sc.nextInt();
			int N = sc.nextInt();
			Item[] items = new Item[N];
			int i = 0;
			while (sc.hasNext()) {
				items[i] = new Item(sc.nextInt(), sc.nextInt());
				++i;
			}

			System.out.println(i);
			System.out.println(solve(items, W));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static int solveOptimized(Item[] items, int W) {
		int n = items.length;
		int A[][] = new int[2][W + 1];

		int a = 0;
		int b = 0;
		Item item = null;
		for (int i = 1; i < n + 1; ++i) {
			for (int j = 0; j < W + 1; ++j) {
				item = items[i - 1];
				a = A[(i - 1) % 2][j];
				b = (j - item.w >= 0) ? A[(i - 1) % 2][j - item.w] + item.v : 0;
				A[i % 2][j] = Math.max(a, b);
			}
		}

		int result = Math.max(A[0][W], A[1][W]);
		return result;
	}

	public static int solve(Item[] items, int W) {
		int n = items.length;
		int A[][] = new int[n + 1][W + 1];

		for (int i = 0; i < W; ++i) {
			A[0][i] = 0;
		}
		int a = 0;
		int b = 0;
		Item item = null;
		for (int i = 1; i < n + 1; ++i) {
			for (int j = 0; j < W + 1; ++j) {
				item = items[i - 1];
				a = A[i - 1][j];
				b = (j - item.w >= 0) ? A[i - 1][j - item.w] + item.v : 0;
				A[i][j] = Math.max(a, b);
			}
		}

		int result = A[n][W];

		Set<Integer> included = new HashSet<Integer>();
		int r = n, c = W;
		for (int i = n - 1; i > -1; --i) {
			item = items[i];
			a = i;
			b = c - item.w;
			if (b >= 0) {
				r = A[a][c - item.w];
				if (A[i + 1][c] - r == item.v) {
					included.add(i);
					c -= item.w;
				}
			}
		}
		System.out.println(included);
		return result;
	}
}
