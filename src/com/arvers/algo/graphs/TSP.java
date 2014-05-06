package com.arvers.algo.graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TSP {
	static class Node {
		protected float x;
		protected float y;

		public Node(float xx, float yy) {
			this.x = xx;
			this.y = yy;
		}

		@Override
		public String toString() {
			return "x: " + x + ", y: " + y;
		}
	}

	static class Subset {
		protected List<Integer> nodes;

		public Subset() {
			nodes = new ArrayList<Integer>();
		}

		public void addNode(int n) {
			nodes.add(n);
		}

		@Override
		public boolean equals(Object obj) {
			Subset sub = (Subset) obj;
			if (nodes.size() != sub.nodes.size()) {
				return false;
			} else {
				return hashCode() == sub.hashCode();
			}
		}

		@Override
		public int hashCode() {
			String d = getHashString();
			return d.hashCode();
		}

		private String getHashString() {
			Collections.sort(nodes);
			StringBuilder s = new StringBuilder();
			for (Integer in : nodes) {
				s.append(in);
			}

			return s.toString();
		}
	}

	static float getCost(Node n, Node n1) {
		double s = Math.pow((n.x - n1.x), 2);
		double d = Math.pow((n.y - n1.y), 2);
		return (float) Math.sqrt(s + d);
	}

	static int[] nextSubset(int n, int[] subset) {
		int l = subset.length;
		int[] result = Arrays.copyOf(subset, l);
		boolean newSubset = false;

		for (int k = l - 1; k > -1; --k) {
			int d = l - 1 - k;
			int a = subset[k];
			if (a + 1 <= (n - d)) {
				int j = 1;
				for (int i = k; i < l; ++i) {
					result[i] = a + j;
					++j;
					newSubset = true;
				}
				break;
			}
		}
		return newSubset ? result : null;
	}

	public static void main(String[] args) {
		Scanner sc;
		Node[] nodes = null;
		try {
			sc = new Scanner(new File("resource/tsp.txt"));
//			 sc = new Scanner(new File("resource/tsp_test_27603.txt"));
//			 sc = new Scanner(new File("resource/tsp_test6859.txt"));
//			 sc = new Scanner(new File("resource/tsp_test.txt"));

			int numNodes = sc.nextInt();
			nodes = new Node[numNodes];
			int ps = 0;
			while (sc.hasNext()) {
				nodes[ps] = new Node(sc.nextFloat(), sc.nextFloat());
				System.out.println(nodes[ps]);
				++ps;
			}
			sc.close();
			System.out.println(numNodes);

			float[][] A = new float[(int) Math.pow(2, numNodes - 1)][];

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < numNodes - 1; ++i) {
				sb.append("0");
			}
			StringBuilder reset = new StringBuilder(sb);

			int S = Integer.parseInt(sb.toString(), 2);
			A[S] = new float[numNodes];
			A[S][0] = 0;  

			for (int m = 1; m < numNodes; ++m) {

				int[] subset = new int[m];
				for (int i = 0; i < m; ++i) {
					subset[i] = i + 1;
				}

				while (subset != null) {

					sb = new StringBuilder(reset);
					for (int index : subset) {
						sb.setCharAt(index - 1, '1');
					}

					for (int i = 0; i < m; ++i) {

						int j = subset[i];

						float min = Float.MAX_VALUE;

						sb.setCharAt(j - 1, '0');

						int S_j = Integer.parseInt(sb.toString(), 2);

						for (int h = 0; h < m; ++h) {

							int k = subset[h];

							if (j != k) {

								float prevA = A[S_j][k];
								float c = getCost(nodes[k], nodes[j]);
								float local = prevA + c;
								min = Math.min(local, min);
							}
						}
						float prevA = S_j != 0 ? Float.MAX_VALUE : 0;
						float c = getCost(nodes[j], nodes[0]);
						float local = prevA + c;
						min = Math.min(local, min);

						sb.setCharAt(j - 1, '1');
						S = Integer.parseInt(sb.toString(), 2);
						if (A[S] == null) {
							A[S] = new float[numNodes];
						}
						A[S][j] = min;
					}
					subset = nextSubset(numNodes - 1, subset);
				}

			}

			for (int h = 0; h < sb.length(); ++h) {
				sb.setCharAt(h, '1');
			}
			S = Integer.parseInt(sb.toString(), 2);
			double min = Integer.MAX_VALUE;
			for (int j = 1; j < numNodes; ++j) {
				double local = A[S][j] + getCost(nodes[j], nodes[0]);
				min = Math.min(min, local);
			}
			System.out.println(min);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
