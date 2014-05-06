package my.topcoder;

public class BlackWhiteMagic {

    public int count(String creatures) {

        char[] c = creatures.toCharArray();
        int W = 0;
        for (int i = 0; i < c.length; i++) {
            char d = c[i];
            if (d == 'W') {
                ++W;
            }
        }

        int cc = 0;

        for (int i = 0; i < c.length; i++) {
            char d = c[i];

            if (d == 'W') {
                if (i >= W) {
                    ++cc;
                }
            }
        }

        return cc;
    }

}
