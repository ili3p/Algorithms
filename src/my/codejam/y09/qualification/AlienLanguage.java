package my.codejam.y09.qualification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AlienLanguage {

	public static void run() {
		String[] strings = readFile();
		String[] param = strings[0].split(" ");
		// int L = Integer.parseInt(param[0]);
		int D = Integer.parseInt(param[1]);
		int N = Integer.parseInt(param[2]);
		List<String> dictionary = new ArrayList<String>(D);
		List<String> cases = new ArrayList<String>(N);
		List<String> result = new ArrayList<String>(N);
		for (int i = 1; i <= D; ++i) {
			dictionary.add(strings[i]);
		}
		for (int i = D + 1; i < strings.length; ++i) {
			cases.add(strings[i]);
		}
		System.out.println(dictionary.size());
		System.out.println(cases.size());
		int matches = 0;
		for (int i = 0; i < cases.size(); ++i) {
			matches = 0;
			String current = cases.get(i);

			// System.out.println("current "+current);
			current = current.replace("(", "[");
			current = current.replace(")", "]");
			// System.out.println("current "+current);
			for (String temp : dictionary) {
				// System.out.println("temp " + temp);
				if (temp.matches(current)) {
					// System.out.println("temp " + temp);
					++matches;
				}
			}

			result.add("Case #" + (i + 1) + ": " + matches);
		}
		writeFile(result.toArray(new String[0]));
	}

	public static void main(String[] args) {
		run();
	}

	public static String[] readFile() {
		List<String> result = new ArrayList<String>();
		try {

			FileInputStream fstream = new FileInputStream("A-large.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;

			while ((strLine = br.readLine()) != null) {
				result.add(strLine);
			}

			in.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return result.toArray(new String[0]);
	}

	public static void writeFile(String[] str) {

		try {
			File file = new File("A-small.out");
			BufferedWriter output = new BufferedWriter(new FileWriter(file));
			for (int i = 0; i < str.length; ++i) {

				output.write(str[i]);
				output.newLine();
			}
			output.flush();
			output.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
