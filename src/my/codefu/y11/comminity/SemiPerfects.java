package my.codefu.y11.comminity;

import java.util.ArrayList;
import java.util.List;

public class SemiPerfects {

	public static int count(int start, int end) {
		int myEnd = 5000;
		boolean[] isPrime = new boolean[myEnd + 1];

		for (int i = 2; i <= myEnd; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; i * i <= myEnd; i++) {

			if (isPrime[i]) {
				for (int j = i; i * j <= myEnd; j++) {
					isPrime[i * j] = false;
				}
			}
		}
		List<Integer> thePrimes = new ArrayList<Integer>();

		for (int i = 2; i <= myEnd; i++) {
			if (isPrime[i]) {
				thePrimes.add(i);
			}
		}
		int semiPerfects = 0;
		for (int i = start; i <= end; ++i) {
			if (isPrime[i]) {
				int ord = thePrimes.indexOf(i)+1;
				String s = String.valueOf(ord);
				boolean isPalin = true;
				for (int ind = 0; ind < s.length() / 2; ++ind) {
					isPalin = s.charAt(ind) == s.charAt(s.length() -1- ind);
				}
				if (isPalin) {
					System.out.println(i);
					++semiPerfects;
				}
			}
		}
		return semiPerfects;
	}

	public static void main(String[] args) {
		System.out.println(count(120, 150));
	}
}
