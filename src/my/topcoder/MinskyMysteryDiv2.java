package my.topcoder;
import java.math.*;
import java.util.*;

public class MinskyMysteryDiv2 {

    public long computeAnswer(long N) {
        long[] b = new long[5];

        b[0] = N;

        b[1] += 1;
        if (N == 1) {
            return -1;
        }
        List<String> list = new ArrayList<String>(10000);

        while (true) {
            String ss = b[0] + "," + b[1] + "," + b[2] + "," + b[3] + "," + b[4];
            if (list.contains(ss)) {
                return -1;
            }
            list.add(ss);
            if (b[1] == Long.MAX_VALUE) {
                return -1;
            }
            b[1] += 1;
            b[4] = 0;
            while (b[0] > 0) {
                while (b[0] > 0 && b[1] > 0) {
                    b[0] -= 1;
                    b[1] -= 1;
                    if (b[2] == Long.MAX_VALUE || b[3] == Long.MAX_VALUE) {
                        return -1;
                    }
                    b[2] += 1;
                    b[3] += 1;
                }
                b[4] += 1;
                if (b[0] == 0 && b[1] == 0) {
                    BigInteger s = new BigInteger(b[4] + "");
                    s = s.add(new BigInteger(b[3] + ""));
                    if (s.compareTo(new BigInteger(Long.MAX_VALUE + "")) > 0) {
                        return -1;
                    }
                    b[4] += b[3];
                    b[3] = 0;
                    return b[4];
                }
                BigInteger s = new BigInteger(b[1] + "");
                s = s.add(new BigInteger(b[3] + ""));
                if (s.compareTo(new BigInteger(Long.MAX_VALUE + "")) > 0) {
                    return -1;
                }

                b[1] += b[3];
                b[3] = 0;
            }
            BigInteger s = new BigInteger(b[0] + "");
            s = s.add(new BigInteger(b[2] + ""));
            if (s.compareTo(new BigInteger(Long.MAX_VALUE + "")) > 0) {
                return -1;
            }

            b[0] += b[2];
            b[2] = 0;
        }
    }

}
