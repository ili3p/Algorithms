package my.topcoder;
public class SkiResortsEasy {

    public int minCost(int[] altitude) {
        int c = 0;
        for (int i = 0; i < altitude.length - 1; i++) {
            int p = altitude[i];
            int n = altitude[i + 1];
            if (n > p) {
                c += n - p;
                altitude[i + 1] = p;
            }
        }
        return c;
    }

}
