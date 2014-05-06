package my.codefu.y11.comminity;

public class ScrambledAscii {

	public static String weights(int[] charValues, String sentence) {
		int aASCII = 97;
		String[] words = sentence.split(" ");
		StringBuilder result = new StringBuilder();
		for (String word : words) {
			char[] letters = word.toCharArray();
			int sum = 0;
			for (char c : letters) {
				sum += charValues[c - aASCII];
			}
			result.append(sum + " ");
		}

		return new String(result).trim();
	}

	public static void main(String[] args) {
		System.out.println(weights(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26 },
				"a ab abcd dddd"));
	}
}