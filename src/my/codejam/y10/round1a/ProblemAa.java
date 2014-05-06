/**
 * 
 */
package my.codejam.y10.round1a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ilija Ilievski
 * 
 */
public class ProblemAa {

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
			String lin[] = line.split(" ");
			int N = Integer.parseInt(lin[0]);
			int K = Integer.parseInt(lin[1]);
			StringBuilder output = new StringBuilder();
			output.append("Case #" + (i + 1) + ": ");
			char[][] map = new char[N + 1][N + 1];

			for (int k = 0; k < N; ++k) {
				String l = in.readLine();
				map[k] = l.toCharArray();
			}

			List<List<Character>> col = new ArrayList<List<Character>>();

			for (int k = 0; k < N; ++k) {
				List<Character> c = new ArrayList<Character>();
				col.add(c);
			}
			char[][] newMap = new char[N][N];
			for (int m = 0, j = 0; m < N; ++m, ++j) {
				for (int n = N - 1, h = 0; n >= 0; --n, ++h) {

					Character c = map[n][m];
					newMap[j][h] = c;
					if (!c.equals('.')) {
						col.get(n).add(c);
					}
				}
				System.out.println();
			}

			for (int k = 0; k < N; ++k) {
				List<Character> ro = new ArrayList<Character>();
				for (int g = N - 1; g >= 0; --g) {

					Character c = newMap[g][k];
					if (!c.equals('.')) {
						ro.add(c);
					}
				}
				int kg = N - 1;
				for (Character character : ro) {
					map[kg--][k] = character;
				}
				for (; kg >= 0; kg--) {
					map[kg][k] = '.';
				}
			}
			Character last = 'T';
			int blue = 1;
			int red = 1;
			boolean bf = false;
			boolean rf = false;
			for (int n = 0; n < N; ++n) {
				for (int m = 0; m < N; ++m) {
					Character c = map[n][m];
					if (!c.equals('.')) {

						if (c.equals(last)) {
							if (c.equals('B')) {
								blue++;
								if (blue >= K) {
									bf = true;
								}
							} else {
								red++;
								if (red >= K) {
									rf = true;
								}
							}
						} else {
							red = 1;
							blue = 1;
						}
					}
					last = c;
				}
				last = 'T';
			}
			if (bf && rf) {
				output.append("Both");
				red = 1;
				blue = 1;
				out.println(output);
				continue;
			}
			for (int n = 0; n < N; ++n) {
				for (int m = 0; m < N; ++m) {
					Character c = map[m][n];
					if (!c.equals('.')) {

						if (c.equals(last)) {
							if (c.equals('B')) {
								blue++;
								if (blue >= K) {
									bf = true;
								}
							} else {
								red++;
								if (red >= K) {
									rf = true;
								}
							}
						} else {
							red = 1;
							blue = 1;
						}
					}
					last = c;
				}
				last = 'T';
			}
			if (bf && rf) {
				output.append("Both");
				red = 1;
				blue = 1;
				out.println(output);
				continue;
			}
			int n = 0;
			int m = N - K;
			while (n <= N - K) {

				for (int ff = n, fg = m; ff < N && fg < N; ++ff, ++fg) {
					Character c = map[ff][fg];
					if (!c.equals('.')) {

						if (c.equals(last)) {
							if (c.equals('B')) {
								blue++;
								if (blue >= K) {
									bf = true;
								}
							} else {
								red++;
								if (red >= K) {
									rf = true;
								}
							}
						} else {
							red = 1;
							blue = 1;
						}
					}
					last = c;
				}
				last = 'T';
				if (m > 0)
					--m;
				else {
					++n;
				}
			}
			if (bf && rf) {
				output.append("Both");
				red = 1;
				blue = 1;
				out.println(output);
				continue;
			}
			n = 0;
			m = N - K;
			while (n <= N - K) {

				for (int ff = n, fg = m; ff < N && fg < N; ++ff, ++fg) {
					Character c = map[fg][ff];
					if (!c.equals('.')) {

						if (c.equals(last)) {
							if (c.equals('B')) {
								blue++;
								if (blue >= K) {
									bf = true;
								}
							} else {
								red++;
								if (red >= K) {
									rf = true;
								}
							}
						} else {
							red = 1;
							blue = 1;
						}

					}
					last = c;
				}
				last = 'T';
				if (m > 0)
					--m;
				++n;
			}
			if (bf && rf) {
				output.append("Both");
			} else {
				if (rf) {
					output.append("Red");
				} else if (bf) {
					output.append("Blue");
				} else {
					output.append("Neither");
				}

			}
			out.println(output);
		}

		in.close();
		out.flush();
		out.close();
	}

	public static void main(String[] args) {

		try {
			ProblemAa.runIt();
		} catch (IOException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}
}
