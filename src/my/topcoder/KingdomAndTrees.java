package my.topcoder;
import java.util.*;

public class KingdomAndTrees {

    public int minLevel(int[] heights) {
        int cLevel = 0;
        for (int i = 0; i < heights.length - 1; ++i) {
            int first = heights[i];
            int snd = heights[i + 1];
            if (first < snd) {
                continue;
            } else {
                int r = (i == 0 ? 1 : heights[i - 1] + 1);
                int maxD = first - r;
                int dif = first - snd + 1;
                int maxC = 0;
                if (dif % 2 == 0) {
                    maxC = dif / 2;
                    int d = maxC - maxD;
                    if (d > 0) {
                        cLevel = Math.max(
                                cLevel,
                                Math.max(first - r,
                                        Math.abs(snd - (first - maxD + 1))));
                        heights[i] = first - maxD;
                        heights[i + 1] = heights[i] + 1;
                    } else {
                        cLevel = Math.max(cLevel, maxC);
                        heights[i] -= maxC;
                        heights[i + 1] += maxC;
                    }
                } else {
                    maxC = (int) Math.ceil(1.0 * dif / 2);
                    int d = maxC - 1 - maxD;
                    if (d > 0) {
                        cLevel = Math.max(
                                cLevel,
                                Math.max(first - r,
                                        Math.abs(snd - (first - maxD + 1))));
                        heights[i] = first - maxD;
                        heights[i + 1] = heights[i] + 1;
                    } else {
                        cLevel = Math.max(cLevel, maxC);
                        heights[i] -= maxC - 1;
                        heights[i + 1] += maxC;
                    }
                }

            }
        }
        return cLevel;
    }

}
