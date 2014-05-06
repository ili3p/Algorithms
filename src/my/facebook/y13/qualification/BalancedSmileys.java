package my.facebook.y13.qualification;

import java.io.*;
import java.util.*;

public class BalancedSmileys {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(new File("resource/balanced_smileystxt.txt"));
			PrintWriter out = new PrintWriter(new File("resource/balanced_smileystxt_out.txt"));
			int numTests = Integer.parseInt(sc.nextLine());
			int i = 1;
			while (sc.hasNext()) {
				String line = sc.nextLine();
				boolean ok = check(line) || check(line.replaceAll(":\\(", "")) || check(line.replaceAll(":\\)", ""));

				System.out.println("Case #" + i + ": " + (ok ? "YES" : "NO"));
				out.print("Case #" + i + ": " + (ok ? "YES" : "NO"));
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

	private static boolean check(String line) {
		int balance = 0;
		char[] c = line.toCharArray();
		for (char d : c) {
			if (d == '(') {
				++balance;
			}
			if (d == ')') {
				--balance;
			}
			if (balance < 0) {
				break;
			}
		}
		return balance == 0;
	}
}
/**
 * A message has balanced parentheses if it consists of one of the following:
 * 
 * - An empty string "" - One or more of the following characters: 'a' to 'z',
 * ' ' (a space) or ':' (a colon) - An open parenthesis '(', followed by a
 * message with balanced parentheses, followed by a close parenthesis ')'. - A
 * message with balanced parentheses followed by another message with balanced
 * parentheses. - A smiley face ":)" or a frowny face ":("
 */
