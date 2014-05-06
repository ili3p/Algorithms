package my.facebook.y13.qualification;
import java.io.*;
import java.util.*;

public class B {
	public static void main(String[] args) {
		try {
			String fileName = "B_test";

			PrintWriter out = new PrintWriter(new File("resource/fb/out_" + fileName));
			Scanner sc = new Scanner(new File("resource/fb/" + fileName));

			int T = Integer.parseInt(sc.nextLine());
			for (int i = 1; i <= T; ++i) {
				int m = Integer.parseInt(sc.nextLine());
				String k1 = sc.nextLine();
				String k2 = sc.nextLine();

				StringBuilder result = new StringBuilder();

				int numParts = k1.length() / m;

				String[] k1Parts = new String[numParts];
				String[] k2Parts = new String[numParts];
				int[] k2Taken = new int[numParts];

				Set<String> pp = new HashSet<String>(numParts);

				for (int j = 0; j < k1Parts.length; ++j) {
					String k11 = k1.substring(j * m, j * m + m);

					if (pp.contains(k11)) {
						result.append("IMPOSSIBLE");
						break;

					} else {
						pp.add(k11);
						k1Parts[j] = k11;
						k2Parts[j] = k2.substring(j * m, j * m + m);
					}

				}
				Arrays.fill(k2Taken, -1);
				Arrays.sort(k2Parts);
				pp = null;
				if (result.length() == 0) {

					for (int j = 0; j < k1Parts.length; j++) {
						for (int h = 0; h < k2Parts.length; ++h) {
							String string = k1Parts[j];
							String regex = k2Parts[h].replaceAll("\\?", ".{1}");
							if (string.matches(regex)) {
								k2Taken[h] = j;
								break;
							}
						}
					}

					for (int j = 0; j < k2Taken.length; j++) {
						int j2 = k2Taken[j];
						if (j2 == -1) {
							result.append("IMPOSSIBLE");
							break;
						} else {
							char[] k1Part = k1Parts[j2].toCharArray();
							String k2Part = k2Parts[j];
							for (int k = 0; k < k1Part.length; k++) {
								char c = k1Part[k];
								if (c == '?') {
									k1Part[k] = k2Part.charAt(k);
								}
							}
							result.append(k1Part);
						}
					}

				}
				System.out.println("Case " + i + "#: " + result);
				out.println("Case " + i + "#: " + result);
			}

			sc.close();
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
