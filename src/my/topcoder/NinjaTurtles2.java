package my.topcoder;
public class NinjaTurtles2 {

    public int countOpponents(int P, int K) {
        int k = 0;
        for (int n = 1;k<P; ++n) {
            int s1 = (int) (3 * Math.floor(1.0 * n / K));
            int s2 = (int) Math.floor(1.0 * n / 3);
            k = s1+s2;
            if (k == P) {
                return n;
            }
        }
        return -1;
    }

}
