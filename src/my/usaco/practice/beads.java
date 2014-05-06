package my.usaco.practice;

/*
 ID: ilija131
 LANG: JAVA
 TASK: beads
 */
import java.io.*;
import java.util.*;

public class beads {
    public static void main(String[] args) throws IOException {
        // Use BufferedReader rather than RandomAccessFile; it's much faster
        // BufferedReader f = new BufferedReader(new FileReader(
        // "beads.in"));
        BufferedReader f = new BufferedReader(new FileReader(
                "resource/beads.in"));
        // input file name goes above
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
                "beads.out")));
        int i1 = Integer.parseInt(f.readLine()); // first integer
        String neck = f.readLine(); // second integer
        int result = solve(i1, neck);
        System.out.println(result);
        // out.println(result); // output result
        // out.close(); // close the output file
        System.exit(0); // don't omit this!
    }

    private static int solve(int i1, String neck) {

        char[] c = neck.toCharArray();
        char last = c[0];
        boolean flip = true;
        int max = 0;

        int red = 0, blue = 0, white = 0;

        for (int i = 0; i < c.length * 2; i++) {
            char cur = c[i % c.length];

            if (last != 'w' && cur != 'w' && last != cur) {
                flip = !flip;
                max = Math.max(max, blue + red);
                if (flip) {
                    blue = 0;
                } else {
                    red = 0;
                }
            }
            if (cur == 'w') {
                ++white;
            } else {

                if (flip) {
                    blue += white + 1;
                } else {
                    red += white + 1;
                }
                white = 0;
                last = cur;
            }
        }
        max = Math.max(max, blue + red);
        return Math.min(max, c.length);
    }
}
