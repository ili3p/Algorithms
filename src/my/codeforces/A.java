package my.codeforces;
import java.util.*;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int t = 0; t < num; ++t) {
			int a = sc.nextInt();
			if (360 % (180 - a) == 0) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}

	}
}
