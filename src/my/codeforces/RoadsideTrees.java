package my.codeforces;

import java.util.Scanner;

public class RoadsideTrees {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int numberOfTrees = sc.nextInt();
		int[] trees = new int[numberOfTrees];
		for (int i = 0; i < trees.length; i++) {
			trees[i] = sc.nextInt();

		}

		int sec = numberOfTrees;
		int prev = 0;
		for (int i = 0; i < trees.length; i++) {
			sec += Math.abs(prev - trees[i]) + 1;
			prev = trees[i];
		}
		System.out.println(sec);
	}
}
