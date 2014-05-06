package my.codejam.y13.round1a;

import java.io.*;
import java.util.*;

public class ProblemD {

    static void runIt() throws IOException {
        String inFName = "resource/cj13/D-small-attempt0.in";
        // String inFName = "resource/cj13/D-large.in";
        String outFName = "resource/cj13/D-small.out";
        // String outFName = "resource/cj13/D-large.out";

        PrintWriter out = new PrintWriter(new File(outFName));
        Scanner sc = new Scanner(new File(inFName));

        int testCases = Integer.parseInt(sc.nextLine());

        for (int T = 0; T < testCases; ++T) {

            long r = sc.nextLong();
            long t = sc.nextLong();

            long k = (long) Math.floor((t + 1) / 2.0) - r;

            StringBuilder output = new StringBuilder();
            output.append("Case #" + (T + 1) + ": ");
            output.append(k);
            System.out.println(output);
            out.println(output.toString().trim());
        }
        sc.close();

        out.flush();
        out.close();
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
