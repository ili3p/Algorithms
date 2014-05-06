package com.arvers.algo.graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

import com.arvers.algo.graphs.PrimMST.Node;

public class PrimMST {

	static class Edge {
		protected int toNode;
		protected int cost;

		public Edge(int toNode, int cost) {
			this.toNode = toNode;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "toNode: " + toNode + ", cost: " + cost + "\n";
		}
	}

	static class Node implements Comparable<Node> {
		protected int name;
		protected List<Edge> edges;
		private Set<Integer> nodes;

		public Node() {
			edges = new ArrayList<PrimMST.Edge>();
		}

		public Node(int name) {
			this();
			this.name = name;
		}

		public Node(int name, int toNode, int cost) {
			this(name);
			addEdge(toNode, cost);
		}

		public void addEdge(int toNode, int cost) {
			edges.add(new Edge(toNode, cost));
		}

		public int key() {

			int min = Integer.MAX_VALUE;

			for (Edge e : edges) {
				if (nodes.contains(e.toNode) && min > e.cost) {
					min = e.cost;
				}
			}
			return min;
		}

		public void setNodes(Set<Integer> n) {
			nodes = n;
		}

		@Override
		public String toString() {
			if (nodes == null) {
				return "Node: " + name + " Edges: \n" + Arrays.toString(edges.toArray(new Edge[0]));
			} else {
				return "Node: " + name + " Key:" + key();
			}
		}

		@Override
		public boolean equals(Object obj) {
			Node o = (Node) obj;
			return o.name == this.name;
		}

		@Override
		public int hashCode() {
			return name;
		}

		@Override
		public int compareTo(Node o) {
			int res = 0, k1 = key(), k2 = o.key();

			if (k1 > k2) {
				res = 1;
			} else {
				res = -1;
			}
			return res;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		String fName = "resource/edges.txt";
		long cost = solve(fName, true, false);
		System.out.println("Cost: " + cost);

//		 test(fName, cost);

		// testPickNode(fName);

	}

	@SuppressWarnings("unused")
	private static void testPickNode(String fName) throws FileNotFoundException {
		Map<Integer, Node> G = readGraph(fName, new HashSet<Integer>());
		for (int i = 0; i < 10000000; ++i) {
			Node n = pickNode(G);
			if (n.name > 6 || n.name < 1) {
				System.err.println(n.name);
			}
		}
	}

	private static void test(String fName, long cost) throws FileNotFoundException {
		long t = System.nanoTime();
		for (int i = 0; i < 1e4; ++i) {
			long tmpCost = solve(fName, false, false);
			if (cost != tmpCost) {
				System.err.println("Difference: " + tmpCost);
				break;
			}
		}
		time("Testing: ", t);
	}

	@SuppressWarnings("unused")
	private static long solve(String fName, boolean timeIt, boolean print) throws FileNotFoundException {

		long t = System.nanoTime();
		Set<Integer> V = new HashSet<Integer>(500);
		Map<Integer, Node> G = readGraph(fName, V);
		if (timeIt) {
			time("Reading Input: ", t);
		}

		if (print) {
			printGraph(G);
		}

		int numNodes = G.size();
		Set<Integer> X = new HashSet<Integer>(numNodes);

		t = System.nanoTime();
		Node firstNode = pickNode(G);
		if (timeIt) {
			time("Picking node: ", t);
		}
		if (print) {
			System.out.println("Node picked: " + firstNode);
		}

		X.add(firstNode.name);
		V.remove(firstNode.name);

		t = System.nanoTime();
		PriorityQueue<Node> nodesToProcess = new PriorityQueue<PrimMST.Node>(numNodes);

		for (Node node : G.values()) {
			if (V.contains(node.name)) {
				node.setNodes(X);
				nodesToProcess.add(node);
			}
		}
		if (timeIt) {
			time("Initial loading: ", t);
		}
		if (print) {
			System.out.println("V: " + V);
			System.out.println("X: " + X);
			System.out.println("Q: " + nodesToProcess);
		}
		long cost = 0;
		t = System.nanoTime();
		while (!V.isEmpty()) {
			Node n = nodesToProcess.poll();
			X.add(n.name);
			V.remove(n.name);

			cost += n.key();

			for (Edge e : n.edges) {
				if (V.contains(e.toNode)) {
					Node toNode = G.get(e.toNode);
					if (nodesToProcess.remove(toNode)) {
						toNode.setNodes(X);
						nodesToProcess.add(toNode);
					}
				}
			}
			if (print) {
				System.out.println("V: " + V);
				System.out.println("X: " + X);
				System.out.println("Q: " + nodesToProcess);
			}
		}
		if (timeIt) {
			time("While loop: ", t);
		}

		return cost;

	}

	private static Map<Integer, Node> readGraph(String fName, Set<Integer> V) throws FileNotFoundException {

		Scanner scan = new Scanner(new File(fName));

		int numNodes = scan.nextInt();
		int numEdges = scan.nextInt();

		Map<Integer, Node> G = new HashMap<Integer, Node>(numNodes);

		while (scan.hasNext()) {
			int node1 = scan.nextInt();
			int node2 = scan.nextInt();
			int cost = scan.nextInt();

			addNodeToGraph(G, node1, node2, cost);
			addNodeToGraph(G, node2, node1, cost);
			V.add(node1);
			V.add(node2);
		}
		scan.close();

		return G;
	}

	private static Node pickNode(Map<Integer, Node> g) {
		int rnd = (int) (Math.random() * g.size());
		Iterator<Node> vals = g.values().iterator();
		while (rnd-- > 0) {
			vals.next();
		}

		return vals.next();
	}

	private static void printGraph(Map<Integer, Node> map) {
		for (Node node : map.values()) {
			System.out.println(node);
		}
	}

	private static void addNodeToGraph(Map<Integer, Node> g, int node1, int node2, int cost) {
		Node n1 = g.get(node1);
		if (n1 == null) {
			n1 = new Node(node1, node2, cost);
			g.put(node1, n1);
		} else {
			n1.addEdge(node2, cost);
		}
	}

	private static void time(String string, long t) {
		System.out.println(string + (System.nanoTime() - t) / 1e6 + "ms");
	}
}
