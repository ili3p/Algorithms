package my.practice.y12;

import java.util.Arrays;
import java.util.Scanner;

public class SpojInversions {
	public static int[][] countInversions(int[] array) {
		int N = array.length;

		if (N == 1) {
			return new int[][] { array, { 0 } };
		} else {

			int[][] A = countInversions(Arrays.copyOfRange(array, 0, N / 2));
			int[][] B = countInversions(Arrays.copyOfRange(array, N / 2, N));
			int[] a = A[0];
			int[] b = B[0];
			int[] s = new int[N];
			int x = A[1][0];
			int y = B[1][0];
			int count = 0;
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
						if (a[i] != b[j]) {
							count += iMax - i;
						}
						s[k] = b[j++];
					}
				}
			}

			return new int[][] { s, { count + x + y } };
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while (t != 0) {
			int[] array = SpojInversions.readArray(s, t);
			System.out.println(Arrays.toString(array));
			int c = SpojInversions.countInversions(array)[1][0];
			System.out.println(c);
			t = s.nextInt();
		}

	}

	public static int[] readArray(Scanner s, int N) {

		int[] array = new int[N];

		for (int i = 0; i < N; ++i) {
			array[i] = s.nextInt();
		}

		return array;
	}
}
