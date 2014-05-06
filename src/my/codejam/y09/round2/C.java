package my.codejam.y09.round2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class C {

	static class Solver implements Callable<String> {

		private String line;

		public String getLine(){return line;}
		Solver() {
		}

		public Solver(String line) {
			this.line = line;
		}

		@Override
		public String call() throws Exception {

			
			
			return null;
		}

	}

	public static void main(String[] args) {

		String problem = "C";
		String inFName = "resource/" + problem + "-small.in";
	//  String inFName = "resource/" + problem + "-large.in";
		
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
				solver = new Solver(line);
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
