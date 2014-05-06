package my.topcoder;
import java.util.*;

public class SplitVowels {
	public String split(String sentence) {
		char[] s = new char[] { 'A', 'E', 'I', 'O', 'U', 'Y', 'a', 'e', 'i',
				'o', 'u', 'y' };
		Set<Character> set = new HashSet<Character>();

		for (int i = 0; i < s.length; i++) {
			char c = s[i];
			set.add(c);
		}
		char[] c = sentence.toCharArray();
		StringBuilder sa = new StringBuilder();
		StringBuilder v = new StringBuilder();
		for (int i = 0; i < c.length; i++) {
			if (set.contains(c[i])) {
				v.append(c[i]);
			} else {
				if (c[i] == ' ') {
					sa.append(v);
					v = new StringBuilder();

				}
				sa.append(c[i]);
			}

		}
		return sa.toString() + v.toString();
	}

	public static void main(String[] args) {
		SplitVowels s = new SplitVowels();
		System.out.println(s.split("Hello World"));
	}
}
