package my.codeforces;
import java.util.*;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] m = new int[num + 1];
		for (int i = 0; i < m.length - 1; i++) {
			m[i] = sc.nextInt();
		}
		m[num] = Integer.MAX_VALUE;
		boolean f = false;
		int t = num;
		int last = m[0];
		for (int i = 1; i < m.length; i++) {
			if (!f && m[i] - last > 0) {
				t = i;
				f = true;
			}
			if (m[i] - last < 0) {
				f = false;
			}

			last = m[i];
		}
		System.out.println(t - 1);
	}

}
