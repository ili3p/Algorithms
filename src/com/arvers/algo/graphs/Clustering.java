package com.arvers.algo.graphs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.arvers.algo.Util;

public class Clustering {

	static class Node {
		protected String label;
		protected int leader;
		protected List<Integer> subjects;

		Node(String l, int i) {
			label = l;
			leader = i;
			subjects = new ArrayList<Integer>();
			subjects.add(i);
		}

		public void addSubject(int i) {
			subjects.add(i);
		}
	}

	public static void main(String[] args) {

		try {
			File file = new File("resource/clustering2.txt");
			// File file = new File("resource/clustering2_t2.txt");
			// File file = new File("resource/clus.txt");
			// solve(file);
			// solve2(file);
			long t = System.nanoTime();
			solve3(file);
			Util.time("total", t);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static void solve3(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		String[] fl = sc.nextLine().split(" ");
		int numNodes = Integer.parseInt(fl[0]);
		Node[] node = new Node[numNodes];
		int i = 0;
		while (sc.hasNext()) {

			String newNode = sc.nextLine();
			node[i] = new Node(newNode, i);

			for (int k = 0; k < i; ++k) {
				boolean inSame = isSameCluster(newNode, node[k].label);
				int l1 = node[k].leader;
				int l2 = node[i].leader;
				if (inSame && l1 != l2) {
					merge(node, l1, l2);
				}

			}

			++i;
		}
		sc.close();

		Set<Integer> c = new HashSet<Integer>();
		for (int j = 0; j < node.length; j++) {
			c.add(node[j].leader);
		}
		System.out.println(c.size());
	}

	private static void merge(Node[] node, int l1, int l2) {
		int s1 = node[l1].subjects.size();
		int s2 = node[l2].subjects.size();
		int smaller = (s1 < s2) ? l1 : l2;
		int bigger = (s1 < s2) ? l2 : l1;

		for (Integer i : node[smaller].subjects) {
			node[i].leader = bigger;
			node[bigger].subjects.add(i);
		}

		node[smaller].subjects = new ArrayList<Integer>();
	}

	private static void solve2(File file) throws FileNotFoundException {
		Scanner sc = new Scanner(file);
		String[] fl = sc.nextLine().split(" ");
		int numNodes = Integer.parseInt(fl[0]);
		String[] node = new String[numNodes];
		int[] cluster = new int[numNodes];
		int i = 0;
		int c = 0;
		while (sc.hasNext()) {

			String newNode = sc.nextLine();
			node[i] = newNode;
			boolean clusterFound = false;
			for (int k = 0; k < i; ++k) {
				boolean inSame = isSameCluster(newNode, node[k]);
				if (inSame && !clusterFound) {
					cluster[i] = cluster[k];
					clusterFound = true;
					continue;
				}

				if (inSame && clusterFound) {
					cluster[k] = cluster[i];
				}
			}

			if (!clusterFound) {
				cluster[i] = c++;
			}
			++i;
		}
		sc.close();
		Arrays.sort(cluster);
		c = 1;
		int k = cluster[0];
		for (i = 1; i < cluster.length; ++i) {
			if (k != cluster[i]) {
				++c;
				k = cluster[i];
			}
		}

		System.out.println(c);

	}

	private static boolean isSameCluster(String newNode, String node) {

		boolean result = true;
		int dif = 0;
		char[] newN = newNode.toCharArray();
		char[] n = node.toCharArray();

		for (int i = 0; i < n.length; ++i) {
			if (newN[i] != n[i]) {
				++dif;
			}
			if (dif > 2) {
				result = false;
				break;
			}
		}

		return result;
	}

	private static void solve(File file) throws FileNotFoundException {
		long t = System.nanoTime();
		Scanner sc = new Scanner(file);

		List<HashSet<String>> clusters = new ArrayList<HashSet<String>>();
		String firstLine = sc.nextLine();
		long inner = 0, outter = 0;

		while (sc.hasNext()) {

			String newNode = sc.nextLine();

			boolean nc = true;
			t = System.nanoTime();
			for (HashSet<String> cluster : clusters) {
				boolean f = false;

				if (cluster.contains(newNode)) {
					nc = false;
					break;
				} else {
					long tt = System.nanoTime();
					for (String node : cluster) {
						int dif = 0;
						char[] newN = newNode.toCharArray();
						char[] n = node.toCharArray();

						for (int i = 0; i < n.length; ++i) {
							if (newN[i] != n[i]) {
								++dif;
							}
							if (dif > 2) {
								break;
							}
						}

						if (dif < 3) {
							f = true;
							break;
						}
					}

					if (f) {
						cluster.add(newNode);
						nc = false;
						break;
					}
					inner += System.nanoTime() - tt;
				}

			}
			outter += System.nanoTime() - t;
			if (nc) {
				HashSet<String> cluster = new HashSet<String>();
				cluster.add(newNode);
				clusters.add(cluster);
			}
		}
		sc.close();
		System.out.println(clusters.size());
		System.out.println("Inner " + inner / 1e6 + "ms");
		System.out.println("Outter " + outter / 1e6 + "ms");
	}

}
