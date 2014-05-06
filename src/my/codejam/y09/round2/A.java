package my.codejam.y09.round2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class A {
	static class Solver {

		private String line;
		private List<String> lines;

		public String getLine() {
			return line;
		}

		Solver() {
		}

		public Solver(String line) {
			this.line = line;
		}

		public Solver(List<String> lines) {
			this.lines = lines;
		}

		public String solve() {

			int n = lines.size();
			int swaps = 0;
			int[] array = new int[n + 1];
			for (int i = 0; i < n; ++i) {

				String temp = lines.get(i);
				int x = temp.lastIndexOf('1') + 1;
				array[i + 1] = x;
				// System.out.println(x);
			}
			boolean ok = false;
			while (!ok) {
				ok = true;
				for (int i = 1; i < n + 1; ++i) {

					if (array[i] > i) {

						int temp = array[i + 1];
						array[i + 1] = array[i];
						array[i] = temp;
						ok = false;
						++swaps;
					}
				}
			}
			return String.valueOf(swaps);
		}

		public void swap(int i, int j) {

			String temp = lines.get(i);
			lines.add(i, lines.get(j));
			lines.add(j, temp);
		}

	}

	public static void main(String[] args) {

		String problem = "A";
		// String inFName = "resource/"+problem+"-small-practice.in";
		// String inFName = "resource/"+problem+"-large-practice.in";
		String inFName = "resource/" + problem + "-small.in";
		// String inFName = "resource/"+problem+"-large.in";
		String outFName = "resource/OUT.out";

		try {
			BufferedReader in = new BufferedReader(new FileReader(inFName));
			PrintWriter out = new PrintWriter(new File(outFName));

			int testCases = Integer.parseInt(in.readLine());
//			Solver solver = new Solver();
			for (int testCase = 1; testCase <= testCases; ++testCase) {

				String result = "No result.";

				String line = in.readLine();

				int n = Integer.parseInt(line);
				List<String> lines = new LinkedList<String>();
				for (int i = 0; i < n; ++i) {
					lines.add(in.readLine());
				}

				System.out.println(EditDistance
						.LD("1232", "3221".toCharArray()));
				// solver = new Solver(lines);
				// result = solver.solve();
				out.println("Case #" + testCase + ": " + result);
			}

			in.close();
			out.flush();
			out.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	static class EditDistance {

		// ****************************
		// Get minimum of three values
		// ****************************

	

		// *****************************
		// Compute Levenshtein distance
		// *****************************

		public static int LD(String s, char[] t) {
			int d[][]; // matrix
			int n; // length of s
			int m; // length of t
			int i; // iterates through s
			int j; // iterates through t
			char s_i; // ith character of s
			char t_j; // jth character of t
			int cost; // cost

			// Step 1

			n = s.length();
			m = t.length;
			if (n == 0) {
				return m;
			}
			if (m == 0) {
				return n;
			}
			d = new int[n + 1][m + 1];

			// Step 2

			for (i = 0; i <= n; i++) {
				d[i][0] = i;
			}

			for (j = 0; j <= m; j++) {
				d[0][j] = j;
			}

			// Step 3

			for (i = 1; i <= n; i++) {

				s_i = s.charAt(i - 1);

				// Step 4

				for (j = 1; j <= m; j++) {

					t_j = t[j - 1];

					// Step 5

					if (s_i == t_j) {
						cost = 0;
					} else {
						int ds = j;
						int num = Integer.parseInt(String.valueOf(t_j));
						if (num > ds)
							cost = num - ds;
						else
							cost = 0;
					}

					// Step 6
//					int min = Integer.MAX_VALUE;

					int mi;
					int a = d[i - 1][j] + 1;
					int b = d[i][j - 1] + 1;
					int c = d[i - 1][j - 1] + cost;

					mi = a;
					if (b < mi) {
						mi = b;
					}
					if (c < mi) {
						mi = c;
						if (j - 1 > -1 && j < t.length) {
							t[j - 1] = t[j];
							t[j] = t_j;
						}

					}

					d[i][j] = mi;

				}

			}

			// Step 7
System.out.println(t);
			return d[n][m];

		}

	}
}
