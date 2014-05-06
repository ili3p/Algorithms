package com.arvers.algo;

public class ForTesting {

	private static int col;
	private static int row;

	public static void main(String[] args) {

		int[] a = { 2, 3, 4, 3, 5, 7 };

		int[] b = { 3, 2, 4, 5, 6, 8 };

		int numARows = 2;
		int numAColumns = 3;
		int numBRows = 3;
		int numBColumns = 2;

		int numCRows = numARows;
		int numCColumns = numBColumns;

		int[] c = new int[numCRows * numCColumns];

		

		// int blockX = (int) Math.ceil(numCColumns / 16.0);
		// int blockY = (int) Math.ceil(numCRows / 16.0);

		int blockX = 3;
		int blockY = 3;

		for (int i = 0; i < blockY; ++i) {
			for (int j = 0; j < blockX; ++j) {
				row = i;
				col = j;
				
				matrixMultiply(a, b, c, numARows, numAColumns, numBRows, numBColumns, numCRows, numCColumns);
			}
		}

		for (int i = 0; i < numCRows; ++i) {
			for (int j = 0; j < numCColumns; ++j) {
				System.out.println(c[i * numCColumns + j]);
			}
		}
	}

	private static void matrixMultiply(int[] A, int[] B, int[] C, int numARows, int numAColumns, int numBRows, int numBColumns, int numCRows, int numCColumns) {
		int Row = row;
		int Col = col;

		if ((Row < numCRows) && (Col < numCColumns)) {
			int pValue = 0;

			for (int k = 0; k < numAColumns; ++k) {
				pValue += A[Row * numAColumns + k] * B[k * numBColumns + Col];
			}
			C[row * numCColumns + Col] = pValue;
		}
	}
}
