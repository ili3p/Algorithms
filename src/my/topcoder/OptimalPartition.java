package my.topcoder;
import java.util.*;

public class OptimalPartition {
	private int[] nextSubset(int n, int[] subset) {
		int l = subset.length;
		int[] result = Arrays.copyOf(subset, l);
		boolean newSubset = false;

		for (int k = l - 1; k > -1; --k) {
			int d = l - 1 - k;
			int a = subset[k];
			if (a + 1 <= (n - d)) {
				int j = 1;
				for (int i = k; i < l; ++i) {
					result[i] = a + j;
					++j;
					newSubset = true;
				}
				break;
			}
		}
		return newSubset ? result : null;
	}

	public int minimalDifference(int[] setOfNumbers) {
		int n = setOfNumbers.length;
		
		return 0;
	}
}
