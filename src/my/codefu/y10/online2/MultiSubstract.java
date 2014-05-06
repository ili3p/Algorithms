/**
 * 
 */
package my.codefu.y10.online2;

/**
 * @author Ilija Ilievski
 * 
 */
public class MultiSubstract {
	public static int getMinOperations(int M, int S, int T) {

		int status = T;
		int numCalc = 0;
		while (status != 1) {

			while (status % M == 0) {
				status /= M;
				++numCalc;
			}
			if (status == 1) {
				break;
			} else {
				status += S;
				++numCalc;
			}
		}

		return numCalc;
	}

	public static void main(String[] args) {
		System.out.println(getMinOperations(4, 4, 100) );
	}
}