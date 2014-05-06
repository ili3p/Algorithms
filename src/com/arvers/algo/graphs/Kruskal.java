package com.arvers.algo.graphs;

import java.io.File;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.arvers.algo.Util;

public class Kruskal {

	static class Edge implements Comparable<Edge> {
		protected int n1, n2, cost;

		public Edge(int i, int j, int c) {
			n1 = i;
			n2 = j;
			cost = c;
		}

		@Override
		public int compareTo(Edge o) {
			return cost - o.cost;
		}

		@Override
		public String toString() {
			return n1 + "->" + n2 + " (" + cost + ")";
		}

	}

	static class Node {
		protected int leader;
		protected List<Integer> subjects;

		public Node(int l, int s) {
			leader = l;
			subjects = new ArrayList<Integer>();
			subjects.add(l);
		}

		@Override
		public String toString() {
			return leader + " " + subjects;
		}

		public void addSubject(int n) {
			subjects.add(n);
		}
	}

	public static void main(String[] args) {

		try {
			long t = System.nanoTime();
//			 Scanner sc = new Scanner(new File("resource/kruskal.txt"));
			Scanner sc = new Scanner(new File("resource/clustering1.txt"));
//			Scanner sc = new Scanner(new File("resource/clustering_t1.txt"));
//			Scanner sc = new Scanner(new File("resource/clustering_t2.txt"));
			int numNodes = sc.nextInt(), i, j, c;
			List<Edge> edges = new ArrayList<Edge>(numNodes * (numNodes - 1) / 2);
			Node[] node = new Node[numNodes + 1];
			while (sc.hasNext()) {
				i = sc.nextInt();
				j = sc.nextInt();
				c = sc.nextInt();
				edges.add(new Edge(i, j, c));
			}
			Util.time("Reading", t);
			t = System.nanoTime();
			for (int n = 1; n < numNodes + 1; n++) {
				node[n] = new Node(n, 1);
			}
			Util.time("Nodes", t);

			int k = 4;
			boolean print = false;

			t = System.nanoTime();
			solve(edges, node, k, print);
			Util.time("Solve", t);

			int maxSpacing = calcMaxSpacing(edges, node);

			System.out.println(maxSpacing);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static int calcMaxSpacing(List<Edge> edges, Node[] node) {
		int max = Integer.MAX_VALUE;

		for (Edge e : edges) {
			if (node[e.n1].leader != node[e.n2].leader) {
				max = Math.min(max, e.cost);
			}
		}

		return max;
	}

	private static void solve(List<Edge> edges, Node[] node, int k, boolean print) {
		long t = System.nanoTime();
		int numMerges = (node.length - 1) - k;
		Collections.sort(edges);
		Util.time("Sorting", t);
		if (print) {
			System.out.println(edges);
		}
		long totalMerge = 0;
		List<Edge> T = new ArrayList<Edge>(edges.size());
		t = System.nanoTime();
		for (Edge edge : edges) {

			int leader1 = node[edge.n1].leader;
			int leader2 = node[edge.n2].leader;

			if (leader1 != leader2) {

				T.add(edge);
				long t1 = System.nanoTime();
				merge(node, leader1, leader2);
				totalMerge += (System.nanoTime() - t1);
				--numMerges;
				if (numMerges <= 0) {
					break;
				}
			}
		}
		System.out.println("Total Merge: " + totalMerge / 1e6 + "ms");
		Util.time("While Loop", t);
	}

	private static void merge(Node[] node, int l1, int l2) {

		int s1 = node[l1].subjects.size();
		int s2 = node[l2].subjects.size();
		int smaller = (s1 > s2) ? l2 : l1;
		int bigger = (s1 > s2) ? l1 : l2;

		for (int n : node[smaller].subjects) {
			node[n].subjects = null;
			node[n].leader = bigger;
			node[bigger].addSubject(n);
		}
	}
}
