package my.codefu.y09;
public class UniqueWords {

	public int count(String list) {

		String[] words = list.split(" ");
		int c = 0;
		for (int ind=0; ind < words.length;++ind) {
			String word = words[ind];
			String zborot = word;
			boolean f = true;
			do {
				word = rollWordLeft(word);
				if (hasSim(word,ind, words)) {
					f = false;
					break;
				}

			} while (zborot.compareTo(word) != 0);
			if (f) {
				do {
					word = rollWordRight(word);
					if (zborot.compareTo(word) != 0 && hasSim(word, ind, words)) {
						f = false;
						break;
					}

				} while (zborot.compareTo(word) != 0);
			}
			if (f) {
				++c;
			}
		}

		return c;
	}

	private String rollWordRight(String word) {
		char[] bukvi = word.toCharArray();
		StringBuilder sb = new StringBuilder();

		sb.append(bukvi[bukvi.length - 1]);

		for (int i = 0; i < bukvi.length - 1; ++i) {
			sb.append(bukvi[i]);
		}

		return new String(sb);
	}

	private boolean hasSim(String word, int ind, String[] words) {

		for (int i=0; i < words.length; ++i) {
			String s  = words[i];
			
			if (word.compareTo(s) == 0 && i!= ind)
				return true;

		}
		return false;
	}

	private String rollWordLeft(String word) {
		char[] bukvi = word.toCharArray();
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < bukvi.length; ++i) {
			sb.append(bukvi[i]);
		}
		sb.append(bukvi[0]);

		return new String(sb);
	}

	public static void main(String[] args) {
		UniqueWords c = new UniqueWords();
		System.out.println(c.  count("a a b c d e") );
	}
}
