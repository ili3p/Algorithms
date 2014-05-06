package others.code;

import java.util.ArrayList;

public class CoinChange {
public static void main(String[] args) {
	int []denoms = {1,3,5,6,10};
	int target = 13;
	CoinChange cc = CoinChange.findOptimalChange(target, denoms);
	for(String [] ss:cc.optimalChange)
	for(String s:ss)
	if(s!=null)System.out.println(s);
	
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

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}
	/**
	 * Copy of the denominations that was used to generate this solution
	 */
	public int[] denoms;

	public CoinChange(int target, int[] denoms) {
		
		OPT = new int[100][100];
		optimalChange = new String[100][100];
		
		this.target = target;
		this.denoms = denoms;
	}

	/**
	 * Find the optimal solution for a given target value and the set of
	 * denominations
	 * 
	 * @param target
	 * @param denoms
	 * @return
	 */
	public static CoinChange findOptimalChange(int target, int[] denoms) {
		CoinChange soln = new CoinChange(target, denoms);
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
					if (x2 <= target
							&& (1 + soln.OPT[i][ix] < targetWithPrevDenomiation)) {
						String temp = soln.optimalChange[i][ix] + denoms[i]
								+ " ";
						soln.optimalChange[i][j] = temp;
						soln.OPT[i][j] = 1 + soln.OPT[i][ix];
					} else {
						soln.optimalChange[i][j] = soln.optimalChange[i - 1][j]
								+ " ";
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
}
