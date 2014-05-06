package com.arvers.algo.graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class DijkstraSP {

	@SuppressWarnings("unchecked")
	public static int[] runAlgo(Object[] graph, int source) {

		int[] sps = new int[graph.length];
		boolean[] explored = new boolean[graph.length];
		HashMap<Integer, Integer> nodes = new HashMap<Integer, Integer>();
		PriorityQueue<Node> heap = new PriorityQueue<Node>(graph.length);

		Arrays.fill(sps, 1000000);
		Arrays.fill(explored, false);

		sps[source] = 0;
		explored[source] = true;
		heap.add(new Node(source, 0));

		while (heap.size() > 0) {

			Node currentNode = heap.poll();

			sps[currentNode.label] = currentNode.totalWeight;
			explored[currentNode.label] = true;
			LinkedList<Edge> edges = (LinkedList<Edge>) graph[currentNode.label];

			for (Edge edge : edges) {

				if (!explored[edge.node]) {

					int tW = sps[currentNode.label] + edge.weight;

					Node n = new Node(edge.node, tW);

					if (!heap.contains(n)) {
						heap.add(n);
						nodes.put(edge.node, tW);
					} else {
						int cWeight = nodes.get(edge.node);
						n.totalWeight = Math.min(cWeight, tW);
						if (n.totalWeight != cWeight) {
							heap.remove(n);
							nodes.put(edge.node, n.totalWeight);
							heap.add(n);
						}
					}
				}
			}

		}

		return sps;
	}
}
