package my.topcoder;
import org.junit.*;

public class TheFrog {
    public static void main(String[] args) {
        TheFrog f = new TheFrog();
        int D = 30000;
        int[] L = new int[] { 4623, 20035, 9064, 20689, 22308, 10866, 16189,
                16690, 27787, 16038, 1240, 5281, 5299, 26411, 1730, 17341,
                3987, 4176, 10852, 26275, 15948, 22822, 21127, 13471, 29884,
                5463, 15884, 5298, 1701, 4756, 13711, 8637, 946, 25163, 8457,
                19435, 19427, 15798, 14946, 16278, 15904, 9598, 17986, 8470,
                28206, 2058, 19804, 5610, 11641, 10279 };

        int[] R = new int[] { 17400, 30127, 9240, 33631, 42945, 20054, 33171,
                38103, 35161, 26247, 26148, 30727, 13265, 30771, 23785, 37457,
                17061, 8383, 40494, 45501, 44225, 27923, 30842, 35429, 57603,
                31673, 19003, 8686, 7424, 6331, 18738, 11706, 8381, 44299,
                11291, 22786, 46476, 18935, 23666, 32892, 45564, 22461, 34676,
                36573, 28517, 30173, 21196, 24151, 32930, 29658 };
        double r = f.getMinimum(D, L, R);
        double m = f.getMinimumMy(D, L, R);

        System.out.println(r);
        System.out.println(m);
        Assert.assertEquals(r, m, 1e-9);
    }

    public double getMinimum(int D, int[] L, int[] R) {
        return 0.0;
    }

    public double getMinimumMy(int D, int[] L, int[] R) {
        int max = Integer.MIN_VALUE;
        int far = Integer.MIN_VALUE;

        for (int i = 0; i < R.length; i++) {
            int d = R[i] - L[i];
            max = Math.max(max, d);
            far = Math.max(far, R[i]);
        }

        int d = (int) Math.floor(far / max);
        double x = 0.0;
        boolean good = false;
        while (!good) {
            good = true;
            x = 1.0 * far / d;
            for (int i = 0; i < d; ++i) {
                double f = x * (i + 1);
                for (int j = 0; j < R.length; j++) {
                    good &= f <= L[j] || f >= R[j];
                }
            }
            --d;
        }
        return x;
    }

}
