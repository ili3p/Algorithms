package my.topcoder;
public class CentaurCompanyDiv2 {

	public long count(int[] a, int[] b) {
		long[] d = new long[a.length + 1];
		int[] c = new int[a.length + 2];
		for (int i = 0; i < a.length; ++i) {
			++c[a[i]];
			++c[b[i]];
		}
		d[1] = 4;
		for (int i = 1; i < a.length; ++i) {
			if (c[a[i]] > 1 && c[b[i]] > 1) {
				d[i + 1] = d[i] + 4;
			} else {
				d[i + 1] = d[i] * 2 - 1;
			}
		}

		return d[a.length];
	}
}
