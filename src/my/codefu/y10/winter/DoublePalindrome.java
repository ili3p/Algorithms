package my.codefu.y10.winter;

public class DoublePalindrome {

	public static int countPalindromes(int A, int B, int M, int N) {

		int count = 0;

		for (int currentNumber = M; currentNumber <= N; ++currentNumber) {

			String first = Integer.toString(currentNumber, A);
			String second = Integer.toString(currentNumber, B);

			if (isPalinDrome(first) && isPalinDrome(second)) {
				++count;
			}
		}

		return count;
	}

	private static boolean isPalinDrome(String word) {
		return (word.equals(new StringBuffer(word).reverse().toString()));
	}
	
	public static void main(String[] args) {
		System.out.println(countPalindromes(2, 16, 1, 10000));
	}
}
