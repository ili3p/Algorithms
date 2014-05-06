package my.codejam.y11.round1c;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProblemB {

	static void runIt() throws IOException {

		String inFName = "resource/B-small-attempt1.in";
		// String inFName = "resource/C-large.in";
		String outFName = "resource/B-small.out";
		// String outFName = "resource/C-large.out";

		BufferedReader in = new BufferedReader(new FileReader(inFName));
		PrintWriter out = new PrintWriter(new File(outFName));

		int testCases = Integer.parseInt(in.readLine());
		int offset = 100000;
		for (int i = 0; i < testCases; ++i) {

			
			StringBuilder output = new StringBuilder();
			output.append("Case #" + (i + 1) + ": ");
			String[] line = in.readLine().split(" ");
			int L = Integer.parseInt(line[0]);
			long t = Long.parseLong(line[1]);
			int N = Integer.parseInt(line[2]);
			int C = Integer.parseInt(line[3]);
			int distances[] = new int[C];
			List<Integer> maxs = new ArrayList<Integer>();
			long sum = 0;
			for (int k = 0; k < C; ++k) {
				distances[k] = Integer.parseInt(line[k + 4]);
				sum += distances[k];
				maxs.add(distances[k]);
			}
			Collections.sort(maxs, Collections.reverseOrder());
			long toBuild = 0;
			int n = 0;
			long minH = (N / C) * sum * 2 + getPart(distances, N % C - 1) * 2;
			if (minH > t) {
				long pa = t / (sum * 2);
				toBuild = (pa * sum * 2);
				int k = 0;
				if (t % (sum * 2) != 0) {
					for (k = 0; k < distances.length; k++) {
						int add = distances[k];
						toBuild += add * 2;
						if (toBuild > t) {
							break;
						}
					}
				}
				++k;
				long toGo = minH - toBuild;
				long whole = toGo / (sum * 2);
				int o = 0;
				minH -= maxs.get(0) * Math.min(whole, L);
				L -= whole;
				if (L > 0) {
					List<Integer> maxs2 = new ArrayList<Integer>();
					for (; k < distances.length; ++k) {
						maxs2.add(distances[k]);
					}
					Collections.sort(maxs2, Collections.reverseOrder());
					o = 0;
					int s = 1;
					long step = 0;
					while (L > 0 && (o < maxs2.size() || s < maxs.size())) {
						int m = 0;
						if (o < maxs2.size()) {
							m = maxs2.get(0);
						}
						int hg = 0;
						if (whole <= step) {
							++s;
							step = 0;
						}
						if (s < maxs.size()) {
							hg = maxs.get(s);
						}
						if (hg == 0 && m == 0) {
							break;
						}
						if (hg > m) {
							++step;
							minH -= hg;
						} else {
							++o;
							minH -= m;
						}
						--L;
					}
				}
				//				
				//				
				// for (int k = 0; n < N; ++k) {
				// if (k == C) {
				// k = 0;
				// }
				// toBuild += distances[k] * 2;
				// ++n;
				// if (toBuild >= t) {
				// break;
				// }
				// }
				// int left = (N % C) - 1;
				// if (left == -1) {
				// left = C - 1;
				// }
				// int toGo = N - n;
				// int whole = toGo / C;
				// boolean toBu = true;
				// if (whole > 0) {
				// int o = 0;
				// while (L > 0 && o < C) {
				// if (toBu && (toBuild - t) / 2 < maxs.get(o)) {
				// minH -= maxs.get(o) * Math.min(whole, L);
				// L -= whole;
				// } else {
				// toBu = false;
				// minH -= (toBuild - t) / 2;
				// L -= 1;
				// minH -= maxs.get(o) * Math.min(whole, L);
				// L -= whole;
				// }
				// ++o;
				// }
				// }
				// int part = toGo % C;
				// if (part > 0) {
				// if (L > 0) {
				// maxs = new ArrayList<Integer>();
				// int s = n % C - 1;
				// int e = (N - whole * C) % C - 1;
				// if (e < 0) {
				// e = C - 1;
				// }
				// for (int g = s; g <= e; ++g) {
				// maxs.add(distances[g]);
				// }
				// Collections.sort(maxs, Collections.reverseOrder());
				// int o = 0;
				// while (L > 0 && o < maxs.size()) {
				// if (toBu && (toBuild - t) / 2 < maxs.get(o)) {
				// minH -= maxs.get(o) * Math.min(whole, L);
				// L -= whole;
				// } else {
				// toBu = false;
				// minH -= (toBuild - t) / 2;
				// L -= 1;
				// minH -= maxs.get(o) * Math.min(whole, L);
				// L -= whole;
				// }
				// ++o;
				// }
				// }
				// }
			}
			output.append(minH);
			System.out.println(output);
			out.println(output);
		}

		in.close();
		out.flush();
		out.close();
	}

	private static long getPart(int[] distances, int i) {
		if (i == -1) {
			return 0;
		} else {
			long sum = 0;
			for (int j = 0; j < i + 1; j++) {
				sum += distances[j];
			}
			return sum;
		}
	}

	public static void main(String[] args) {

		try {
			ProblemB.runIt();
		} catch (IOException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}
}
