package my.codejam.y12.round1b;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class ProblemA {

	static void runIt() throws IOException {

		String inFName = "resource/A-small-attempt0.in";
		// String inFName = "resource/A-large.in";
		String outFName = "resource/A-small.out";
		// String outFName = "resource/A-large.out";

		BufferedReader in = new BufferedReader(new FileReader(inFName));
		PrintWriter out = new PrintWriter(new File(outFName));

		int testCases = Integer.parseInt(in.readLine());

		for (int i = 0; i < testCases; ++i) {

			String line = in.readLine();
			System.out.println(line);
			StringBuilder output = new StringBuilder();
			output.append("Case #" + (i + 1) + ": ");
			String[] p = line.split(" ");
			int N = Integer.parseInt(p[0]);
			long X = 0;
			int maxSj = 0;
			int min1Sj = Integer.MAX_VALUE;
			int min2Sj = Integer.MAX_VALUE;
			ArrayList<Integer> s = new ArrayList<Integer>(N);
			ArrayList<Integer> ss = new ArrayList<Integer>(N);

			for (int j = 1; j < p.length; ++j) {
				s.add(Integer.parseInt(p[j]));
				ss.add(Integer.parseInt(p[j]));
				X += Integer.parseInt(p[j]);
			}

			Collections.sort(s);

			maxSj = s.get(s.size() - 1);
			min1Sj = s.get(0);
			min2Sj = min1Sj;
			int sCount = 1;
			int k = 0;
			for (k = 0; k < s.size(); ++k) {
				int tt = s.get(k);
				if (tt == min1Sj) {
					sCount++;
				} else {
					min2Sj = tt;
					break;
				}
			}

			long Y = (long) Math.max(Math.ceil(2.0 * X / N), maxSj);
			if (N < 3) {
				for (int j = 1; j < p.length; ++j) {
					double sJ = Double.parseDouble(p[j]);
					double res = 1.0 * (Y - sJ) / X;
					output.append(res + " ");
				}
			} else {
				int dif = min2Sj - min1Sj;
				double min1Per = 0;
				if (dif > 0) {
					min1Per = ((dif * 1.0) / X) * 1.0 / sCount;
				} else {
					min1Per = 1.0 / N;
				}
				double rest = (1.0 - min1Per) / (N - 1);
				boolean min2Done = false;

				for (Integer integer : ss) {

					if (integer.equals(min1Sj)) {
						output.append(min1Per + " ");
						continue;
					}

					if (!min2Done && integer.equals(min2Sj)) {
						output.append(0.0 + " ");
						min2Done = true;
						continue;
					}
					output.append(rest + " ");

				}
			}
			System.out.println(output);
			out.println(output.toString().trim());
		}

		in.close();
		out.flush();
		out.close();
	}

	public static void main(String[] args) {

		try {
			ProblemA.runIt();
		} catch (IOException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}
}
