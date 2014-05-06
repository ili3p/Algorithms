package my.topcoder;
import java.util.*;

public class TheSquareRootDilemma {

    public int countPairs(int N, int M) {
        Set<String> set = new HashSet<String>();

        int c = 0;
        for (int A = 1; A <= N; ++A) {
            for (int B = 1; B <= M; ++B) {
                if (set.contains(A + " " + B) || set.contains(B + " " + A)) {
                    ++c;
                }
                if (A == B) {
                    set.add(A + " " + B);
                    ++c;
                }
                
            }
        }

        return c;
    }

}
