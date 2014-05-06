package com.arvers.algo.graphs;

public class Node implements Comparable<Node> {

	public int label;
	public int totalWeight;

	public Node() {
	}

	public Node(int l, int tW) {
		label = l;
		totalWeight = tW;
	}

	public Node(int l) {
		label = l;
		totalWeight = 1000000;
	}

	@Override
	public int compareTo(Node o) {
		return this.totalWeight - o.totalWeight;
	}

	@Override
	public boolean equals(Object obj) {
		return this.label == ((Node) obj).label;
	}

	@Override
	public String toString() {
		return "[" + label + "," + totalWeight + "]";
	}
}
