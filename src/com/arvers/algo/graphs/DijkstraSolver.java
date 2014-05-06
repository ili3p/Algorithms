package com.arvers.algo.graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class DijkstraSolver {
	public static Object[] readGraph(String fileName, int n) throws IOException {
		Object[] graph = new Object[n + 1];

		BufferedReader reader = new BufferedReader(new FileReader(fileName));

		String line = reader.readLine();

		while (line != null) {

			String[] s = line.split("\\s+");
			int node = Integer.parseInt(s[0]);
			LinkedList<Edge> links = new LinkedList<Edge>();

			for (int i = 1; i < s.length; ++i) {
				String[] t = s[i].split(",");
				Edge e = new Edge(Integer.parseInt(t[0]),
						Integer.parseInt(t[1]));
				links.add(e);
			}

			graph[node] = links;

			line = reader.readLine();
		}

		reader.close();

		return graph;
	}

	public static int[] readSolution(String fileName) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String[] line = reader.readLine().split(",");
		reader.close();

		int[] res = new int[line.length];
		for (int i = 0; i < res.length; i++) {
			res[i] = Integer.parseInt(line[i]);
		}

		return res;
	}
}
