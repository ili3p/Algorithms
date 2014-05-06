package my.codefu.y09.winter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReverseSentence {

	public static String reverse(String sentence) {
		
		String words [] = sentence.split(" ");
		List<String> wordsList = new ArrayList<String>();
		for (String word: words) {
			wordsList.add(word);
			
		}
		Collections.reverse(wordsList);
		
		StringBuilder sb = new StringBuilder();
		
		for (String string : wordsList) {
			sb.append(string+" ");
		}
	    return sb.toString().trim();
	  }
	
	public static void main(String[] args) {
System.out.println(reverse("aaaa aaaa"));
	}
}
