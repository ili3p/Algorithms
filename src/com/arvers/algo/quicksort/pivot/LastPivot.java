package com.arvers.algo.quicksort.pivot;

public class LastPivot implements PivotChooser {

	@Override
	public int getPivot(int[] a, int from, int to) {
		return to - 1;
	}

}
