package my.topcoder;
import java.util.Arrays;

public class ModularInequality {

	public int countSolutions(int[] A, int P) {
		Arrays.sort(A);
		int sum = 0;
		int n = A.length;
		for (int i = 0; i < A.length; i++) {
			sum += Math.abs(A[i]);
		}
		if (sum > P) {
			return 0;
		}
		int count = 1;
		int dif = P - sum;

		if (A[0] >= 0) {
			if (dif > 0) {
				count += dif / n; //negative X
			}
			
		}

		return count;
	}

}
