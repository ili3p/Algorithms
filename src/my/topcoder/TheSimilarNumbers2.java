package my.topcoder;
import java.util.*;

public class TheSimilarNumbers2 {

    public int find(int lower, int upper) {

        Set<Integer> set = new HashSet<Integer>();
        set.add(lower);

        for (int i = lower; i <= upper; ++i) {
            boolean u = true;
            for (Integer integer : set) {
                if (isSimilar(i, integer)) {
                    u = false;
                    break;
                }
            }
            if (u) {
                set.add(i);
            }
        }
        return set.size();
    }

    private boolean isSimilar(int A, int B) {
        if (A == B) {
            return false;
        }
        return A <= 10 * B && B <= 10 * A;
    }

}
