package com.arvers.algo.test.quicksort;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.arvers.algo.quicksort.QuickSort;
import com.arvers.algo.quicksort.pivot.FirstPivot;
import com.arvers.algo.quicksort.pivot.LastPivot;
import com.arvers.algo.quicksort.pivot.MedianPivot;
import com.arvers.algo.quicksort.pivot.MultiMedianPivot;
import com.arvers.algo.quicksort.pivot.RandomPivot;

public class QuickSortTest {

	@Test
	public void firstPivotTest() {
		int[] a = new int[] { 4, 2, 7, 5, 6, 8, 9, 1, 3 };
		int[] expected = Arrays.copyOf(a, a.length);

		Arrays.sort(expected);
		QuickSort.sort(a, 0, a.length, new FirstPivot());

		Assert.assertArrayEquals(expected, a);
	}

	@Test
	public void lastPivotTest() {
		int[] a = new int[] { 4, 2, 7, 5, 6, 8, 9, 1, 3 };
		int[] expected = Arrays.copyOf(a, a.length);

		Arrays.sort(expected);
		QuickSort.sort(a, 0, a.length, new LastPivot());

		Assert.assertArrayEquals(expected, a);
	}

	@Test
	public void randomPivotTest() {
		int[] a = new int[] { 4, 2, 7, 5, 6, 8, 9, 1, 3 };
		int[] expected = Arrays.copyOf(a, a.length);

		Arrays.sort(expected);
		QuickSort.sort(a, 0, a.length, new RandomPivot());

		Assert.assertArrayEquals(expected, a);
	}

	@Test
	public void medianOddPivotTest() {
		int[] a = new int[] { 4, 2, 7, 5, 6, 8, 1, 3, 9 };
		int[] expected = Arrays.copyOf(a, a.length);

		Arrays.sort(expected);
		QuickSort.sort(a, 0, a.length, new MedianPivot());

		Assert.assertArrayEquals(expected, a);
	}
	
	@Test
	public void medianEvenPivotTest() {
		int[] a = new int[] { 4, 2, 7, 5, 6, 8, 1, 3 };
		int[] expected = Arrays.copyOf(a, a.length);

		Arrays.sort(expected);
		QuickSort.sort(a, 0, a.length, new MedianPivot());

		Assert.assertArrayEquals(expected, a);
	}
	
	
	@Test
	public void multiMedianOddPivotTest() {
		int[] a = new int[] { 4, 2, 7, 5, 6, 8, 1, 3, 9 };
		int[] expected = Arrays.copyOf(a, a.length);

		Arrays.sort(expected);
		QuickSort.sort(a, 0, a.length, new MultiMedianPivot(3));

		Assert.assertArrayEquals(expected, a);
	}
	
	@Test
	public void multiMedianEvenPivotTest() {
		int[] a = new int[] { 4, 2, 7, 5, 6, 8, 1, 3 };
		int[] expected = Arrays.copyOf(a, a.length);

		Arrays.sort(expected);
		QuickSort.sort(a, 0, a.length, new MultiMedianPivot(3));

		Assert.assertArrayEquals(expected, a);
	}

	@Test
	public void arrayWithNoDuplicates1() {
		int[] a = new int[] { 4, 2, 7, 5, 6, 8, 9, 1, 3 };
		int[] expected = Arrays.copyOf(a, a.length);

		Arrays.sort(expected);
		QuickSort.sort(a, 0, a.length, new FirstPivot());

		Assert.assertArrayEquals(expected, a);
	}

	@Test
	public void arrayWithNoDuplicates2() {
		int[] a = new int[] { 3, 1, 12, 4, 6, 7, 23, 2, 5, };
		int[] expected = Arrays.copyOf(a, a.length);

		Arrays.sort(expected);
		QuickSort.sort(a, 0, a.length, new FirstPivot());

		Assert.assertArrayEquals(expected, a);
	}

	@Test
	public void arrayWithDuplicates() {
		int[] a = new int[] { 3, 23, 2, 23, 45, 6, 7, 8, 2, 23, 4, 5 };
		int[] expected = Arrays.copyOf(a, a.length);

		Arrays.sort(expected);
		QuickSort.sort(a, 0, a.length, new FirstPivot());

		Assert.assertArrayEquals(expected, a);
	}

}