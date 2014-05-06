package com.arvers.algo.test.quicksort;

import junit.framework.Assert;

import org.junit.Test;

import com.arvers.algo.quicksort.pivot.MedianPivot;
import com.arvers.algo.quicksort.pivot.MultiMedianPivot;
import com.arvers.algo.quicksort.pivot.PivotChooser;

public class MedianPivotTest {
	@Test
	public void testMedian() {
		PivotChooser chooser = new MedianPivot();
		int a[] = new int[] { 1, 2, 3, 10, 5, 12, 7, 8 };

		// odd array from 10 to 8 - middle at 12
		int pivot = chooser.getPivot(a, 3, 8);
		Assert.assertEquals(10, a[pivot]);

		// even array from 10 to 7 - middle at 5
		pivot = chooser.getPivot(a, 3, 7);
		Assert.assertEquals(7, a[pivot]);
	}

	@Test
	public void testMultiMedian() {
		MultiMedianPivot chooser = new MultiMedianPivot(5);
		int a[] = new int[] { 1, 2, 3, 10, 5, 6, 7, 8, 9 };
		
		// even array, complete a
		int pivot = chooser.getPivot(a, 0, 10);
		Assert.assertEquals(5, a[pivot]);

		// odd array from 10 to 8 - middle at 7
		pivot = chooser.getPivot(a, 3, 8);
		Assert.assertEquals(7, a[pivot]);

	}
}
