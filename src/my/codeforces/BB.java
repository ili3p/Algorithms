package my.codeforces;

import java.util.*;

public class BB {
    public static void main(String[] args) {
        System.out.println("Aa".hashCode());
        System.out.println("BB".hashCode());
        // TODO solve it.
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long k = sc.nextLong();

        sc.close();

        long result = -1;

        if (k >= n) {
            result = 1;
        } else {  // k < n

            long sum = k;
            long g = k - 1;
            long r = (g + 1) * k - g - (g * (g + 1)) / 2;
            long m = r - n;
            if (m > 0) {

                while (result == -1) {
                    r = getSum(g, k);
                    m = r - n;
                    if (m < 0) {
                        g += g / 2;
                    } else if (m > 0) {
                        g /= 2;
                    } else {
                        result = g;
                    }
                }
                // while (m > 0) {
                // for (g = k - 2; g > 0; --g) {
                // r = (g + 1) * k - g - (g * (g + 1)) / 2;
                // }
                // m = r - n;
                // }
                // if (m == 0) {
                // result = g;
                // }
                // sum = r;
                // for (long i = g; i < k - 1; ++i) {
                // r = sum + (k - i) - 1;
                //
                // if (r <= n) {
                // sum = r;
                // ++g;
                // } else {
                // i += r - n - 1;
                // }
                //
                // if (sum == n) {
                // result = g;
                // break;
                // }
                // }

            } else if (m == 0) {
                result = k - 1;
            }
        }

        System.out.println(result);

    }

    private static long getSum(long g, long k) {
        return (g + 1) * k - g - (g * (g + 1)) / 2;
    }
}