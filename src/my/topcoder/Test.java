package my.topcoder;
import java.io.*;
import java.util.*;

public class Test {

    static final long[] FACTORIALS = new long[] { 1l, 1l, 2l, 6l, 24l, 120l,
            720l, 5040l, 40320l, 362880l, 3628800l, 39916800l, 479001600l,
            6227020800l, 87178291200l, 1307674368000l, 20922789888000l,
            355687428096000l, 6402373705728000l, 121645100408832000l,
            2432902008176640000l };

    private static int[] copyArray(int[] subset) {
        int[] result = new int[subset.length];
        for (int i = 0; i < subset.length; ++i) {
            result[i] = subset[i];
        }
        return result;
    }

    private static int[] nextSubset(int n, int[] subset) {
        int l = subset.length;
        int[] result = copyArray(subset);
        boolean newSubset = false;

        for (int k = l - 1; k > -1; --k) {
            int d = l - 1 - k;
            int a = subset[k];
            if (a + 1 <= (n - d)) {
                int j = 1;
                for (int i = k; i < l; ++i) {
                    result[i] = a + j;
                    ++j;
                    newSubset = true;
                }
                break;
            }
        }
        return newSubset ? result : null;
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.test();
    }

    private void test() {
        int[] subset = new int[4];
        for (int i = 0; i < subset.length; ++i) {
            subset[i] = i;
        }
        int[][] perm = permutations(subset);

        for (int i = 0; i < perm.length; i++) {
            System.out.println(Arrays.toString(perm[i]));
        }
    }

    private static int[][] permutations(final int[] set) {

        int n = set.length;
        if (n > 21) {
            return null;
        }
        int nFact = (int) FACTORIALS[n];
        int[][] result = new int[nFact][n];
        result[0] = set;
        for (int i = 1; i < nFact; ++i) {
            int[] temp = new int[n];
            for (int k = 0; k < n; ++k) {
                temp[k] = result[i - 1][k];
            }
            int s = (n - i) % (n - 1);
            System.out.println("S:" + s);
            int t = temp[s];
            temp[s] = temp[s + 1];
            temp[s + 1] = t;
            result[i] = temp;
        }

        return result;
    }

}
