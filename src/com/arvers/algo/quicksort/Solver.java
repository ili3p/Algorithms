package com.arvers.algo.quicksort;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import com.arvers.algo.quicksort.pivot.FirstPivot;
import com.arvers.algo.quicksort.pivot.LastPivot;
import com.arvers.algo.quicksort.pivot.MedianPivot;
import com.arvers.algo.quicksort.pivot.MultiMedianPivot;
import com.arvers.algo.quicksort.pivot.RandomPivot;

public class Solver {

	private static void runAlgo() throws IOException {

		String fileName = "resource/QuickSort.txt";

		BufferedReader in = new BufferedReader(new FileReader(fileName));
		PrintWriter out = new PrintWriter(new File("resource/results.txt"));

		int[] input = new int[10000];
		int i = 0;

		String line = in.readLine();

		while (line != null && line.length() > 0) {
			input[i++] = Integer.parseInt(line);
			line = in.readLine();
		}

		in.close();

		int n = input.length;

		if (i != n) {
			System.out.println("WARRNIG: \n Array not full!");
			out.println("WARRNIG: \n Array not full!");
		}

		QuickSort.DEBUG = false;

		out.println("Number of comparisons: ");

		int[] a = Arrays.copyOf(input, n);
		int comparisons = QuickSort.sort(a, 0, n, new FirstPivot());
		out.println("\tWith first element as pivot:\t\t\t\t\t\t\t"
				+ comparisons);

		a = Arrays.copyOf(input, n);
		comparisons = QuickSort.sort(a, 0, n, new LastPivot());
		out.println("\tWith last element as pivot:\t\t\t\t\t\t\t\t"
				+ comparisons);

		a = Arrays.copyOf(input, n);
		comparisons = QuickSort.sort(a, 0, n, new MedianPivot());
		out.println("\tWith median element as pivot:\t\t\t\t\t\t\t"
				+ comparisons);

		a = Arrays.copyOf(input, n);
		comparisons = QuickSort.sort(a, 0, n, new MultiMedianPivot(100));
		out.println("\tWith multi median element with 100 samples as pivot:\t"
				+ comparisons);

		a = Arrays.copyOf(input, n);
		comparisons = QuickSort.sort(a, 0, n, new RandomPivot());
		out.println("\tWith random element as pivot:\t\t\t\t\t\t\t"
				+ comparisons);

		out.println("Note: nlog(n) : " + n + "log(" + n + "):\t\t\t\t\t\t\t "
				+ (int) (n * Math.log(n)));
		out.println("    : n*n : " + n + "*" + n + ":\t\t " + (int) (n * n));

		out.flush();
		out.close();

	}

	public static void main(String[] args) {
		try {
			Solver.runAlgo();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
