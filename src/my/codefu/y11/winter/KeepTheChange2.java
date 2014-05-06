package my.codefu.y11.winter;

import java.util.ArrayList;

public class KeepTheChange2 {
	
	
	
	public String getOptimumChange(int amount, int[] types) {
		CoinChangeAnswer s = findOptimalChange(amount, types);
		s.printAllPossibleCombos();
		return "";
	}

	public static void main(String[] args) {
		KeepTheChange2 s = new KeepTheChange2();
		s.getOptimumChange(28, new int[] { 1, 2, 5 });
	}

	public CoinChangeAnswer findOptimalChange(int target, int[] denoms) {
		CoinChangeAnswer soln = new CoinChangeAnswer(target, denoms);
		StringBuilder sb = new StringBuilder();

		// initialize the solution structure
		for (int i = 0; i < soln.OPT[0].length; i++) {
			soln.OPT[0][i] = i;
			soln.optimalChange[0][i] = sb.toString();
			sb.append(denoms[0] + " ");
		}

		// Read through the following for more details on the explanation
		// of the algorithm.
		// http://condor.depaul.edu/~rjohnson/algorithm/coins.pdf
		for (int i = 1; i < denoms.length; i++) {
			for (int j = 0; j < target + 1; j++) {
				int value = j;
				int targetWithPrevDenomiation = soln.OPT[i - 1][j];
				int ix = (value) - denoms[i];
				if (ix >= 0 && (denoms[i] <= value)) {
					int x2 = denoms[i] + soln.OPT[i][ix];
					if (x2 <= target && (1 + soln.OPT[i][ix] < targetWithPrevDenomiation)) {
						String temp = soln.optimalChange[i][ix] + denoms[i] + " ";
						soln.optimalChange[i][j] = temp;
						soln.OPT[i][j] = 1 + soln.OPT[i][ix];
					} else {
						soln.optimalChange[i][j] = soln.optimalChange[i - 1][j] + " ";
						soln.OPT[i][j] = targetWithPrevDenomiation;
					}
				} else {
					soln.optimalChange[i][j] = soln.optimalChange[i - 1][j];
					soln.OPT[i][j] = targetWithPrevDenomiation;
				}
			}
		}
		return soln;
	}

	public class CoinChangeAnswer {
		public CoinChangeAnswer(int target, int[] denoms) {
			this.target = target;
			this.denoms = denoms;
			optimalChange = new String[denoms.length][target + 1];
			OPT = new int[denoms.length][target + 1];
		}

		public int OPT[][]; // contains the optimal solution
		// during every recurrence step.
		public String optimalChange[][]; // string representation of optimal
		// solutions.

		/**
		 * List of all possible solutions for the target
		 */
		public ArrayList<String> allPossibleChanges = new ArrayList<String>();

		/**
		 * The target amount.
		 */
		private int target;

		/**
		 * Copy of the denominations that was used to generate this solution
		 */
		public int[] denoms;

		public void printAllPossibleCombos() {
			if (allPossibleChanges.size() > 0) {
				System.out.println("All possible change(s) Target=" + target + ", Denominations=" + denomString());
				int i = 1;
				for (String s : allPossibleChanges) {
					System.out.println(i + ") " + s);
					i++;
				}
				System.out.println();
			} else {
				System.out.println("No change for target=" + target + ", Denominations=" + denomString());
			}

		}

		public String denomString() {
			StringBuilder sb = new StringBuilder();
			for (int i : denoms) {
				sb.append(i + " ");
			}
			return sb.toString();
		}
	}
}