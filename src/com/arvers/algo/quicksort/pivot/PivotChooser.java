package com.arvers.algo.quicksort.pivot;

public interface PivotChooser {

	/**
	 * You should override this method with method that returns the index of the
	 * pivot element in the array a. The index must be in range [from,to).
	 * 
	 * @param a
	 *            the whole array
	 * @param from
	 *            the start of the sub-array
	 * @param to
	 *            the end of the sub-array
	 * @return the index of the pivot element in the array a.
	 */
	int getPivot(int[] a, int from, int to);
}
