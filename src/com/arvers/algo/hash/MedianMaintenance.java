package com.arvers.algo.hash;

import java.io.*;
import java.util.*;

public class MedianMaintenance {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("resource/Median.txt"));
		String line = br.readLine();

		PriorityQueue<Integer> hLow = new PriorityQueue<Integer>(5000, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2) * -1;
			}
		});

		PriorityQueue<Integer> hHigh = new PriorityQueue<Integer>(5000);

		int i = 0;
		int sum = 0;

		while (line != null) {
			int x = Integer.parseInt(line);
			int hHighMin = hHigh.peek() != null ? hHigh.peek() : Integer.MAX_VALUE;
			int median = -1;

			if (x > hHighMin) {
				hHigh.add(x);
			} else {
				hLow.add(x);
			}

			if (hHigh.size() - hLow.size() > 1) {
				hLow.add(hHigh.poll());
			} else if (hLow.size() - hHigh.size() > 1) {
				hHigh.add(hLow.poll());
			}

			median = hHigh.size() > hLow.size() ? hHigh.peek() : hLow.peek();
			sum += median;

			line = br.readLine();
			++i;
		}
		br.close();
		System.out.println(sum % 10000);
	}
}
