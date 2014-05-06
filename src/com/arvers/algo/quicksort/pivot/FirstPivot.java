package com.arvers.algo.quicksort.pivot;

public class FirstPivot implements PivotChooser {

	@Override
	public int getPivot(int[] a, int from, int to) {
		return from;
	}

}
