package my.utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class ReadWriteFile {
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

			for (int i = 0; i < n-1; ++i) {

				String temp = lines.get(i);
				
				char x = temp.charAt(i + 1);

				if (x == '1') {
//					if (i + 1 == n) {
//						swap(i, i - 1);
//					} else {
						swap(i, i + 1);
//					}
					++swaps;
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
//		String inFName = "resource/"+problem+"-small-practice.in";
//		 String inFName = "resource/"+problem+"-large-practice.in";
		 String inFName = "resource/"+problem+"-small.in";
//		 String inFName = "resource/"+problem+"-large.in";
		String outFName = "resource/OUT.out";

		try {
			BufferedReader in = new BufferedReader(new FileReader(inFName));
			PrintWriter out = new PrintWriter(new File(outFName));

			int testCases = Integer.parseInt(in.readLine());
Solver solver = new Solver();
			for (int testCase = 1; testCase <= testCases; ++testCase) {

				String result = "No result.";

				String line = in.readLine();
				int n = Integer.parseInt(line);
				List<String> lines = new LinkedList<String>();
				for (int i = 0; i < n; ++i) {
					lines.add(in.readLine());
				}
				solver = new Solver(lines);
				result = solver.solve();
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
}
