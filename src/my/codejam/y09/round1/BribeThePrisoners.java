package my.codejam.y09.round1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Solver implements Runnable{
	
	public String line;
	public String line2;
	public Integer theSum;
	
	public Integer getSum(){
		return theSum;
	}
	public void setLine(String line) {
		this.line = line;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public Integer solve()  {
		List<Integer> m = new ArrayList<Integer>();
		
		String[] pQ = line.split(" ");
		int pris = Integer.parseInt(pQ[0]);
		line = line2;
		String[] n = line.split(" ");
		int[] nums = new int[n.length];
		for (int k = 0; k < n.length; ++k) {
			nums[k] = Integer.parseInt(n[k]);
		}
		PermutationGenerator p = new PermutationGenerator(n.length);
		while (p.hasMore()) {
			List<Integer> released = new ArrayList<Integer>();
			int sum = 0;
			int[] cel = p.getNext();
			for (int mn : cel) {

				released.add(nums[mn]);
				Collections.sort(released);
				int k = released.indexOf(nums[mn]);
				int before = nums[mn], after = nums[mn];
				if (k != 0) {
					before = released.get(k - 1);
				}
				if (k + 1 < released.size())
					after = released.get(k + 1);
				if (before < nums[mn]) {
					sum += nums[mn] - before - 1;
				} else
					sum += nums[mn] - 1;

				if (after > nums[mn]) {
					sum += after - nums[mn] - 1;
				} else
					sum += pris - nums[mn];

			}
			m.add(sum);
		}

		Integer sum = Collections.min(m);
		theSum = sum;
		return sum;
	}
	
	static class PermutationGenerator {

			private int[] a;
			private BigInteger numLeft;
			private BigInteger total;

			// -----------------------------------------------------------
			// Constructor. WARNING: Don't make n too large.
			// Recall that the number of permutations is n!
			// which can be very large, even when n is as small as 20 --
			// 20! = 2,432,902,008,176,640,000 and
			// 21! is too big to fit into a Java long, which is
			// why we use BigInteger instead.
			// ----------------------------------------------------------

			public PermutationGenerator(int n) {
				if (n < 1) {
					throw new IllegalArgumentException("Min 1");
				}
				a = new int[n];
				total = getFactorial(n);
				reset();
			}

			// ------
			// Reset
			// ------

			public void reset() {
				for (int i = 0; i < a.length; i++) {
					a[i] = i;
				}
				numLeft = new BigInteger(total.toString());
			}

			// ------------------------------------------------
			// Return number of permutations not yet generated
			// ------------------------------------------------

			public BigInteger getNumLeft() {
				return numLeft;
			}

			// ------------------------------------
			// Return total number of permutations
			// ------------------------------------

			public BigInteger getTotal() {
				return total;
			}

			// -----------------------------
			// Are there more permutations?
			// -----------------------------

			public boolean hasMore() {
				return numLeft.compareTo(BigInteger.ZERO) == 1;
			}

			// ------------------
			// Compute factorial
			// ------------------

			private static BigInteger getFactorial(int n) {
				BigInteger fact = BigInteger.ONE;
				for (int i = n; i > 1; i--) {
					fact = fact.multiply(new BigInteger(Integer.toString(i)));
				}
				return fact;
			}

			// --------------------------------------------------------
			// Generate next permutation (algorithm from Rosen p. 284)
			// --------------------------------------------------------

			public int[] getNext() {

				if (numLeft.equals(total)) {
					numLeft = numLeft.subtract(BigInteger.ONE);
					return a;
				}

				int temp;

				// Find largest index j with a[j] < a[j+1]

				int j = a.length - 2;
				while (a[j] > a[j + 1]) {
					j--;
				}

				// Find index k such that a[k] is smallest integer
				// greater than a[j] to the right of a[j]

				int k = a.length - 1;
				while (a[j] > a[k]) {
					k--;
				}

				// Interchange a[j] and a[k]

				temp = a[k];
				a[k] = a[j];
				a[j] = temp;

				// Put tail end of permutation after jth position in increasing
				// order

				int r = a.length - 1;
				int s = j + 1;

				while (r > s) {
					temp = a[s];
					a[s] = a[r];
					a[r] = temp;
					r--;
					s++;
				}

				numLeft = numLeft.subtract(BigInteger.ONE);
				return a;

			}

		}

	@Override
	public void run() {
		solve();
		
	}
}
public class BribeThePrisoners {

	public static void runIt() throws IOException {

		String inFName = "resource/C-large-practice.in";
		String outFName = "C-large.out";

		BufferedReader in = new BufferedReader(new FileReader(inFName));
		PrintWriter out = new PrintWriter(new File(outFName));

		int testCases = Integer.parseInt(in.readLine());
List<String> st = new ArrayList<String>();
int numThreads = Runtime.getRuntime().availableProcessors();
ExecutorService executor = Executors.newFixedThreadPool(numThreads);
		for (int i = 0; i < testCases; ++i) {
			
			String line = in.readLine();
			String line2 = in.readLine();
			Solver s = new Solver();
			s.setLine(line);
			s.setLine2(line2);	
			
			executor.execute(s);
//			s.run();
			
			Integer sum = 2;
			
			st.add("Case #" + (i + 1) + ": " + sum.toString());
		}
		for(String s:st){
			out.println(s);
		}
		in.close();
		out.flush();
		out.close();
	}

	public static void main(String[] args) {

		try {
			BribeThePrisoners.runIt();
		} catch (IOException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}

	class pom {
		public int value;
		public int pos;

		public pom(int p, int v) {
			value = v;
			p = pos;
		}

		public String toString() {

			return String.valueOf(pos) + "= " + String.valueOf(value);

		}
	}

/*
		 * Collections.sort(nums, new Comparator<pom>() { public int compare(pom
		 * n1, pom n2) { int m = n1.value - n2.value;
		 * 
		 * return m; } });
		 */

}
