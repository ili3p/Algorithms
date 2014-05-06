package my.codejam.y11.round1b;

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

			int teams = Integer.parseInt(in.readLine());
			double teamsInverted = 1.0 / teams;
			char[][] games = new char[teams][teams];
			double[] wp = new double[teams];
			double[] owp = new double[teams];
			double[] rpi = new double[teams];
			for (int j = 0; j < teams; j++) {
				games[j] = in.readLine().toCharArray();
			}
			for (int j = 0; j < teams; ++j) {
				wp[j] = getWP(j, games[j]);
			}
			for (int j = 0; j < teams; ++j) {
				double wpTotal = 0.0;
				int c = 0;
				for (int k = 0; k < teams; ++k) {
					if (games[k][j] != '.') {
						++c;
						wpTotal += getWP(j, games[k]);
					} else {
						continue;
					}
				}
				owp[j] = (1.0/c) * wpTotal;
			}

			for (int j = 0; j < teams; j++) {
				rpi[j] = 0.25 * wp[j] + 0.5 * owp[j] + 0.25
						* getOOwp(j, owp, teamsInverted, games);
				output.append(rpi[j] + "\n");
			}
			System.out.println(output);
			out.println(output);
		}

		in.close();
		out.flush();
		out.close();
	}

	private static double getOOwp(int skip, double[] owp, double teamsInverted,
			char[][] games) {
		double sum = 0.0;
		int count=0;
		for (int i = 0; i < owp.length; i++) {
			if (games[skip][i] != '.') {
				count++;
				sum += owp[i];
			}
		}
		return sum * (1.0/count);
	}

	private static double getWP(int skip, char[] games) {

		int wins = 0;
		int count = 0;
		for (int i = 0; i < games.length; i++) {
			char c = games[i];
			if (i != skip) {
				if (c != '.') {
					count++;
					if (c == '1') {
						++wins;
					}
				}
			}
		}
		return wins * (1.0/count);
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
