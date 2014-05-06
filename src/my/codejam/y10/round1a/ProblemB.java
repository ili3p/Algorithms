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
public class ProblemB {

	static void runIt() throws IOException {

//		String inFName = "resource/B-small-practice.in";
		 String inFName = "resource/B-large-practice.in";
//		String outFName = "resource/B-small.out";
		 String outFName = "resource/B-large.out";

		BufferedReader in = new BufferedReader(new FileReader(inFName));
		PrintWriter out = new PrintWriter(new File(outFName));

		int testCases = Integer.parseInt(in.readLine());

		for (int test = 0; test < testCases; ++test) {

			String line = in.readLine();
			String lines[] = line.split(" ");
			int L = Integer.parseInt(lines[0]);
			int P= Integer.parseInt(lines[1]);
			int C = Integer.parseInt(lines[2]);
int X=1;
			while (C*L < P){
			      X++; L *= C;
			    }
			    int res = 0;
			    long acc = 1;
			    while (acc < X){
			      res++; acc *= 2;
			    }
			    System.out.println("1");
			StringBuilder output = new StringBuilder();
			output.append("Case #" + (test + 1) + ": ");
			output.append(res);
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
