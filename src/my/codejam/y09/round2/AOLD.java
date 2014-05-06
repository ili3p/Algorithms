package my.codejam.y09.round2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AOLD {

	static class Solver implements Callable<String> {

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

		@Override
		public String call() throws Exception {

			int n = lines.size();
			int swaps = 0;

			for (int i = 0; i < n; ++i) {

				String temp = lines.get(i);
				char x = temp.charAt(i + 1);

				if (x == '1') {
					if (i + 1 == n) {
						swap(i, i - 1);
					} else {
						swap(i, i + 1);
					}
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
		String inFName = "resource/" + problem + "-small.in";
		// String inFName = "resource/" + problem + "-large.in";

		String outFName = "resource/OUT.out";

		try {
			BufferedReader in = new BufferedReader(new FileReader(inFName));
			PrintWriter out = new PrintWriter(new File(outFName));

			int testCases = Integer.parseInt(in.readLine());

			int numThreads = Runtime.getRuntime().availableProcessors();
			ExecutorService executor = Executors.newFixedThreadPool(numThreads);

			Solver solver = new Solver();
			List<Solver> tasks = new ArrayList<Solver>();

			for (int testCase = 1; testCase <= testCases; ++testCase) {

				String line = in.readLine();
				int n = Integer.parseInt(line);
				List<String> lines = new LinkedList<String>();
				for (int i = 0; i < n; ++i) {
					lines.add(in.readLine());
				}
				solver = new Solver(lines);
				tasks.add(solver);
			}

			List<Future<String>> results = executor.invokeAll(tasks);
			executor.shutdown();

			int testCase = 1;
			for (Future<String> future : results) {
				if (future.isDone()) {
					String result = future.get();
					out.println("Case #" + testCase + ": " + result);
					++testCase;
				}
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
