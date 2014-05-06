package my.codejam.y09.round1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

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

public class NextNumber {

	public static void runIt() {

	}

	public static void main(String[] args) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader("s.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("output2.txt"));
		String line;
		List<pom> nums = new LinkedList<pom>();
		reader.readLine();
		int n = 0;
		while ((line = reader.readLine()) != null) {
			int zero = -1;

			int brcifri = line.length();
			++n;
			int[] num = new int[10];
			for (int i = 0; i < line.length(); ++i) {
				num[i] = Integer.parseInt(line.substring(i, i + 1));
				if (num[i] != 0) {
					pom f = new pom(i, num[i]);
					nums.add(f);
				}
				if (num[i] == 0)
					zero = i;
			}
			Collections.sort(nums, new Comparator<pom>() {
				public int compare(pom n1, pom n2) {
					int m = n1.value - n2.value;

					return m;
				}
			});
			System.out.println("Here" + nums);
			boolean ok = false;
			while (!ok) {
				for (int index = 0; index < nums.size() && !ok; ++index) {
					pom cur = nums.get(index);
					if (cur.pos > zero)
						ok = moveIt(cur, num, brcifri);
					else {
						System.out.println("T " + num[cur.pos]);
						int temp = num[cur.pos];
						num[cur.pos] = num[zero];
						num[zero] = temp;
						ok = true;
					}
				}
			}

			pw.println("Case #" + n + ": " + getNum(line, num));

		}
		pw.flush();
		pw.close();
	}

	private static String getNum(String line, int[] num) {
		StringBuilder sb = new StringBuilder();
		for (int m = 0; m < line.length(); ++m) {

			sb.append(num[m]);
			// System.out.println(sb);
		}
		return (new String(sb));
	}

	private static boolean moveIt(pom cur, int[] num, int brcifri) {
		int i = cur.pos;

		if (i == brcifri - 1)
			return false;
		else {
			int temp = num[i];
			num[i] = num[i + 1];
			num[i + 1] = temp;
			return true;
		}
	}
}