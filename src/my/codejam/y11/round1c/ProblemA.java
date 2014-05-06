package my.codejam.y11.round1c;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

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

			StringBuilder output = new StringBuilder();
			output.append("Case #" + (i + 1) + ": \n");

			String[] line = in.readLine().split(" ");
			int rows = Integer.parseInt(line[0]);
			int cols = Integer.parseInt(line[1]);
			char[][] map = new char[rows][cols];
			for (int j = 0; j < rows; j++) {
				map[j] = in.readLine().toCharArray();
			}

			boolean isGood = true;
			mainLoop: for (int j = 0; j < rows && isGood; j++) {
				char[] row = map[j];
				for (int k = 0; k < cols; k++) {
					char c = row[k];
					if (c == '#') {
						if (k + 1 < cols) {
							c = row[k + 1];
							if (c == '#') {
								if (j + 1 < rows) {
									if (map[j+1][k] == '#') {
										if (map[j + 1][k + 1] == '#') {
											map[j][k] = '/';
											map[j][k+1] = '\\';
											map[j+1][k] = '\\';
											map[j+1][k + 1] = '/';
											k += 1;
											continue;
										} else {
											isGood = false;
											break mainLoop;
										}
									} else {
										isGood = false;
										break mainLoop;
									}
								} else {
									isGood = false;
									break mainLoop;
								}
							} else {
								isGood = false;
								break mainLoop;
							}
						} else {
							isGood = false;
							break mainLoop;
						}
					}
				}
			}
			if (isGood) {
				for (int j = 0; j < map.length; j++) {
					char[] cs = map[j];
					for (int k = 0; k < cs.length; k++) {
						char c = cs[k];
						output.append(c);
					}
					if(j+1<map.length)
					output.append("\n");
				}
				
			} else {
				output.append("Impossible");
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
