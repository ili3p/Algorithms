package my.topcoder;
import java.util.*;

public class TheDeviceDiv2 {

    public String identify(String[] plates) {
        if (plates.length == 1) {
            return "NO";
        }
        int n = plates.length;
        int m = plates[0].length();
        char[][] map = new char[n][m];
        for (int i = 0; i < plates.length; i++) {
            map[i] = plates[i].toCharArray();
        }

        int[] ones = new int[m];
        int[] zeros = new int[m];
        for (int j = 0; j < m; ++j) {
            for (int i = 0; i < n; ++i) {
                if (map[i][j] == '1') {
                    ++ones[j];
                } else {
                    ++zeros[j];
                }
            }
        }
        boolean isOk = true;
        for (int i = 0; i < ones.length && isOk; i++) {
            isOk = ones[i] >= 2 && zeros[i] >= 1;
        }

        if (isOk) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public String identify2(String[] plates) {
        if (plates.length == 1) {
            return "NO";
        }

        String result = "NO";

        int[] sub = new int[] { 0, 1 };

        while (sub != null) {

            char[] p1 = plates[sub[0]].toCharArray();
            char[] p2 = plates[sub[1]].toCharArray();
            char[] and = new char[p1.length];
            char[] or = new char[p1.length];
            char[] xor = new char[p1.length];

            for (int i = 0; i < p1.length; i++) {
                and[i] = p1[i] == '1' && p2[i] == '1' ? '1' : '0';
                or[i] = p1[i] == '1' || p2[i] == '1' ? '1' : '0';
                xor[i] = p1[i] == p2[i] ? '1' : '0';
            }

            boolean x1 = !Arrays.equals(and, or);
            x1 &= !Arrays.equals(and, xor);
            x1 &= !Arrays.equals(or, xor);

            if (x1) {
                return "YES";
            }

            sub = nextSubset(plates.length, sub);
        }

        return result;
    }

    private static int[] nextSubset(int n, int[] subset) {
        int l = subset.length;
        int[] result = new int[l];
        System.arraycopy(subset, 0, result, 0, l);
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

}
