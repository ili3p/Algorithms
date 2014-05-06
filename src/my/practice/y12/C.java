package my.practice.y12;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int sum = 0;
		boolean over = false;
		for (int a = 0; !over; ++a) {
			for (int b = 0;; ++b) {
				int N = a * a + b;
				int M = a + b * b;
				if (n == N && m == M) {
					++sum;
				}
				if (N > n || M > m) {
					over = b == 0;
					break;
				}

			}
		}
		System.out.println(sum);
		sum =0;
		for (int i = 0; i <= n; ++i) {
				if ((n-i*i)*(n-i*i)+i ==m)
					{System.out.println(i);
					sum++;}
		}
		System.out.println(sum);
	}
}