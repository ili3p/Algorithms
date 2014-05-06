package com.arvers.algo.hash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class TwoSum {

	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new FileReader("resource/HashInt.txt"));
			int[] a = new int[500000];
			HashSet<Integer> hash = new HashSet<Integer>(5000000);
			String line = br.readLine();
			int i = 0;

			while (line != null) {
				a[i] = Integer.parseInt(line);
				hash.add(a[i]);
				line = br.readLine();
				++i;
			}

			int sum = 0;

			for (int t = 2500; t < 4001; t++) {
				for (int j = 0; j < a.length; j++) {
					int x = a[j];
					int y = t - x;
					if (x != y && hash.contains(y)) {
						System.out.println("T: " + t + "  X:" + x + " Y:" + y);
						sum++;
						break;
					}
				}
			}
			br.close();
			System.out.println(sum);

	}
}
