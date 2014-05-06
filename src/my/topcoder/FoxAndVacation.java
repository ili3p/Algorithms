package my.topcoder;
import java.util.*;

public class FoxAndVacation {

    public int maxCities(int total, int[] d) {
        Arrays.sort(d);
        int c = 0;
        while (total > -1) {

            total -= d[c++];
            if (d.length == c) {
                if (total >= 0) {
                    return c;
                } else {
                    return c - 1;
                }
            }
        }
        return c - 1;
    }

}
