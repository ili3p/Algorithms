package my.topcoder;
import java.util.*;

public class LeftOrRight {

    public int maxDistance(String program) {
        char[] cR = program.replaceAll("\\?", "R").toCharArray();
        char[] cL = program.replaceAll("\\?", "L").toCharArray();
        int r = 0;
        int l = 0;
        int max = 0;
        for (int i = 0; i < cL.length; i++) {
            if (cL[i] == 'L') {
                --r;
            } else {
                ++r;
            }
            if (cR[i] == 'L') {
                --l;
            } else {
                ++l;
            }

            max = Math.max(max, Math.abs(r));
            max = Math.max(max, Math.abs(l));
        }
        return max;
    }

}
