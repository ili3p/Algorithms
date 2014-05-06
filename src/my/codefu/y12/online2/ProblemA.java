package my.codefu.y12.online2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;

public class ProblemA {

	public String shift(String word, int n) {

		char[] s = word.toCharArray();
		int a = 'a';
		int z = 'z';
		StringBuilder res = new StringBuilder();

		for (int i = 0; i < s.length; i++) {

			char cd = (char) (((s[i] - a + n) % (z - a + 1) + a));
			res.append(cd);

		}

		return res.toString();
	}

	public String getLast(String[] times) throws ParseException {

		String res = "";
		SimpleDateFormat parser = new SimpleDateFormat("HH:mm:ss");
		Calendar max = null;
		for (String string : times) {
			String[] t = string.split("-");
			Calendar c = Calendar.getInstance();
			c.setTime(parser.parse(t[1]));
			int hs = c.get(c.HOUR_OF_DAY);
			int ms = c.get(c.MINUTE);
			int ss = c.get(c.SECOND);

			Calendar cc = Calendar.getInstance();
			cc.setTime(parser.parse(t[0]));
			hs -= cc.get(cc.HOUR_OF_DAY);
			ms -= cc.get(cc.MINUTE);
			ss -= cc.get(cc.SECOND);

			Calendar ssd = Calendar.getInstance();
			ssd.set(ssd.HOUR_OF_DAY, hs);
			ssd.set(ssd.MINUTE, ms);
			ssd.set(ssd.SECOND, ss);

			if (max == null || ssd.after(max)) {
				max = ssd;
				res = parser.format(max.getTime());
			}
		}

		return res;
	}

	public int split(int[] coins) {

		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();

		Arrays.sort(coins);
		for (int i = coins.length-1; i > -1; i--) {
			int coin = coins[i];
			int sumA = getSum(a);
			int sumB = getSum(b);

			if (sumA < sumB) {
				a.add(coin);
			} else {
				b.add(coin);
			}
		}
		return Math.abs(getSum(a) - getSum(b));
	}

	private int getSum(ArrayList<Integer> a) {
		int sum = 0;
		for (Integer integer : a) {
			sum += integer;

		}
		return sum;
	}

	public int max(int cols, int rows, int k, int m) {
		int[] primes = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113,
				127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271,
				277, 281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443,
				449, 457, 461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619,
				631, 641, 643, 647, 653, 659, 661, 673, 677, 683, 691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769, 773, 787, 797, 809, 811, 821,
				823, 827, 829, 839, 853, 857, 859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941, 947, 953, 967, 971, 977, 983, 991, 997, 1009, 1013,
				1019, 1021, 1031, 1033, 1039, 1049, 1051, 1061, 1063, 1069, 1087, 1091, 1093, 1097, 1103, 1109, 1117, 1123, 1129, 1151, 1153, 1163, 1171, 1181,
				1187, 1193, 1201, 1213, 1217, 1223, 1229, 1231, 1237, 1249, 1259, 1277, 1279, 1283, 1289, 1291, 1297, 1301, 1303, 1307, 1319, 1321, 1327, 1361,
				1367, 1373, 1381, 1399, 1409, 1423, 1427, 1429, 1433, 1439, 1447, 1451, 1453, 1459, 1471, 1481, 1483, 1487, 1489, 1493, 1499, 1511, 1523, 1531,
				1543, 1549, 1553, 1559, 1567, 1571, 1579, 1583, 1597, 1601, 1607, 1609, 1613, 1619, 1621, 1627, 1637, 1657, 1663, 1667, 1669, 1693, 1697, 1699,
				1709, 1721, 1723, 1733, 1741, 1747, 1753, 1759, 1777, 1783, 1787, 1789, 1801, 1811, 1823, 1831, 1847, 1861, 1867, 1871, 1873, 1877, 1879, 1889,
				1901, 1907, 1913, 1931, 1933, 1949, 1951, 1973, 1979, 1987, 1993, 1997, 1999, 2003, 2011, 2017, 2027, 2029, 2039, 2053, 2063, 2069, 2081, 2083,
				2087, 2089, 2099, 2111, 2113, 2129, 2131, 2137, 2141, 2143, 2153, 2161, 2179, 2203, 2207, 2213, 2221, 2237, 2239, 2243, 2251, 2267, 2269, 2273,
				2281, 2287, 2293, 2297, 2309, 2311, 2333, 2339, 2341, 2347, 2351, 2357, 2371, 2377, 2381, 2383, 2389, 2393, 2399, 2411, 2417, 2423, 2437, 2441,
				2447, 2459, 2467, 2473, 2477, 2503, 2521, 2531, 2539, 2543, 2549, 2551, 2557, 2579, 2591, 2593, 2609, 2617, 2621, 2633, 2647, 2657, 2659, 2663,
				2671, 2677, 2683, 2687, 2689, 2693, 2699, 2707, 2711, 2713, 2719, 2729, 2731, 2741 };

		// rows+=1;
		// cols+=1;
		int[][] B = new int[rows + 1][cols + 1];
		int[][] C = new int[rows + 1][cols + 1];

		for (int i = 1; i < rows + 1; ++i) {
			B[i][0] = 0;
		}
		for (int i = 1; i < cols + 1; ++i) {
			B[0][i] = 0;
		}

		int pIndex = 0;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				int A = primes[pIndex];
				pIndex++;
				B[i + 1][j + 1] = ((A * k) % m) - m / 2;
				System.out.print(B[i + 1][j + 1] + ",");
			}
			System.out.println();
		}

		C[1][1] = B[1][1];
		for (int i = 1; i < rows + 1; ++i) {
			C[i][0] = 0;
		}
		for (int i = 1; i < cols + 1; ++i) {
			C[0][i] = 0;
		}

		for (int i = 1; i < rows + 1; ++i) {
			C[i][1] = C[i - 1][1] + B[i][1];
		}

		for (int i = 1; i < cols + 1; ++i) {
			C[1][i] = C[1][i - 1] + B[1][i];
		}

		for (int i = 1; i < rows + 1; ++i) {
			for (int j = 1; j < cols + 1; ++j) {
				C[i][j] = C[i][j - 1] + C[i - 1][j] - C[i - 1][j - 1] + B[i][j];
			}
		}
		int max = B[1][1];
		for (int i = 1; i < rows + 1; ++i) {// r
			for (int j = 1; j < cols + 1; ++j) {// c
				for (int g = 0; g < rows + 1 - i; ++g) {// h
					for (int f = 0; f < cols + 1 - j; ++f) {// w
						int temp = C[i + g][j + f] - C[i - 1][j + f] - C[i + g][j - 1] + C[i - 1][j - 1];
						if (temp > max) {
							max = temp;
						}
					}
				}
			}
		}

		return max;
	}

	public static long sumsLowerBound(long[] a, long b) {
		int n = a.length;
		int sizeL = 1 << (n / 2);
		int sizeR = 1 << (n - n / 2);
		long[] sumsL = new long[sizeL];
		long[] sumsR = new long[sizeR];
		for (int i = 0; i < sizeL; ++i)
			for (int j = 0; j < n / 2; ++j)
				if ((i & (1 << j)) > 0)
					sumsL[i] += a[j];
		for (int i = 0; i < sizeR; ++i)
			for (int j = 0; j < n - n / 2; ++j)
				if ((i & (1 << j)) > 0)
					sumsR[i] += a[j + n / 2];
		Arrays.sort(sumsL);
		Arrays.sort(sumsR);
		int left = 0;
		int right = sizeR - 1;
		long cur = Long.MIN_VALUE;
		while (left < sizeL && right >= 0) {
			if (sumsL[left] + sumsR[right] <= b) {
				cur = Math.max(cur, sumsL[left] + sumsR[right]);
				++left;
			} else {
				--right;
			}
		}
		return cur;
	}

	public static void main(String[] args) {
		ProblemA me = new ProblemA();
		 System.out.println(me.split(new int[] {25,5,15,62,9,87,3,35,44,9}));

	}
}
