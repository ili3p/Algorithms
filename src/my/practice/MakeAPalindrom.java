package my.practice;

public class MakeAPalindrom {

	public static String makeit(String s) {

		char[] result = s.toCharArray();

		for (int ind = 0; ind < s.length() / 2; ++ind) {

			int left = s.charAt(ind);
			int right = s.charAt(s.length() - 1 - ind);

			if (left < right) {
				result[s.length() - 1 - ind] = (char) left;
			} else {
				result[ind] = (char) right;
			}
		}

		return new String(result);
	}
	
	public static void main(String[] args) {
		System.out.println(makeit("abc"));
	}
}