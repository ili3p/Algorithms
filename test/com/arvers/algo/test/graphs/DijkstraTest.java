package com.arvers.algo.test.graphs;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.arvers.algo.graphs.DijkstraSP;
import com.arvers.algo.graphs.DijkstraSolver;

public class DijkstraTest {
	@Test
	public void test1() {
		try {
			Object[] graph = DijkstraSolver.readGraph(
					"resource/dijkstraData_5.txt", 5);

			int[] expected = new int[] { 1000000, 0, 10, 11, 5, 7 };
			int[] actuals = DijkstraSP.runAlgo(graph, 1);

			Assert.assertArrayEquals(expected, actuals);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test2() {
		try {
			Object[] graph = DijkstraSolver.readGraph(
					"resource/dijkstraData_8.txt", 8);

			int[] expected = new int[] { 1000000, 0, 0, 0, 1, 0, 1, 0, 2 };

			int[] actuals = DijkstraSP.runAlgo(graph, 1);

			Assert.assertArrayEquals(expected, actuals);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testHomework() {
		try {
			Object[] graph = DijkstraSolver.readGraph(
					"resource/dijkstraData_200.txt", 200);

			int[] expected = new int[] { 2599, 2610, 2947, 2052, 2367, 2399,
					2029, 2442, 2505, 3068 };

			int[] result = DijkstraSP.runAlgo(graph, 1);
			int[] printOut = new int[] { 7, 37, 59, 82, 99, 115, 133, 165, 188,
					197 };
			int[] actuals = new int[10];
			for (int i = 0; i < printOut.length; i++) {
				actuals[i] = result[printOut[i]];
			}

			Assert.assertArrayEquals(expected, actuals);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testMyGraph() {
		try {
			Object[] graph = DijkstraSolver.readGraph(
					"resource/dijkstraData_10.txt", 10);

			int[] expected = new int[] { 1000000, 0, 2, 7, 6, 11, 9, 10, 10,
					10, 11 };

			int[] actuals = DijkstraSP.runAlgo(graph, 1);

			Assert.assertArrayEquals(expected, actuals);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAll() {
		try {

			String p = "resource/dijkstra/";
			DecimalFormat d = new DecimalFormat("00000");
			int k = 0, numTests = 5000;
			for (int i = 1; i <= numTests; ++i) {

				Object[] graph = DijkstraSolver.readGraph(
						p + "tests/test" + d.format(i) + ".txt", 200);

				int[] expected = DijkstraSolver.readSolution(p
						+ "solutions/test" + d.format(i) + ".txt.out");
				int[] result = DijkstraSP.runAlgo(graph, 1);

				int[] printOut = new int[] { 7, 37, 59, 82, 99, 115, 133, 165,
						188, 197 };
				int[] actuals = new int[10];

				for (int j = 0; j < 10; ++j) {
					actuals[j] = result[printOut[j]];
				}

				if (Arrays.equals(expected, actuals)) {
					++k;
				}
			}
			System.out.println((k * 100.0) / numTests + " % correct");
			Assert.assertEquals(numTests, k);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
