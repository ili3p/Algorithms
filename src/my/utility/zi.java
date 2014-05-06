package my.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class zi {
	public static void main(String[] args) throws IOException {
		new zi().run();
	}

	StreamTokenizer in;
	PrintWriter out;

	int nextInt() throws IOException {
		in.nextToken();
		return (int) in.nval;
	}

	void run() throws IOException {
		in = new StreamTokenizer(new BufferedReader(new InputStreamReader(
				System.in)));
		out = new PrintWriter(new OutputStreamWriter(System.out));
		solve();
		out.flush();
	}
	@SuppressWarnings("unused")
	void solve() throws IOException {
		int first = nextInt();
		int n = nextInt();
		int[] a = new int[n];

		a[0] = first;

		for (int i = 1; i < n; ++i) {

			
			
			int sum = getSum(4 * a[i - 1]);
			int sum1 = getSum(a[i-1]+1);

		}
		out.print(a[n - 1]);
	}

	private int getSum(int i) {

		Integer[] digits = getDigits(i);
		int sum = 0;

		for (Integer e : digits) {
			sum += e;
		}

		return sum;
	}

	private Integer[] getDigits(int i) {

		int n = i;
		List<Integer> digi = new ArrayList<Integer>();

		while (n > 0) {
			digi.add(n % 10);
			n /= 10;
		}

		return digi.toArray(new Integer[0]);
	}
}