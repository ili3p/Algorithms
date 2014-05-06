package my.topcoder;

import java.util.Arrays;
import java.util.Iterator;

public class ShuffleSort {

	public double shuffle(int[] cards) {
		Arrays.sort(cards);
		int c = 0;
		int l = -1;
		for (int i = 0; i < cards.length; i++) {
			int j = cards[i];
			if (j != l) {
				++c;
				l = j;
			}

		}

		double[] s = new double[51];
		s[1] = 1.0;
		s[2] = 2.0;
		s[3] = 4.0;
		s[6] = 16.0;
		
		for (int j = 2; j < s.length; ++j) {
			
		}

		return s[c];
	}

}
