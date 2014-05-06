package my.practice;

import java.math.BigInteger;

public class BouncyVeryComplex {

	static final int MOD = 1000007;

	public int count(int expstart, int expend) {
		BigInteger s = upTo(expend).subtract(upTo(expstart)).mod(BigInteger.valueOf(MOD));
		return s.intValue() + 1;
	}

	public BigInteger upTo(int exp) {
		BigInteger x = comb(exp + 10, 10);
		BigInteger y = comb(exp + 9, 9);
		return x.add(y).subtract(BigInteger.valueOf(10 * exp));
	}

	static BigInteger comb(int n, int k) {
		BigInteger bi = BigInteger.ONE;
		// n! / (n-k)! / k!
		for (int t = (n - k) + 1; t <= n; t++) {
			bi = bi.multiply(BigInteger.valueOf(t));
		}
		for (int i = 2; i <= k; i++) {
			bi = bi.divide(BigInteger.valueOf(i));
		}

		return bi;
	}

	public static void main(String[] args) {
		System.out.println(new BouncyVeryComplex().count(1, 10000));
	}
}