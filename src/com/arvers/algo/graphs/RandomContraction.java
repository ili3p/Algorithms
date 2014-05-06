package com.arvers.algo.graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class RandomContraction {

	private static List<HashSet<Integer>> masterNodes;
	private static List<HashSet<Integer>> masterEdges;

	public static void main(String[] args) {

		try {

			readGraph();

			int numberOfNodes = masterNodes.size();
			int numberOfTries = (int) (numberOfNodes * Math.log(numberOfNodes));
			int minCut = Integer.MAX_VALUE;

			for (int i = 0; i < numberOfTries; ++i) {

				List<HashSet<Integer>> nodes = deepCloneList(masterNodes);
				List<HashSet<Integer>> edges = deepCloneList(masterEdges);

				int localMinCut = getMinCut(nodes, edges);

				minCut = Math.min(minCut, localMinCut);
			}

			System.out.println("The MinCut for this graph is: " + minCut);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void readGraph() throws IOException {

		masterNodes = new LinkedList<HashSet<Integer>>();
		masterEdges = new LinkedList<HashSet<Integer>>();

		String fileName = "resource/kargerMinCut.txt";
		BufferedReader in = new BufferedReader(new FileReader(fileName));
		String line = in.readLine();

		while (line != null && line.length() > 0) {

			String[] input = line.split("\\s+");

			HashSet<Integer> nodes = new HashSet<Integer>();
			nodes.add(Integer.parseInt(input[0]));
			masterNodes.add(nodes);

			HashSet<Integer> edges = new HashSet<Integer>();

			for (int i = 1; i < input.length; i++) {
				edges.add(Integer.parseInt(input[i]));
			}

			masterEdges.add(edges);

			line = in.readLine();
		}

		in.close();
	}

	private static List<HashSet<Integer>> deepCloneList(
			List<HashSet<Integer>> original) {

		List<HashSet<Integer>> clone = new LinkedList<HashSet<Integer>>();

		for (HashSet<Integer> hashSet : original) {
			 clone.add(new HashSet<Integer>(hashSet));
		}

		return clone;
	}

	private static int getMinCut(List<HashSet<Integer>> nodes,
			List<HashSet<Integer>> edges) {

		while (nodes.size() > 2) {

			int rndInd1 = (int) (Math.random() * nodes.size());

			HashSet<Integer> match1 = edges.get(rndInd1);

			int rndInd2 = (int) (Math.random() * match1.size());

			Iterator<Integer> iter = match1.iterator();
			while (rndInd2 > 1) {
				iter.next();
				--rndInd2;
			}

			int m2 = iter.next();

			HashSet<Integer> nodes1 = nodes.get(rndInd1);

			HashSet<Integer> match2 = null;
			HashSet<Integer> nodes2 = null;

			for (int i = 0; i < nodes.size(); ++i) {
				HashSet<Integer> tmp = nodes.get(i);
				if (tmp.contains(m2)) {
					match2 = edges.get(i);
					nodes2 = nodes.get(i);
					m2 = i;
					break;
				}
			}

			HashSet<Integer> merged = new HashSet<Integer>();

			for (Integer integer : match1) {
				if (!nodes2.contains(integer)) {
					merged.add(integer);
				}
			}

			for (Integer integer : match2) {
				if (!nodes1.contains(integer)) {
					merged.add(integer);
				}
			}

			for (Integer integer : nodes2) {
				nodes1.add(integer);
			}

			edges.set(rndInd1, merged);
			edges.remove(m2);
			nodes.remove(m2);
		}

		return Math.max(edges.get(0).size(), edges.get(1).size());
	}
}
