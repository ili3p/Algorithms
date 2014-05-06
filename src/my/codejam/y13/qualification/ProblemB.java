package my.codejam.y13.qualification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ProblemB {

    static void runIt() throws IOException {

//        String inFName = "resource/cj13/B-small-attempt0.in";
         String inFName = "resource/cj13/B-large.in";
//        String outFName = "resource/cj13/B-small.out";
         String outFName = "resource/cj13/B-large.out";

        BufferedReader in = new BufferedReader(new FileReader(inFName));
        PrintWriter out = new PrintWriter(new File(outFName));

        int testCases = Integer.parseInt(in.readLine());

        for (int t = 0; t < testCases; ++t) {

            String[] line = in.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int M = Integer.parseInt(line[1]);

            boolean isPossible = true;
            int[][] map = new int[N][M];

            for (int n = 0; n < N; ++n) {
                line = in.readLine().split(" ");
                for (int m = 0; m < M; ++m) {
                    map[n][m] = Integer.parseInt(line[m]);
                }
            }

            for (int n = 0; n < N && isPossible; ++n) {
                for (int m = 0; m < M && isPossible; ++m) {
                    int number = map[n][m];

                    boolean ok = tryVertical(map, n, m, number, N);
                    if (!ok) {
                        ok = tryHorizontal(map, n, m, number, M);
                    }

                    isPossible = ok;
                }
            }

            StringBuilder output = new StringBuilder();
            output.append("Case #" + (t + 1) + ": ");
            output.append(isPossible ? "YES" : "NO");
            System.out.println(output);
            out.println(output);
        }

        in.close();
        out.flush();
        out.close();
    }

    private static boolean tryHorizontal(int[][] map, int n, int m, int number,
            int M) {
        // try left
        for (int i = m - 1; i > -1; --i) {
            int other = map[n][i];
            if (other > number) {
                return false;
            }
        }

        // try right
        for (int i = m + 1; i < M; ++i) {
            int other = map[n][i];
            if (other > number) {
                return false;
            }
        }
        return true;
    }

    private static boolean tryVertical(int[][] map, int n, int m, int number,
            int N) {

        // try up
        for (int i = n - 1; i > -1; --i) {
            int other = map[i][m];
            if (other > number) {
                return false;
            }
        }

        // try down
        for (int i = n + 1; i < N; ++i) {
            int other = map[i][m];
            if (other > number) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        try {
            ProblemB.runIt();
        } catch (IOException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();

        } catch (Exception e) {

            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }
}
