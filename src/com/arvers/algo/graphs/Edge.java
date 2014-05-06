package com.arvers.algo.graphs;

public class Edge implements Comparable<Edge> {
	public int node;
	public int weight;

	public Edge() {
	}

	public Edge(int n, int w) {
		node = n;
		weight = w;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight - o.weight;
	}

	@Override
	public boolean equals(Object o) {
		return this.node == ((Edge) o).node;
	}

	@Override
	public String toString() {
		return "[" + node + "," + weight + "]";
	}
}