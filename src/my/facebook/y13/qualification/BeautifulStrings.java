package my.facebook.y13.qualification;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BeautifulStrings {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("resource/beautiful_stringstxt.txt"));
			PrintWriter out = new PrintWriter(new File("resource/beautiful_stringstxt_out.txt"));
			int numTests = Integer.parseInt(sc.nextLine());
			int i = 1;
			while (sc.hasNext()) {
				String line = sc.nextLine();
				line = line.toLowerCase().replaceAll("[^a-z]+", "");
				int[] counts = new int[26];
				char[] chars = line.toCharArray();
				long sum = 0;
				for (char d : chars) {
					++counts[(int) d - 'a'];
				}
				Arrays.sort(counts);
				int k = 26;
				for (int j = counts.length - 1; j > -1; --j) {
					sum += k * counts[j];
					--k;
				}
				out.print("Case #" + i + ": " + sum);
				if (i != numTests) {
					out.print("\n");
				}
				++i;
			}
			sc.close();
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
