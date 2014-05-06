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
public class ProblemC {

	static void runIt() throws IOException {

		String inFName = "resource/C-small-attempt0.in";
//		 String inFName = "resource/C-large.in";
		String outFName = "resource/C-small.out";
//		 String outFName = "resource/C-large.out";

		BufferedReader in = new BufferedReader(new FileReader(inFName));
		PrintWriter out = new PrintWriter(new File(outFName));

		int testCases = Integer.parseInt(in.readLine());

		for (int test = 0; test < testCases; ++test) {

			String line = in.readLine();
			System.out.println(line);
			String lines[] = line.split(" ");
			int M = Integer.parseInt(lines[0]);
			int N = Integer.parseInt(lines[1]);

			for (int i = 0; i < M; ++i) {
				StringBuilder sb = new StringBuilder();
				String L = in.readLine();
				char[] d = L.toCharArray();
				
				for (char c : d) {
					int h = Integer.parseInt(Character.toString(c), 16);
					sb.append(Integer.toBinaryString(h));
				}
				
			}
			StringBuilder output = new StringBuilder();
			output.append("Case #" + (test + 1) + ": ");

		}

		in.close();
		out.flush();
		out.close();
	}

	public static void main(String[] args) {

		try {
			ProblemC.runIt();
		} catch (IOException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}
}
