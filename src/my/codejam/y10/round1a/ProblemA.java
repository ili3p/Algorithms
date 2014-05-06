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
import java.util.Arrays;
import java.util.List;

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

		for (int test = 0; test < testCases; ++test) {

			String line = in.readLine();
			int N = Integer.parseInt(line);

			StringBuilder output = new StringBuilder();
			output.append("Case #" + (test + 1) + ": ");

			int A[] = new int[N];
			int B[] = new int[N];
			Arrays.fill(A,0);
			Arrays.fill(B,0);
			int numA =0;
			int numB=0;
			List<Integer> as = new ArrayList<Integer>();
			List<Integer> bs = new ArrayList<Integer>();
			int intersec=0;
			for (int i = 0; i < N; ++i) {
				
				line = in.readLine();
				String lines[]=line.split(" ");
				int a = Integer.parseInt(lines[0]);
				int b = Integer.parseInt(lines[1]);
				
				for(int indA = 0; indA<=numA;++indA){
					if(A[indA]<= a && B[indA]>=b){
						intersec++;
					}
					if(A[indA]>=a && B[indA]<=b){
						intersec++;
					}
				}
				A[numA++] = a;
				B[numB++] = b;
			}

			output.append(intersec);
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
