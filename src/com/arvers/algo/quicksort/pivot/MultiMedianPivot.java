package com.arvers.algo.quicksort.pivot;

import java.util.Arrays;

public class MultiMedianPivot implements PivotChooser {

	private static boolean DEBUG = false;

	/**
	 * The number of sample elements to pick the median from.
	 */
	private int numberOfSamples;

	/**
	 * MultiMedian with m number of sample elements to pick the median from.
	 * 
	 * @param m
	 *            the number of samples
	 */
	public MultiMedianPivot(int m) {
		setNumberOfSamples(m);
	}

	/**
	 * Get {@link #numberOfSamples} equally distributed sample elements and
	 * return the median of them.
	 * 
	 * @param a
	 *            array to pick pivot from
	 * @param from
	 *            start of the sub-array
	 * @param to
	 *            end of the sub-array
	 */
	@Override
	public int getPivot(int[] a, int from, int to) {

		int n = to - from;
		int[] b = new int[numberOfSamples];

		if (n > numberOfSamples) {

			float part = (float) (n / (numberOfSamples * 1.0));

			for (int i = 0; i < numberOfSamples; ++i) {
				b[i] = a[(int) (part * i + from)];
			}
		} else {
			b = Arrays.copyOfRange(a, from, to);
		}

		if (DEBUG) {
			System.out.println("a: "
					+ Arrays.toString(Arrays.copyOfRange(a, from, to)));
			System.out.println("b: " + Arrays.toString(b));
		}

		int mVal = getMedianValue(b);
		int median = indexOf(mVal, a, from, to);

		if (DEBUG) {
			System.out.println("Median value: " + mVal);
			System.out.println("Median index in a:" + median);
		}

		return median;
	}

	private int getMedianValue(int[] b) {
		Arrays.sort(b);
		return b[(b.length - 1) / 2];
	}

	private int indexOf(int mVal, int[] a, int from, int to) {

		for (int i = from; i < to; ++i) {
			if (mVal == a[i]) {
				return i;
			}
		}

		return -1;
	}

	public int getNumberOfSamples() {
		return numberOfSamples;
	}

	public void setNumberOfSamples(int mNumberOfSamples) {
		this.numberOfSamples = mNumberOfSamples;
	}
}
