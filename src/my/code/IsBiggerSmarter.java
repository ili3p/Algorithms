package my.code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IsBiggerSmarter {
	public static void main(String[] args) throws IOException {

		final BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));

		String line;

		int i = 1;
		List<Elephant> elephants = new ArrayList<Elephant>();
		while ((line = reader.readLine()) != null) {

			int weight = Integer.parseInt(line.split(" ")[0]);
			int IQ = Integer.parseInt(line.split(" ")[1]);
			Elephant e = new Elephant(weight, IQ);
			elephants.add(e);
			++i;
		}
		Solver solve = new Solver();

		System.out.println(solve.getResult(elephants.toArray(new Elephant[0])));

		
	}

	public static class Solver {

		public boolean cond(Elephant e1, Elephant e2) {

			return (e1.weight > e2.weight && e1.IQ < e2.IQ);
		}

		public String getResult(Elephant[] elephants) {

			int n = elephants.length;
			int[] dp = new int[n];
			dp[0] = 1;
			
			for (int i = 1; i < n; ++i) {

				if (i == 1 && cond(elephants[1], elephants[0])) {
					
					dp[1] = dp[0] + 1;
					
				} else if (cond(elephants[i], elephants[i - 1])) {
					
					dp[i] = dp[i-1]+1;
				}
			}
			return null;
		}

	}

	private static class Elephant {

		int weight;
		int IQ;

		public Elephant(int weight, int iQ) {
			super();
			this.weight = weight;
			IQ = iQ;
		}

	}
}
