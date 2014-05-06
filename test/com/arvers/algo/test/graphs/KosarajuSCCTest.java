package com.arvers.algo.test.graphs;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.Assert;
import org.junit.Test;

import com.arvers.algo.graphs.KosarajuSCC;
import com.arvers.algo.graphs.KosarajuSolver;

public class KosarajuSCCTest {

	@SuppressWarnings("unchecked")
	@Test
	public void kosarajuTest1() {
		Object[] graph = new Object[9];

		graph[0] = new LinkedList<Integer>();
		((LinkedList<Integer>) graph[0]).add(2); // 1 -> 3

		graph[1] = new LinkedList<Integer>();
		((LinkedList<Integer>) graph[1]).add(0); // 2 -> 1

		graph[2] = new LinkedList<Integer>();
		((LinkedList<Integer>) graph[2]).add(1);// 3 -> 2

		graph[3] = new LinkedList<Integer>();
		((LinkedList<Integer>) graph[3]).add(1); // 4 -> 2
		((LinkedList<Integer>) graph[3]).add(4);// 4 -> 5

		graph[4] = new LinkedList<Integer>();
		((LinkedList<Integer>) graph[4]).add(5); // 5 -> 6

		graph[5] = new LinkedList<Integer>();
		((LinkedList<Integer>) graph[5]).add(3); // 6 -> 4

		graph[6] = new LinkedList<Integer>();
		((LinkedList<Integer>) graph[6]).add(5); // 7 -> 6
		((LinkedList<Integer>) graph[6]).add(8); // 7 -> 9

		graph[7] = new LinkedList<Integer>();
		((LinkedList<Integer>) graph[7]).add(6); // 8 -> 7

		graph[8] = new LinkedList<Integer>();
		((LinkedList<Integer>) graph[8]).add(7);// 9 -> 8

		KosarajuSCC solver = new KosarajuSCC(graph);
		int[] l = solver.run();

		Assert.assertArrayEquals(new int[] { 2, 2, 2, 5, 5, 5, 8, 8, 8 }, l);
	}

	@Test
	public void kosarajuWithReading() {
		int[] l = new int[1];
		try {
			l = KosarajuSolver.runAlgo("resource/SCC_small.txt", 9);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertArrayEquals(new int[] { 2, 2, 2, 5, 5, 5, 8, 8, 8 }, l);
	}

	@Test
	public void kosarajuWithReading2() {
		int[] l = new int[1];
		try {
			KosarajuSolver.DEBUG = true;
			l = KosarajuSolver.runAlgo("resource/SCC_small_13.txt", 13);
			System.out.println(Arrays.toString(l));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Assert.assertArrayEquals(new int[] { 6, 7, 8, 6, 7, 8, 6, 7, 8, 11, 11,
				11, 12 }, l);
	}

	@SuppressWarnings("unchecked")
	@Test
	public void reverseGraphTest() {

		try {
			Object[] graph = KosarajuSolver.readGraph("resource/SCC.txt",
					875714);
			for (int i = 0; i < graph.length; i++) {
				LinkedList<Integer> list = ((LinkedList<Integer>) graph[i]);
				if (list == null) {
					list = new LinkedList<Integer>();
					graph[i] = list;
				}
				Collections.sort(list);
			}
			KosarajuSCC solver = new KosarajuSCC(graph);
			System.out.println("1st reverse");
			Object[] newGraph = solver.reverseGraph(graph);
			System.out.println("2nd reverse");
			Object[] newNewGraph = solver.reverseGraph(newGraph);
			for (int i = 0; i < newNewGraph.length; i++) {
				LinkedList<Integer> list = ((LinkedList<Integer>) newNewGraph[i]);
				if (list == null) {
					list = new LinkedList<Integer>();
					newNewGraph[i] = list;
				}
				Collections.sort(list);
			}
			Assert.assertArrayEquals(newNewGraph, graph);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
