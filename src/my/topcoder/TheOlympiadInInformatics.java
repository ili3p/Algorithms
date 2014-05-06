package my.topcoder;
import java.util.*;

public class TheOlympiadInInformatics {

    public int find(int[] sums, int k) {
        int n = sums.length;
        int max = Integer.MIN_VALUE;
        Arrays.sort(sums);
        if (k == 0) {
            return sums[sums.length - 1];
        } else if (k > sums[sums.length - 1]) {
            return 0;
        } else if (sums[sums.length - 1] == 0) {
            return 0;
        } else {
            int ppl = (int) Math.ceil(1.0 * k / n);

            for (int i = 0; i < sums.length; ++i) {

                int p = (sums[i] / (ppl+1) + 1);

                if (sums[i] / p == ppl) {
                    max = Math.max(max, p);
                } else {
                    System.out.println("h");
                }
            }
        }
        return max - 1;
    }
}
