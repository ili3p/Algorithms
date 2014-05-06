package com.arvers.algo.quicksort.pivot;

public class MedianPivot implements PivotChooser {

	@Override
	public int getPivot(int[] a, int f, int to) {

		int l = to - 1;
		int m = (l - f) / 2 + f;

		if (a[f] < a[m] && a[m] < a[l] || a[l] < a[m] && a[m] < a[f]) {
			return m;
		} else if (a[m] < a[f] && a[f] < a[l] || a[l] < a[f] && a[f] < a[m]) {
			return f;
		} else if (a[m] < a[l] && a[l] < a[f] || a[f] < a[l] && a[l] < a[m]) {
			return l;
		} else {
			return m;
		}
	}
}
