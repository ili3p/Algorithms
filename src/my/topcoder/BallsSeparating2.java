package my.topcoder;

import java.text.*;
import java.util.*;

public class BallsSeparating2 {

    /**
     * Lexicographically next permutation of the set.
     * Total number of such sets is (N!)/(k1!*k2!...ki!) where k1-ki is the
     * number of repetitions. Example {0,1,1,2} has total 4!/2! number of
     * distinct sets.
     * @param <T>
     *            Comparable object.
     * @param set
     *            Array of Comparable objects.
     * @return next lexicographically permutation.
     */
    @SuppressWarnings("unchecked")
    private static <T> Comparable<T>[] nextPermutation(Comparable<T>[] set) {
        int n = set.length;

        for (int i = n - 2; i > -1; --i) {
            for (int j = n - 1; j != i; --j) {
                if (set[i].compareTo((T) set[j]) < 0) {
                    T t = (T) set[i];
                    set[i] = set[j];
                    set[j] = (Comparable<T>) t;
                    Arrays.sort(set, i + 1, n);
                    return set;
                }
            }
        }
        return null;
    }

    /**
     * Lexicographically next permutation of the set.
     * Total number of such sets is (N!)/(k1!*k2!...ki!) where k1-ki is the
     * number of repetitions. Example {0,1,1,2} has total 4!/2! number of
     * distinct sets.
     * @param set
     *            array of integers.
     * @return next lexicographically permutation.
     */
    private static int[] nextPermutation(int[] set) {
        int n = set.length;

        for (int i = n - 2; i > -1; --i) {
            for (int j = n - 1; j != i; --j) {
                if (set[i] < set[j]) {
                    int t = set[i];
                    set[i] = set[j];
                    set[j] = t;
                    Arrays.sort(set, i + 1, n);
                    return set;
                }
            }
        }
        return null;
    }

    static class Int implements Comparable<Int> {
        int n;

        Int(int k) {
            n = k;
        }

        public int compareTo(Int o) {
            return n - o.n;
        }

        @Override
        public String toString() {
            return String.valueOf(n);
        }
    }

    public static void main(String[] args) {

        int n = 4;
        String[] set = new String[5];
        set[0] = new String("0");
        set[1] = new String("1");
        set[2] = new String("2");
        set[3] = new String("3");
        set[4] = new String("3");
        System.out.println(set.length);
        int c = 0;
        NumberFormat df = DecimalFormat.getInstance();
        df.setMaximumFractionDigits(0);
        long max = 0;
        while (set != null) {
            ++c;
            long t = System.nanoTime();
            System.out.println(Arrays.toString(set));
            set = (String[]) nextPermutation(set);
            t = (System.nanoTime() - t);
            max = Math.max(max, t);
        }
        System.out.println(c);

        System.out.println("Run time: " + df.format(max) + " ns");
    }

    private static int[] nextSubset(int n, int[] subset) {
        int l = subset.length;

        boolean isNew = false;

        for (int k = l - 1; k > -1; --k) {
            int d = l - 1 - k;
            int a = subset[k];
            if (a + 1 <= (n - d)) {
                int j = 1;
                for (int i = k; i < l; ++i) {
                    subset[i] = a + j;
                    ++j;
                    isNew = true;
                }
                break;
            }
        }
        return isNew ? subset : null;
    }

    public int minOperations(int[] red, int[] green, int[] blue) {
        int numBoxes = red.length;

        int numColors = 0;

        boolean hasRed = !Arrays.equals(red, new int[numBoxes]);
        if (hasRed) {
            ++numColors;
        }

        boolean hasGreen = !Arrays.equals(green, new int[numBoxes]);
        if (hasGreen) {
            ++numColors;
        }

        boolean hasBlue = !Arrays.equals(blue, new int[numBoxes]);
        if (hasBlue) {
            ++numColors;
        }

        if (numColors > numBoxes) {
            return -1;
        }
        int[] subset = new int[numColors];
        for (int i = 0; i < numColors; ++i) {
            subset[i] = i;
        }
        int[] bestSub = copyArray(subset);
        int lowsetCost = Integer.MAX_VALUE;

        while (subset != null) {

            int[] tempSet = copyArray(subset);

            while (tempSet != null) {

                int r = getCost(tempSet[0], green, blue);
                int g = getCost(tempSet[1], red, blue);
                int b = getCost(tempSet[2], red, green);
                int c = r + g + b;

                for (int i = 0; i < numBoxes; ++i) {
                    if (i != tempSet[0] && i != tempSet[1] && i != tempSet[2]) {
                        r = getCost(i, green, blue);

                        g = getCost(i, red, blue);
                        b = getCost(i, red, green);
                        c += Math.min(g, Math.min(r, b));
                    }
                }
                if (c < lowsetCost) {
                    lowsetCost = c;
                    bestSub = copyArray(subset);
                }
                // System.out.println(Arrays.toString(tempSet));
                // tempSet = nextPermutation(tempSet);
            }
            subset = nextSubset(numBoxes - 1, subset);
        }
        // System.out.println(Arrays.toString(bestSub));
        // Arrays.sort(bestSub);
        // for (int i = 0; i < numBoxes; ++i) {
        // if (Arrays.binarySearch(bestSub, i) < 0) {
        // int r = getCost(i, green, blue);
        //
        // int g = getCost(i, red, blue);
        // int b = getCost(i, red, green);
        // lowsetCost += Math.min(g, Math.min(r, b));
        // }
        // }

        return lowsetCost;
    }

    private boolean contain(int[] bestSub, int i) {
        for (int j = 0; j < bestSub.length; j++) {
            if (i == bestSub[j]) {
                return true;
            }
        }
        return false;
    }

    private static int[] copyArray(int[] subset) {
        int[] result = new int[subset.length];
        for (int i = 0; i < subset.length; ++i) {
            result[i] = subset[i];
        }
        return result;
    }

    private int getCost(int i, int[] c1, int[] c2) {
        return c1[i] + c2[i];
    }

    /**
     * 
     int k = green[0] + blue[0];
     * int redBox = 0;
     * for (int i = 1; i < numBoxes; ++i) {
     * int m = green[i] + blue[i];
     * if (m < k) {
     * k = m;
     * redBox = i;
     * }
     * }
     * @param place
     * @param red
     * @return
     */
    private int check3(int place, int[] red) {
        int k = 0;
        for (int i = 0; i < red.length; ++i) {
            if (i == place) {
                continue;
            } else {
                k += red[i];
            }
        }
        return k;
    }

    private boolean check2(int[] red) {
        // NO reds
        return red[0] == 0 && red[1] == 0;
    }

    private boolean check(int[] red, int[] green, int[] blue) {
        // only one color
        return red[0] > 0 && (green[0] > 0 || blue[0] > 0);
    }

}
