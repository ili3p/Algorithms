package com.arvers.algo;
import java.io.*;
import java.util.*;

public class C {

	static class Stone implements Comparable<Stone> {
		double pos;
		int n;

		public Stone(double p, int nn) {
			n = nn;
			pos = p;
		}

		@Override
		public int compareTo(Stone o) {
			int r = Double.compare(pos, o.pos);
			if (r == 0) {
				r = -1;
			}
			return r;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		char[] input = sc.next().toCharArray();
		for (int i = 0; i < input.length; i++) {
			if (input[i] == 'r')
				out.println(i + 1);
		}
		for (int i = input.length - 1; 0 <= i; i--) {
			if (input[i] == 'l')
				out.println(i + 1);
		}
		out.flush();
		// Scanner sc = new Scanner(System.in);
		// char[] s = sc.nextLine().toCharArray();
		// double l = 0.0, r = 1.0;
		// List<Stone> list = new ArrayList<Stone>();
		//
		// for (int i = 0; i < s.length; i++) {
		// double pos = (r + l) / 2.0;
		// list.add(new Stone(pos, i + 1));
		// if (s[i] == 'l') {
		// r = pos;
		// } else {
		// l = pos;
		// }
		// }
		// Collections.sort(list);
		//
		// for (Stone stone : list) {
		// System.out.println(stone.n);
		// }
	}
}
