package com.arvers.algo.quicksort;

import java.util.Arrays;

import com.arvers.algo.quicksort.pivot.PivotChooser;

/**
 * QucikSort with random pivot.
 * 
 * @author Ilija
 * 
 */
public class QuickSort {

	public static boolean DEBUG = true;

	public static int sort(int[] a, int from, int to, PivotChooser chooser) {

		int n = to - from;
		if (n > 1) {

			if (DEBUG) {
				System.out.println("Sub-array being sorted: ");
				System.out.println(Arrays.toString(Arrays.copyOfRange(a, from,
						to)));
			}

			int pivot = chooser.getPivot(a, from, to);

			swap(a, from, pivot);
			pivot = from;

			int i = from + 1;

			for (int j = from + 1; j < to; ++j) {

				if (a[j] < a[pivot]) {
					swap(a, i, j);
					++i;
				}
			}
			swap(a, i - 1, pivot);

			if (DEBUG) {
				System.out.println("Pivot chosen a[" + pivot + "]=" + a[pivot]);
				System.out.println("Current state of a: " + Arrays.toString(a));
				int[] leftA = Arrays.copyOfRange(a, from, i - 1);
				int[] rightA = Arrays.copyOfRange(a, i, to);
				System.out.println("Left of pivot" + Arrays.toString(leftA));
				System.out.println("Right of pivot" + Arrays.toString(rightA));
			}

			int comparisons = n - 1;
			comparisons += sort(a, from, i - 1, chooser);
			comparisons += sort(a, i, to, chooser);

			return comparisons;
		}

		return 0;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
