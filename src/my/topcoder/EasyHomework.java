package my.topcoder;
public class EasyHomework {

    public String determineSign(int[] A) {
        return "";
    }

    public String determineSign2(int[] A) {
        String pos = "POSITIVE", neg = "NEGATIVE", zer = "ZERO";
        int c = 0;
        for (int i = 0; i < A.length; i++) {
            int j = A[i];
            if (j == 0) {
                return zer;
            }
            if (j < 0) {
                ++c;
            }
        }
        if (c % 2 == 0) {
            return pos;
        } else {
            return neg;
        }
    }

}
