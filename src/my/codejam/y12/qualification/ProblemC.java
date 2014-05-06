package my.codejam.y12.qualification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ProblemC {

	static void runIt() throws IOException {

		String inFName = "resource/C-small-attempt0.in";
		// String inFName = "resource/C-large.in";
		String outFName = "resource/C-small.out";
		// String outFName = "resource/C-large.out";

		BufferedReader in = new BufferedReader(new FileReader(inFName));
		PrintWriter out = new PrintWriter(new File(outFName));

		int testCases = Integer.parseInt(in.readLine());

		for (int i = 0; i < testCases; ++i) {

			String line = in.readLine();
			StringBuilder output = new StringBuilder();
			output.append("Case #" + (i + 1) + ": ");
			int result = 0;

			output.append(result);

			System.out.println(output);
			out.println(output);
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
