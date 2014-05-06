package com.arvers.algo.graphs;

import java.util.Arrays;
import java.util.LinkedList;

public class KosarajuSCC {

	public static boolean DEBUG = true;
	private int s;
	private boolean[] explored;
	private int[] leader;
	private int n;
	private Object[] graph;
	private int[] fTimes;
	private int f;

	public KosarajuSCC(Object[] graph) {
		this.graph = graph;
		this.n = graph.length;
		this.explored = new boolean[n];
		this.leader = new int[n];
		this.s = -1;
		this.f = 0;
		this.fTimes = new int[n];

		Arrays.fill(explored, false);
		Arrays.fill(leader, -1);
		Arrays.fill(fTimes, -1);
	}

	public int[] run() {

		System.out.println("Reversing graph...");
		graph = reverseGraph(graph);
		System.out.println("Done.");

		System.out.println("First pass...");
		DFSLoop(graph, true);
		System.out.println("Done.");

		System.out.println("Reversing graph...");
		graph = reverseGraph(graph);
		System.out.println("Done.");

		System.out.println("Second pass...");
		Arrays.fill(explored, false);
		Arrays.fill(leader, -1);
		DFSLoop(graph, false);
		System.out.println("Done");

		return leader;
	}

	private void DFSLoop(Object[] graph, boolean isReversed) {

		for (int i = n - 1; i > -1; --i) {
			int node = isReversed ? i : fTimes[i];
			if (!explored[node]) {
				this.s = node;
				DFS(graph, node, isReversed);
			}
		}

		if (DEBUG) {
			System.out.print(isReversed ? "F " : "L ");
			System.out.println(Arrays.toString((isReversed ? fTimes : leader)));
		}
	}

	@SuppressWarnings("unchecked")
	private void DFS(Object[] graph, int node, boolean isReversed) {

		explored[node] = true;
		leader[node] = this.s;

		LinkedList<Integer> links = (LinkedList<Integer>) graph[node];
		if (links != null) {
			for (Integer link : links) {
				if (!explored[link]) {
					DFS(graph, link, isReversed);
				}
			}

		}
		if (isReversed) {
			System.out.println(node);
			fTimes[f] = node;
			f++;
		}
	}

	@SuppressWarnings("unchecked")
	public Object[] reverseGraph(Object[] graph) {

		Object[] newGraph = new Object[graph.length];

		for (int i = 0; i < graph.length; i++) {
			LinkedList<Integer> links = (LinkedList<Integer>) graph[i];
			if (links != null) {
				for (Integer link : links) {
					if (newGraph[link] == null) {
						newGraph[link] = new LinkedList<Integer>();
					}

					((LinkedList<Integer>) newGraph[link]).add(i);
				}
			}
		}

		return newGraph;
	}

}
