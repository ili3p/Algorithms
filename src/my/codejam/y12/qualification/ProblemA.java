package my.codejam.y12.qualification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ProblemA {

	static void runIt() throws IOException {

		String inFName = "resource/A-small-attempt0.in";
		// String inFName = "resource/A-large.in";
		String outFName = "resource/A-small.out";
		// String outFName = "resource/A-large.out";

		BufferedReader in = new BufferedReader(new FileReader(inFName));
		PrintWriter out = new PrintWriter(new File(outFName));

		int testCases = Integer.parseInt(in.readLine());

		char[] map = new char[26 + 'a'];
		map['y'] = 'a';
		map['e'] = 'o';
		map['q'] = 'z';
		map[' '] = ' ';
		map['e'] = 'o';
		map['j'] = 'u';
		map['p'] = 'r';
		map[' '] = ' ';
		map['m'] = 'l';
		map['y'] = 'a';
		map['s'] = 'n';
		map['l'] = 'g';
		map['j'] = 'u';
		map['y'] = 'a';
		map['l'] = 'g';
		map['c'] = 'e';
		map[' '] = ' ';
		map['k'] = 'i';
		map['d'] = 's';
		map[' '] = ' ';
		map['k'] = 'i';
		map['x'] = 'm';
		map['v'] = 'p';
		map['e'] = 'o';
		map['d'] = 's';
		map['d'] = 's';
		map['k'] = 'i';
		map['n'] = 'b';
		map['m'] = 'l';
		map['c'] = 'e';
		map[' '] = ' ';
		map['r'] = 't';
		map['e'] = 'o';
		map[' '] = ' ';
		map['j'] = 'u';
		map['s'] = 'n';
		map['i'] = 'd';
		map['c'] = 'e';
		map['p'] = 'r';
		map['d'] = 's';
		map['r'] = 't';
		map['y'] = 'a';
		map['s'] = 'n';
		map['i'] = 'd';
		map['r'] = 't';
		map['b'] = 'h';
		map['c'] = 'e';
		map['p'] = 'r';
		map['c'] = 'e';
		map[' '] = ' ';
		map['y'] = 'a';
		map['p'] = 'r';
		map['c'] = 'e';
		map[' '] = ' ';
		map['r'] = 't';
		map['t'] = 'w';
		map['c'] = 'e';
		map['s'] = 'n';
		map['r'] = 't';
		map['a'] = 'y';
		map[' '] = ' ';
		map['d'] = 's';
		map['k'] = 'i';
		map['h'] = 'x';
		map[' '] = ' ';
		map['w'] = 'f';
		map['y'] = 'a';
		map['f'] = 'c';
		map['r'] = 't';
		map['e'] = 'o';
		map['p'] = 'r';
		map['k'] = 'i';
		map['y'] = 'a';
		map['m'] = 'l';
		map[' '] = ' ';
		map['v'] = 'p';
		map['e'] = 'o';
		map['d'] = 's';
		map['d'] = 's';
		map['k'] = 'i';
		map['n'] = 'b';
		map['k'] = 'i';
		map['m'] = 'l';
		map['k'] = 'i';
		map['r'] = 't';
		map['k'] = 'i';
		map['c'] = 'e';
		map['d'] = 's';
		map['d'] = 's';
		map['e'] = 'o';
		map[' '] = ' ';
		map['k'] = 'i';
		map['r'] = 't';
		map[' '] = ' ';
		map['k'] = 'i';
		map['d'] = 's';
		map[' '] = ' ';
		map['e'] = 'o';
		map['o'] = 'k';
		map['y'] = 'a';
		map['a'] = 'y';
		map[' '] = ' ';
		map['k'] = 'i';
		map['w'] = 'f';
		map[' '] = ' ';
		map['a'] = 'y';
		map['e'] = 'o';
		map['j'] = 'u';
		map[' '] = ' ';
		map['t'] = 'w';
		map['y'] = 'a';
		map['s'] = 'n';
		map['r'] = 't';
		map[' '] = ' ';
		map['r'] = 't';
		map['e'] = 'o';
		map[' '] = ' ';
		map['u'] = 'j';
		map['j'] = 'u';
		map['d'] = 's';
		map['r'] = 't';
		map[' '] = ' ';
		map['l'] = 'g';
		map['k'] = 'i';
		map['g'] = 'v';
		map['c'] = 'e';
		map[' '] = ' ';
		map['j'] = 'u';
		map['v'] = 'p';
		map['z'] = 'q';
		for (int i = 0; i < testCases; ++i) {

			String line = in.readLine();
			System.out.println(line);
			StringBuilder output = new StringBuilder();
			output.append("Case #" + (i + 1) + ": ");

			char[] wordChar = line.toCharArray();
			for (int j = 0; j < wordChar.length; j++) {
				wordChar[j] = map[wordChar[j]];
			}

			output.append(new String(wordChar));
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
