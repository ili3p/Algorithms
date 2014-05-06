/**
 * 
 */
package my.codejam.y10.qualification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

/**
 * @author Ilija Ilievski
 * 
 */
public class ProblemC {

	static void runIt() throws IOException {

//		String inFName = "resource/C-small-attempt0.in";
		 String inFName = "resource/C-large.in";
//		String outFName = "resource/C-small.out";
		 String outFName = "resource/C-large.out";

		BufferedReader in = new BufferedReader(new FileReader(inFName));
		PrintWriter out = new PrintWriter(new File(outFName));

		int testCases = Integer.parseInt(in.readLine());

		for (int i = 0; i < testCases; ++i) {

			String line[] = in.readLine().split(" ");
//			System.out.println(line);
			StringBuilder output = new StringBuilder();
			output.append("Case #" + (i + 1) + ": ");

			int R = Integer.parseInt(line[0]);
			int K = Integer.parseInt(line[1]);
			long euros = 0;
			int pass = 0;
			line = in.readLine().split(" ");
			Vector<Integer> queue = new Vector<Integer>();
			Vector<Integer> first = new Vector<Integer>();
			for (String string : line) {
				queue.add(Integer.parseInt(string));
				first.add(Integer.parseInt(string));
				
			}


			for (int time = 0; time < R; ++time) {
				int p = 0;
				while (true) {
					if (p < queue.size()) {
						Integer g = queue.elementAt(p++);
						if (pass + g <= K) {
							pass += g;
						} else {
							break;
						}
					} else {
						break;
					}

				}
				for (int kk = 1; kk < p; ++kk) {
					Integer m = queue.remove(0);
					queue.add(m);
				}
				
				euros += pass;
				pass=0;
				if(queue.equals(first)){
					int s = R/(time+1);
					euros*=s;
					time *=s;
				}
			}

			output.append(euros);
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
