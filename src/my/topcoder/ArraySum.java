package my.topcoder;

import java.util.*;

public class ArraySum {
    public int findDigit(int N) {
        if (N == 0) {
            return 1;
        }
        if (N == 1) {
            return 1;
        }

        int i = 1;
        int sum = 1;
        int toAdd = sum;
        int o = '0';
        while (true) {
            boolean f = true;
            if (sum > 9) {
                f = false;
                char[] nums = String.valueOf(sum).toCharArray();// getChars(sum);
                toAdd = 0;
                for (int l = 0; l < nums.length; ++l) {
                    int s = nums[l] - o;
                    if (i == N) {
                        return s;
                    }
                    toAdd += s;
                    ++i;
                }
            } else {
                toAdd = sum;
            }
            sum += toAdd;
            if (f) {
                if (i == N) {
                    return toAdd;
                }
                ++i;
            }
        }
    }

    //
    // private String getNums(long res) {
    // StringBuilder sb = new StringBuilder();
    // while (res > 9) {
    // int k = (int) (res % 10);
    // sb.append(k + "");
    // res /= 10;
    // }
    // sb.append(res + "");
    // return sb.reverse().toString();
    // }

    public static void main(String[] args) {
        ArraySum a = new ArraySum();
        long s = System.nanoTime();
        System.out.println(a.findDigit(100000000));
        System.out.println((System.nanoTime() - s) / 1e9);
        s = System.nanoTime();
        System.out.println(a.findDigit(100000000));
        System.out.println((System.nanoTime() - s) / 1e9);
    }
}
