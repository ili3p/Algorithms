/**
 * 
 */
package my.codejam.y10.round1a;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Ilija Ilievski
 * 
 */
public class ProblemAb {

	static void runIt() throws IOException {

		String inFName = "resource/A-small-attempt0.in";
		// String inFName = "resource/A-large.in";
		String outFName = "resource/A-small.out";
		// String outFName = "resource/A-large.out";

		BufferedReader in = new BufferedReader(new FileReader(inFName));
		PrintWriter out = new PrintWriter(new File(outFName));

		int testCases = Integer.parseInt(in.readLine());

		for (int test = 0; test < testCases; ++test) {

			String line = in.readLine();
			String lin[] = line.split(" ");
			int N = Integer.parseInt(lin[0]);
			int M = Integer.parseInt(lin[1]);
			StringBuilder output = new StringBuilder();
			output.append("Case #" + (test + 1) + ": ");

			long mkdirs = 0;
			String[][] map = new String[N + M][101];
			String curLine = "";

			for (int i = 0; i < N; ++i) {

				curLine = in.readLine();
				String folders[] = curLine.split("/");
				map[i] = folders;
			}

			for (int i = 0; i < M; ++i) {

				curLine = in.readLine();
				String folders[] = curLine.split("/");
				String folder;
				
				for (int k = 1; k < folders.length; ++k) {

					folder = folders[k];
					boolean flag = true;

					for (int h = 0; h < map.length; ++h) {

						if (k >= map[h].length) {
							continue;
						}
						String f = map[h][k];
						if (f == null) {
							flag=true;
							break;
						}
						for (int m = k; m > 0; --m) {
							flag = flag && folders[m].equalsIgnoreCase(map[h][m]);
						}
						if(flag){
							flag=false;
							break;
						}
					}

					if (flag) {
						mkdirs += folders.length - k;
						break;
					}
				}

				map[N++] = folders;

			}

			output.append(mkdirs);
			out.println(output);
		}

		in.close();
		out.flush();
		out.close();
	}

	public static void main(String[] args) {

		try {
			ProblemAb.runIt();
		} catch (IOException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}
}
