package my.facebook.qualification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudiousStudent {
	static void runIt() throws IOException {

		String inFName = "resource/fbStudious.in";
		String outFName = "resource/fbStudious.out";

		BufferedReader in = new BufferedReader(new FileReader(inFName));
		PrintWriter out = new PrintWriter(new File(outFName));

		int testCases = Integer.parseInt(in.readLine());

		for (int i = 0; i < testCases; ++i) {

			String line = in.readLine();
			System.out.println(line);
			StringBuilder output = new StringBuilder();

			String[] words = line.split(" ");
			int M = Integer.parseInt(words[0]);
			List<String> sortedWords = new ArrayList<String>();

			for (int w = 1; w <= M; ++w) {
				sortedWords.add(words[w]);
			}
			Collections.sort(sortedWords);
			for (String string : sortedWords) {
				output.append(string);
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
			StudiousStudent.runIt();
		} catch (IOException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println(e.getMessage());
			e.printStackTrace();

		}
	}
}
