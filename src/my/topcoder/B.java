package my.topcoder;
import java.util.*;

public class B {

	private static HashMap<Integer, Integer> map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new HashMap<Integer, Integer>();
		int n = sc.nextInt();
		int[] a = new int[n];
		int i = 0;
		while (i < n) {
			int k = sc.nextInt();
			a[i] = k;
			++i;
		}
		sc.close();

		long c = 0;
		for (i = 0; i < a.length; ++i) {
			for (int j = i + 1; j < a.length; ++j) {
				if (f(a[i]) == f(a[j])) {
					++c;
				}
			}
		}

		System.out.println(c);
	}

	public static int f(int x) {
		int c = 0;
		int n = x;

		while (true) {
			if (map.containsKey(n)) {
				if (map.size() < 200000) {
					map.put(x, map.get(n) + c);
				}
				return map.get(n) + c;
			} else {
				if (n == 1) {
					++c;
					break;
				}
				if (n == 0) {
					break;
				}
				if (n % 2 == 1) {
					++c;
					--n;
				} else {
					while (n % 2 == 0) {
						n /= 2;
						if (map.containsKey(n)) {
							if (map.size() < 200000) {
								map.put(x, map.get(n) + c);
							}
							return map.get(n) + c;
						}
					}
				}
			}
		}
		if (map.size() < 200000) {
			map.put(x, c);
		}
		return c;
	}
}