package my.codejam.y11.round1b;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

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
			int points = Integer.parseInt(line[0]);
			int minDistance = Integer.parseInt(line[1]);
			double seconds = 0.0;

			String[] ss = in.readLine().split(" ");
			int count = Integer.parseInt(ss[1]);
			int prevPoint = Integer.parseInt(ss[0]) + offset;
			int smal = prevPoint;
			for (int j = 1; j < points; j++) {
				String[] s = in.readLine().split(" ");
				int currPoint = Integer.parseInt(s[0]) + offset;
				int toGo = (currPoint - prevPoint - minDistance) * -1;
				if (toGo > 0) {
					seconds += (toGo / 2.0);
				}
				seconds += (minDistance / 2.0) * (Integer.parseInt(s[1]) - 1);
				prevPoint = currPoint;
				count += Integer.parseInt(s[1]);
			}
			seconds+=Math.max((count+1)*minDistance-2*minDistance-(prevPoint-smal),0);
			output.append(seconds);
			System.out.println(output);
			out.println(output);
		}

		in.close();
		out.flush();
		out.close();
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
