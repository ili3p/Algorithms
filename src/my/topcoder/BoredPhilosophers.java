package my.topcoder;
import java.util.HashSet;
import java.util.Set;

public class BoredPhilosophers {

	public int[] simulate(String[] text, int N) {

		StringBuilder sb = new StringBuilder();
		int[] result = new int[N];
		for (String t : text) {
			sb.append(t);
		}
		String wholeText = new String(sb);
		String[] words = wholeText.split(" ");

		for (int i = 0; i < N; ++i) {

			Set<String> myMap = new HashSet<String>();
for(int j=words.length-1;j-i > -1;--j){
	int [] w = new int[i+1];
	
	for(int h=0;h<=i;++h){
	w[h] = j-h;
	}

			StringBuilder sb2 = new StringBuilder();
			for (int k : w) {
				sb2.append(words[k]);
				sb2.append(" ");
			}

			String word = new String(sb2);
			word = word.trim();
			if (!myMap.contains(word)) {
				myMap.add(word);
				++result[i];
			}
}
		}
		return result;
	}

}
