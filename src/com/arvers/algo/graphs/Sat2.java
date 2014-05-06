package com.arvers.algo.graphs;

import java.io.*;
import java.util.*;

public class Sat2 {
	private static final long MEGABYTE = 1024L * 1024L;
	private static int log2n;
	private static long n2;
	private static int n;
	private static int[][] clauses;

	// sat1 is;
	// sat2 is;

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("resource/2sat6.txt"));
			n = sc.nextInt();

			clauses = new int[n][];
			int i = 0;
			while (sc.hasNext()) {
				int v1 = sc.nextInt();
				int v2 = sc.nextInt();
				clauses[i++] = new int[] { v1, v2 };
			}
			sc.close();
			log2n = (int) (Math.log(n) / Math.log(2)) + 1 + 5;
			n2 = 2 * (long) (n) * n;

			new Thread(new Runnable() {

				@Override
				public void run() {
					runIt(0, log2n / 2);

				}
			}, "T1").start();

			new Thread(new Runnable() {

				@Override
				public void run() {
					runIt(log2n / 2, log2n);
				}
			}, "T2").start();

			// calcMem();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void runIt(int start, int end) {

		for (int t = start; t < end; ++t) {

			boolean[] assignment = randomAssignment(n);
			boolean isOk = true;
			for (long m = 0; m < n2; ++m) {
				double p = 100.0 * m / n2;
				if (p % 2 == 0)
					System.out.println(Thread.currentThread().getName() + " at: " + p + " %");

				for (int k = 0; k < n; ++k) {
					// int[] clause = clauses[k];
					// int c0 = Math.abs(clause[0]) - 1;
					// int c1 = Math.abs(clause[1]) - 1;

					boolean l = false, r = false;

					if (clauses[k][0] > -1) {
						l = assignment[clauses[k][0]];
					} else {
						l = !assignment[clauses[k][0] * -1];
					}

					if (clauses[k][1] > -1) {
						r = assignment[clauses[k][1]];
					} else {
						r = !assignment[clauses[k][1] * -1];
					}

					isOk = l || r;

					if (!isOk) {

						if (clauses[k][1] > -1) {
							assignment[clauses[k][1]] = !assignment[clauses[k][1]];
						} else {
							assignment[(clauses[k][1] * -1)] = !assignment[(clauses[k][1] * -1)];
						}

						break;
					}

					// boolean l = (clause[0] > -1) ? assignment[c0] :
					// !assignment[c0];
					// boolean r = (clause[1] > -1) ? assignment[c1] :
					// !assignment[c1];
				}
				if (isOk) {
					break;
				}
			}
			if (isOk) {
				System.out.println("Is satisfiable!");
				break;
			} else {
				System.out.println("Is unsatisfiable!");
			}
		}
	}

	private static boolean[] randomAssignment(int n) {
		boolean[] result = new boolean[n];
		for (int i = 0; i < result.length; i++) {
			result[i] = Math.random() >= 0.5;
		}
		return result;
	}

	private static void calcMem() {
		Runtime runtime = Runtime.getRuntime();
		runtime.gc();
		long memory = runtime.totalMemory() - runtime.freeMemory();
		System.out.println("Used memory is bytes: " + memory);
		System.out.println("Used memory is megabytes: " + bytesToMegabytes(memory));
	}

	private static double bytesToMegabytes(long bytes) {
		return (bytes * 1.0) / MEGABYTE;
	}
}
