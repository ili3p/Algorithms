package com.arvers.algo.dp;

public class WIS {
	public static void main(String[] args) {
		int[] graph = { 1, 4, 5, 4 };
		int result = solve(graph);
		System.out.println(result);
	}

	private static int solve(int[] graph) {
		int[] A = new int[graph.length + 1];
		A[0] = 0;
		A[1] = graph[0];

		for (int i = 2; i < A.length; ++i) {
			A[i] = Math.max(A[i - 1], A[i - 2] + graph[i - 1]);
		}
		
		return A[A.length - 1];
	}
}
