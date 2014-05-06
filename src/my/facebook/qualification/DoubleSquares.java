package my.facebook.qualification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DoubleSquares {
	static void runIt() throws IOException {

		String inFName = "resource/input.txt";
		String outFName = "resource/fbDouble.out";

		BufferedReader in = new BufferedReader(new FileReader(inFName));
		PrintWriter out = new PrintWriter(new File(outFName));

		int testCases = Integer.parseInt(in.readLine());

		for (int i = 0; i < testCases; ++i) {

			String line = in.readLine();
			StringBuilder output = new StringBuilder();
			int X = Integer.parseInt(line);
			int count = 0;

			if (X != 0) {
				for (int K = (int) Math.sqrt(X); K > 0; K--) {

					int onD = K * K;
					if (X == onD) {
						count += 2;
					} else {// 2nd chance
						int R = X - onD;
						int k = (int) Math.sqrt(R);
						if (R == k * k) {
							++count;
						}
					}
				}
				count /= 2;
				output.append(count);
				
			} else {
				output.append(1);
			}
			System.out.println(output);
			out.println(output);
		}

		in.close();
		out.flush();
		out.close();
	}

	public static void main(String[] args) {

		try {
			DoubleSquares.runIt();
		} catch (IOException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}
}
