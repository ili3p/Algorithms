package my.topcoder;
public class PairingPawns {

    public int savedPawnCount(int[] start) {
        for (int i = start.length - 1; i > 0; --i) {
            int re = start[i] / 2;
            start[i]/=2;
            start[i-1]+=re;
        }
        return start[0];
    }

}
