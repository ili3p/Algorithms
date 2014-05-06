/**
 * 
 */
package my.codejam.y10.qualification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Ilija Ilievski
 * 
 */
public class ProblemA {

	static void runIt() throws IOException {

//		String inFName = "resource/A-small-attempt0.in";
		 String inFName = "resource/A-large.in";
//		String outFName = "resource/A-small.out";
		 String outFName = "resource/A-large.out";

		BufferedReader in = new BufferedReader(new FileReader(inFName));
		PrintWriter out = new PrintWriter(new File(outFName));

		int testCases = Integer.parseInt(in.readLine());

		for (int i = 0; i < testCases; ++i) {

			String line = in.readLine();
			System.out.println(line);
			StringBuilder output = new StringBuilder();
			output.append("Case #"+(i+1)+": ");
			
			String [] n = line.split(" ");
			int N = Integer.parseInt(n[0]);
			int K = Integer.parseInt(n[1]);
			long dvaNaStepen = (long) Math.pow(2, N); 
			long left = K % dvaNaStepen;
			if(left == dvaNaStepen - 1 )
			output.append("ON");
			else
				output.append("OFF");
				System.out.println(output);
			out.println(output);
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
