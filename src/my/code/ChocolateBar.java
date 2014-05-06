package my.code;
import java.util.*;

public class ChocolateBar {

	public int maxLength(String letters) {
		char[] l = letters.toCharArray();
		Set<Character> set = new HashSet<Character>();
		int max = -1;
		int n = letters.length();
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n && n - j > i; ++j) {

				String s = letters.substring(i, n - j);
				set = getSet(s);
				if (set.size() == s.length()) {
					max = Math.max(s.length(), max);
				}
			}
			if (max == n) {
				break;
			}
		}

		return max;
	}

	private Set<Character> getSet(String s) {
		Set<Character> set = new HashSet<Character>();
		for (int i = 0; i < s.length(); ++i)
			set.add(s.charAt(i));
		return set;
	}

}
