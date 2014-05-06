package my.topcoder;
public class KingdomAndDucks {

    public int minDucks(int[] duckTypes) {
        int[] n = new int[51];
        for (int i = 0; i < duckTypes.length; i++) {
            int j = duckTypes[i];
            ++n[j];
        }
        int c = 0;
        int m = 0;
        for (int i = 0; i < n.length; ++i) {
            m = Math.max(m, n[i]);
            if (n[i] > 0) {
                ++c;
            }
        }

        return m*c;
    }

}
