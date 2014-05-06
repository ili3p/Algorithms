package com.arvers.algo.quicksort.pivot;

public class RandomPivot implements PivotChooser {

	@Override
	public int getPivot(int[] a, int from, int to) {
		return (int) (Math.random() * (to - from)) + from;
	}
}
