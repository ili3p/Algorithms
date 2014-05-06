package com.arvers.algo.graphs;

import java.io.*;
import java.util.*;

public class KosarajuSolver {

	public static boolean DEBUG = false;

	public static int[] runAlgo(String fileName, int N) throws IOException {
		Object[] graph;
		System.out.println("Reading graph in file " + fileName + " ...");
		graph = readGraph(fileName, N);
		System.out.println("Graph read.");

		KosarajuSCC.DEBUG = DEBUG;
		KosarajuSCC solver = new KosarajuSCC(graph);
		System.out.println("Running algorithm...");
		int[] leader = solver.run();
		System.out.println("Algorithm ran.");
		System.out.println("Counting SCC");

		graph = null;
		System.gc();
		int[] sccSize = new int[leader.length];

		Arrays.fill(sccSize, 0);

		for (int i = 0; i < leader.length; i++) {
			sccSize[leader[i]]++;
		}

		Arrays.sort(sccSize);

		for (int i = sccSize.length - 1; i > sccSize.length - 11 && i > -1; --i) {
			System.out.print(sccSize[i] + " ");
		}

		return leader;
	}

	@SuppressWarnings("unchecked")
	public static Object[] readGraph(String fileName, int N) throws IOException {

		Object[] graph = new Object[N];

		for (int i = 0; i < N; ++i) {
			graph[i] = new LinkedList<Integer>();
		}

		int max = 5105043, p = 0;
		float progres = 0;

		BufferedReader sc = new BufferedReader(new FileReader(fileName), 7000000);
		String line = sc.readLine();
		while (line != null) {
			++p;
			float tmp = 100 * p / max;
			if (tmp - progres >= 1) {
				System.out.println(tmp + " %");
				progres = tmp;
			}
			String[] s = line.split(" ");
			int node1 = Integer.parseInt(s[0]) - 1;
			int node2 = Integer.parseInt(s[1]) - 1;

			((LinkedList<Integer>) graph[node1]).add(node2);
			line = sc.readLine();
		}
		sc.close();

		return graph;
	}

	public static void main(String[] args) {
		try {
			// KosarajuSolver.runAlgo("resource/SCC.txt", 875714);
			KosarajuSolver.runAlgo("resource/2sat_test.txt", 4);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
