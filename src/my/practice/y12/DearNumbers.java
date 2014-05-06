package my.practice.y12;
import java.util.*;
import java.math.*;

public class DearNumbers {

	public int dearestNumber(int b, int e, int m) {

		int bestDear = -1;
		int bestNum = b;
		List<Integer> primes = range(Math.max(b - m - 1, 1), e);
		// 2,3,5,7
		for (int i = b; i <= e; ++i) {
			int dear = getDear(primes, i, m);
			if (dear > bestDear) {
				bestNum = i;
				bestDear = dear;
				if (bestDear >= m) {
					return bestNum;
				}
			}
		}
		return bestNum;
	}

	private int getDear(List<Integer> primes, int i, int m) {
		int ind = primes.indexOf(i);
		int res = 0;

		for (Integer prime : primes) {
			if (prime > i - m) {
				++res;
			}
			if(prime >= i){
				break;
			}
		}
		// if (ind != -1) {
		// res = ind;
		// } else {
		// BigInteger s = new BigInteger(String.valueOf(i));
		// s = s.nextProbablePrime();
		// int k = s.intValue();
		// while (!isPrime(k)) {
		// s = s.nextProbablePrime();
		// k = s.intValue();
		// }
		// res = primes.indexOf(k);
		// // res = res == -1 ? primes.size() : res;
		// }
		return Math.min(res, m);
	}

	private List<Integer> range(int from, int to) {
		List<Integer> result = new ArrayList<Integer>(Math.min((to - from), 1000000));
		BigInteger s = new BigInteger(String.valueOf(from));
		while (s.intValue() <= to) {
			int pr = s.intValue();
			if (pr != 1 || isPrime(pr)) {
				result.add(pr);
			}
			s = s.nextProbablePrime();
		}

		return result;
	}

	public static boolean isPrime(long n) {
		boolean prime = true;
		if (n == 1) {
			return false;
		}
		for (long i = 3; i <= Math.sqrt(n); i += 2)
			if (n % i == 0) {
				prime = false;
				break;
			}
		if ((n % 2 != 0 && prime && n > 2) || n == 2) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// System.out.println((new DearNumbers().dearestNumber(91963, 924123,
		// 102277)));
		System.out.println((new DearNumbers().dearestNumber(4, 10, 5)));
	}
}
