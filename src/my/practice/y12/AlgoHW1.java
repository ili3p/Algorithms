package my.practice.y12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import my.codejam.y12.round1b.ProblemA;

public class AlgoHW1 {

	public int[] mergeSort(int[] array) {
		int N = array.length;
		int[] sorted = new int[N];

		if (N == 1) {
			return array;
		} else {

			int[] A = mergeSort(Arrays.copyOfRange(array, 0, N / 2));
			int[] B = mergeSort(Arrays.copyOfRange(array, N / 2, N));
			int i = 0, iMax = A.length, j = 0, jMax = B.length;

			for (int k = 0; k < N; ++k) {

				if (i >= iMax) {
					sorted[k] = B[j++];
				} else if (j >= jMax) {
					sorted[k] = A[i++];
				} else {
					sorted[k] = A[i] < B[j] ? A[i++] : B[j++];
				}
			}

			return sorted;
		}
	}

	public static long[][] countInversions(long[] array) {
		int N = array.length;

		if (N == 1) {
			return new long[][] { array, { 0 } };
		} else {

			long[][] A = countInversions(Arrays.copyOfRange(array, 0, N / 2));
			long[][] B = countInversions(Arrays.copyOfRange(array, N / 2, N));
			long[] a = A[0];
			long[] b = B[0];
			long[] s = new long[N];
			long x = A[1][0];
			long y = B[1][0];
			long count = 0;
			int i = 0, iMax = a.length, j = 0, jMax = b.length;
			for (int k = 0; k < N; ++k) {
				if (i >= iMax) {
					s[k] = b[j++];
				} else if (j >= jMax) {
					s[k] = a[i++];
				} else {
					if (a[i] < b[j]) {
						s[k] = a[i++];
					} else {
						s[k] = b[j++];
						count += iMax - i;
					}
				}
			}

			return new long[][] { s, { count + x + y } };
		}
	}

	public static void main(String[] args) {

		try {
			AlgoHW1.runIt();
		} catch (IOException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		}

		// AlgoHW1 hw1 = new AlgoHW1();
		// int[] array = new int[] { 5, 2, 10, 8, 1, 9, 4, 3, 6, 7 };
		// int[] randomArray = getRandomArray(1000000);
		// int[][] cc = hw1.countInversions(randomArray);
		// System.out.println(Arrays.toString(cc[0]));
		// System.out.println(Arrays.toString(cc[1]));

		// int[] sortedRandom = Arrays.copyOf(randomArray, randomArray.length);
		// Arrays.sort(sortedRandom);
		// System.out.println(Arrays.toString(hw1.mergeSort(randomArray)));
		// System.out.println(Arrays.equals(hw1.mergeSort(randomArray),
		// sortedRandom));
	}

	private static void runIt() throws IOException {
		String inFName = "resource/IntegerArray.txt";
		String outFName = "resource/IntegerArray.out";

		Scanner s = new Scanner(new File(inFName));
		long[] array = readArray(s);
		s.close();

		PrintWriter out = new PrintWriter(new File(outFName));
		out.println(AlgoHW1.countInversions(array)[1][0]);

		out.flush();
		out.close();
	}

	private static long[] readArray(Scanner s) throws IOException {
		long[] array = new long[100000];
		for (int i = 0; i < array.length; ++i) {
			array[i] = s.nextInt();
		}
		return array;
	}

	private static int[] getRandomArray(int elements) {
		int[] array = new int[elements];

		for (int i = 0; i < array.length; i++) {
			array[i] = (int) (Math.random() * elements);
		}

		return array;
	}
}
