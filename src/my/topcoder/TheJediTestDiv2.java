package my.topcoder;
import java.util.*;

public class TheJediTestDiv2 {

    public int countSupervisors(int[] students, int Y, int J) {
        int k = Integer.MAX_VALUE;

        for (int i = 0; i < students.length; ++i) {
            int kk = 0;
            int rem = students[i] - Y;
            if (rem > 0) {
                kk = (int) Math.ceil(1.0 * rem / J);
            }
            for (int j = 0; j < students.length; ++j) {
                if (j == i) {
                    continue;
                }
                kk += (int) Math.ceil(1.0 * students[j] / J);
            }
            k = Math.min(kk, k);
        }

        return k;
    }

}
