/**
 * 
 */
package my.code;

/**
 * @category Dynamic programing
 * @author Ilija Ilievski
 * 
 */
public class Alignment {
	public static int LettersEqual(String a, String b) {
		a = a.replace(" ", "");
		b = b.replace(" ", "");
		
		int sizeA = a.length() + 1;
		int sizeB = b.length() + 1;
		int[][] dp = new int[sizeA][sizeB];

		for (int i = 0; i < sizeA; ++i) {
			dp[i][0] = 0;
		}
		for (int j = 0; j < sizeB; ++j) {
			dp[0][j] = 0;
		}
		int i = 1;
		int j = 1;
		for (i = 1; i < sizeA; ++i) {
			for (j = 1; j < sizeB; ++j) {

				int match = (a.charAt(i - 1) == b.charAt(j - 1)) ? 1 : 0;

				dp[i][j] = Math.max(Math.max(dp[i - 1][j - 1] + match,
						dp[i][j - 1]), dp[i - 1][j]);
			}
		}

		return dp[i - 1][j - 1];
	}

	public static void main(String[] args) {
		System.out.println(LettersEqual("G A A T T C A G T T A",
				"G G A T C G A"));
	}
}
