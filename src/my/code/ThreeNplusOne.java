package my.code;

//Time Limit ??
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class ThreeNplusOne {
	public static void main(String[] args) throws IOException {

		final BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String line;

		while ((line = reader.readLine()) != null) {

			Solver solve = new Solver();
			String[] tokens = line.split(" ");

			if (tokens.length == 2) {
				int i = Integer.parseInt(tokens[0]);
				int j = Integer.parseInt(tokens[1]);
				solve.iP = i;
				solve.jP = j;
				solve.s = line;
				new Thread(new Solver()).start();
				
			}
		}
	}

	public static class Solver implements Runnable {

		Set<Integer> setCached = Collections
				.synchronizedSet(new TreeSet<Integer>());
		int[] ms = new int[1000000];
		public int iP, jP;
public String s = "not init.";
		public String getResult() {
			int i = iP;
			int j = jP;
			setCached.add(1);
			int max = 1;

			for (int k = j; k >= i; --k) {

				if (setCached.contains(k)) {

					continue;

				} else {

					setCached.add(k);

					if (maxCycle(k) > max) {
						max = maxCycle(k);
					}

				}

			}

			return String.valueOf(max);
		}

		private int maxCycle(int k) {

			int n = k;
			int cycle = 1;

			while (n > 1) {

				setCached.add(n);

				if (n % 2 == 0) {

					n /= 2;

				} else {

					n = n * 3 + 1;
				}
				++cycle;

			}

			return cycle;
		}

		@Override
		public void run() {
			String m =	getResult();
			System.out.println(s + " " + m);
		}
	}
}
