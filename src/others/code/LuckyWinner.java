package others.code;

import java.math.BigInteger;

public class LuckyWinner {
	public String findProbability(int[] n, int k) {

		BigInteger s = BigInteger.ZERO;
		for (long c : n) {
			s = s.add(BigInteger.valueOf(c));
		}
		int len = n.length;
		BigInteger[] nom = new BigInteger[len];
		BigInteger[] den = new BigInteger[len];

		nom[0] = BigInteger.valueOf(n[0]);
		den[0] = s;
		norm(nom, den, 0);
		BigInteger[] nomSum = new BigInteger[] { nom[0] };
		BigInteger[] denSum = new BigInteger[] { den[0] };
		for (int i = 1; i < len; i++) {
			nom[i] = denSum[0].subtract(nomSum[0]).multiply(
					BigInteger.valueOf(n[i]));
			den[i] = denSum[0].multiply(s);
			norm(nom, den, i);
			BigInteger nn = nomSum[0].multiply(den[i]).add(
					(denSum[0].multiply(nom[i])));
			BigInteger dn = den[i].multiply(denSum[0]);
			nomSum[0] = nn;
			denSum[0] = dn;
			norm(nomSum, denSum, 0);
		}
		BigInteger a = nom[k - 1];
		BigInteger b = den[k - 1];
		BigInteger c = nomSum[0];
		BigInteger d = denSum[0];

		nomSum[0] = a.multiply(d);
		denSum[0] = b.multiply(c);

		norm(nomSum, denSum, 0);
		return nomSum[0] + "/" + denSum[0];
	}

	static void norm(BigInteger[] nom, BigInteger[] den, int i) {
		BigInteger gcd = nom[i].gcd(den[i]);
		nom[i] = nom[i].divide(gcd);
		den[i] = den[i].divide(gcd);
	}

	public static void main(String[] args) {
		System.out.println(new LuckyWinner().findProbability(new int[] { 1, 1 }, 2));
	}

}
