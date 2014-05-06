package com.arvers.algo.graphs;

import java.io.*;
import java.util.*;

public class AllPairs {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("resource/g3.txt"));

			int n = sc.nextInt();
			int numEdges = sc.nextInt();
			Map<String, Integer> map = new HashMap<String, Integer>(n);

			while (sc.hasNext()) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				int cost = sc.nextInt();

				map.put(n1 + "," + n2, cost);
			}
			sc.close();

			if (numEdges != map.size()) {
				System.out.println("NumEdges different!");
				System.out.println(numEdges);
				System.out.println(map.size());
			}

			int[][][] A = new int[n + 1][n + 1][2];

			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= n; ++j) {
					String e = i + "," + j;
					A[i][j][0] = (i == j) ? 0 : (map.containsKey(e) ? map.get(e) : Integer.MAX_VALUE);
				}
			}
			System.out.println(n);
			for (int k = 1; k <= n; ++k) {
				for (int i = 1; i <= n; ++i) {
					for (int j = 1; j <= n; ++j) {
						int l = A[i][k][(k - 1) % 2];
						int r = A[k][j][(k - 1) % 2];
						int s = (l == Integer.MAX_VALUE || r == Integer.MAX_VALUE) ? Integer.MAX_VALUE : l + r;
						A[i][j][k % 2] = Math.min(A[i][j][(k - 1) % 2], s);
					}
				}
				double p = (100.0 * k / n);
				if (p % 10 == 0) {
					System.out.println("Running algorithm: " + p + " %");// 1000000
				}
			}

			for (int i = 1; i <= n; ++i) {
				if (A[i][i][n % 2] < 0) {
					System.out.println("Has negative-cost cycle");
					break;
				}
			}
			int min = Integer.MAX_VALUE;
			for (int i = 1; i <= n; ++i) {
				for (int j = 1; j <= n; ++j) {
					min = Math.min(A[i][j][n % 2], min);
				}
			}
			System.out.println(min);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
