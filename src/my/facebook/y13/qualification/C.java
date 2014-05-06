package my.facebook.y13.qualification;
import java.io.*;
import java.util.*;

public class C {
	public static void main(String[] args) {
		try {
			String fileName = "C_test";

			PrintWriter out = new PrintWriter(new File("resource/fb/out_" + fileName));
			Scanner sc = new Scanner(new File("resource/fb/" + fileName));

			int T = sc.nextInt();
			for (int i = 1; i <= T; ++i) {
				long result = 0;

				int N = sc.nextInt();
				int K = sc.nextInt();
				int[] a = new int[N];

				for (int j = 0; j < a.length; j++) {
					a[j] = sc.nextInt();
				}
				Arrays.sort(a);

				long[][] dp = new long[K + 1][N + 1];

				Arrays.fill(dp[1], 1);
				if (K > 1) {
					for (int n = 0; n < N; ++n) {
						dp[2][n] = n;
					}
				}

				for (int k = 3; k <= K; ++k) {
					for (int n = 1; n < N; ++n) {
						dp[k][n] = dp[k][n - 1] + dp[k - 1][n - 1];
						dp[k][n] %= 1000000007;
					}
				}

				for (int n = 0; n < N; ++n) {
					result += dp[K][n] * a[n];
					result %= 1000000007;
				}

				out.println("Case " + i + "#: " + result);
				System.out.println("Case " + i + "#: " + result);
			}

			sc.close();
			out.flush();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
