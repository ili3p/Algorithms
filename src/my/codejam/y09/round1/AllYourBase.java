package my.codejam.y09.round1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

public class AllYourBase {

	static void runIt() throws IOException {

		String inFName = "A-large.in";
		String outFName = "A-large.out";
		// String inFName = "New Text Document.txt";
		BufferedReader in = new BufferedReader(new FileReader(inFName));
		PrintWriter out = new PrintWriter(new File(outFName));

		int testCases = Integer.parseInt(in.readLine());

		for (int i = 0; i < testCases; ++i) {
			BigInteger sum = BigInteger.ZERO;
			String line = in.readLine();
			char[] cifri = line.toCharArray();
			int[] cif = new int[line.length()];
			Map<Character, Integer> brojki = new TreeMap<Character, Integer>();
			for (int j = 0; j < cifri.length; ++j) {
				if (!brojki.containsKey(cifri[j])) {
					int n = brojki.size();
					if (n == 1)
						n = 0;
					else if (n == 0)
						n = 1;
					brojki.put(cifri[j], n);
					cif[j] = n;
				} else {
					cif[j] = brojki.get(cifri[j]);
				}
			}
			int base = brojki.size();
			if (base == 1)
				base++;
			int s = 0;
			for (int k = cif.length - 1; k > -1; --k) {

				if (cif[k] != 0) {

					BigInteger val = BigInteger.valueOf(cif[k]);
					BigInteger m = BigInteger.valueOf(base);
					m = m.pow(s);
					val = val.multiply(m);
					sum = sum.add(val);

				}
				++s;
			}
			System.out.println(sum.toString());

			out.println("Case #" + (i + 1) + ": " + sum.toString());
		}

		in.close();
		out.flush();
		out.close();
	}

	public static void main(String[] args) {

		try {
			AllYourBase.runIt();
		} catch (IOException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}

	class pom {
		public int value;
		public int pos;

		public pom(int p, int v) {
			value = v;
			p = pos;
		}

		public String toString() {

			return String.valueOf(pos) + "= " + String.valueOf(value);

		}
	}
	/*
	 * Collections.sort(nums, new Comparator<pom>() { public int compare(pom n1,
	 * pom n2) { int m = n1.value - n2.value;
	 * 
	 * return m; } });
	 */
}
