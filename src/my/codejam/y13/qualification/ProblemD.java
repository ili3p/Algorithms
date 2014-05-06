package my.codejam.y13.qualification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class ProblemD {

    static void runIt() throws IOException {
        String inFName = "resource/cj13/D-small-attempt0.in";
        // String inFName = "resource/cj13/D-large.in";
        String outFName = "resource/cj13/D-small.out";
        // String outFName = "resource/cj13/D-large.out";

        BufferedReader in = new BufferedReader(new FileReader(inFName));
        PrintWriter out = new PrintWriter(new File(outFName));

        int testCases = Integer.parseInt(in.readLine());

        for (int t = 0; t < testCases; ++t) {
            int[] keys = new int[201];
            String[] line = in.readLine().split(" ");

            int K = Integer.parseInt(line[0]);
            int N = Integer.parseInt(line[1]);

            String[] ks = in.readLine().split(" ");
            for (int i = 0; i < ks.length; ++i) {
                ++keys[Integer.parseInt(ks[i])];
            }

            String[][] chests = new String[N][];
            for (int i = 0; i < N; ++i) {
                chests[i] = in.readLine().split(" ");
            }

            StringBuilder output = new StringBuilder();
            output.append("Case #" + (t + 1) + ": ");

            for (int i = 0; i < N; ++i) {
                
            }

            output.append("");

            System.out.println(output);
            out.println(output);
        }

        in.close();
        out.flush();
        out.close();
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

    private static void getChest(String[] ks, int[] keys) {
        for (int i = 2; i < ks.length; ++i) {
            ++keys[Integer.parseInt(ks[i])];
        }
    }

    public static void main(String[] args) {

        try {
            ProblemD.runIt();
        } catch (IOException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();

        } catch (Exception e) {

            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }
}
