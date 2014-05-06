package com.arvers.algo.test.dp;

import junit.framework.Assert;

import org.junit.Test;

import com.arvers.algo.dp.Knapsack;
import com.arvers.algo.dp.Knapsack.Item;

public class KnapsackTest {

	@Test
	public void testCase1() {
		Item[] items = new Item[3];
		items[0] = new Item(1, 1);
		items[1] = new Item(1, 2);
		items[2] = new Item(1, 1);

		int W = 2;
		System.out.println("Test Case 1 ---");
		int result = Knapsack.solve(items, W);
		System.out.println("---");
		Assert.assertEquals(2, result);
	}

	@Test
	public void testCase2() {
		Item[] items = new Item[5];
		items[0] = new Item(2, 3);
		items[1] = new Item(3, 5);
		items[2] = new Item(4, 2);
		items[3] = new Item(8, 4);
		items[4] = new Item(5, 2);

		int W = 5;
		System.out.println("Test Case 2 ---");
		int result = Knapsack.solve(items, W);
		System.out.println("---");
		Assert.assertEquals(9, result);
	}

	@Test
	public void testCase3() {
		Item[] items = new Item[6];
		items[0] = new Item(2, 3);
		items[1] = new Item(3, 5);
		items[2] = new Item(4, 2);
		items[3] = new Item(20, 6);
		items[4] = new Item(5, 2);
		items[5] = new Item(6, 2);

		int W = 5;
		System.out.println("Test Case 3 ---");
		int result = Knapsack.solve(items, W);
		System.out.println("---");
		Assert.assertEquals(11, result);
	}

	@Test
	public void testCase4() {
		Item[] items = new Item[4];
		items[0] = new Item(10, 5);
		items[1] = new Item(40, 4);
		items[2] = new Item(30, 6);
		items[3] = new Item(50, 3);

		int W = 10;
		System.out.println("Test Case 4 ---");
		int result = Knapsack.solve(items, W);
		System.out.println("---");
		Assert.assertEquals(90, result);
	}

	@Test
	public void testCase5() {
		Item[] items = new Item[5];
		items[0] = new Item(1, 1);
		items[1] = new Item(6, 2);
		items[2] = new Item(18, 5);
		items[3] = new Item(22, 6);
		items[4] = new Item(28, 7);

		int W = 11;
		System.out.println("Test Case 5 ---");
		int result = Knapsack.solve(items, W);
		System.out.println("---");
		Assert.assertEquals(40, result);
	}

	@Test
	public void testCase6() {
		Item[] items = new Item[5];
		items[0] = new Item(1, 1);
		items[1] = new Item(2, 1);
		items[2] = new Item(6, 3);
		items[3] = new Item(7, 4);
		items[4] = new Item(10, 5);

		int W = 8;
		System.out.println("Test Case 6 ---");
		int result = Knapsack.solve(items, W);
		System.out.println("---");
		Assert.assertEquals(16, result);
	}
}
