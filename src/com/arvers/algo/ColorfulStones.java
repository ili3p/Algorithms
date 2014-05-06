package com.arvers.algo;
import java.util.Scanner;

public class ColorfulStones {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] s = sc.nextLine().toCharArray();
		char[] t = sc.nextLine().toCharArray();
		int i = 0;
		for (int j = 0; j < t.length; j++) {
			if (t[j] == s[i]) {
				++i;
			}
		}

		System.out.println(i + 1);
	}
}
