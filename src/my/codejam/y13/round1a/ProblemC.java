package my.codejam.y13.round1a;

import java.io.*;
import java.util.*;

public class ProblemC {

    static void runIt() throws IOException {

        String inFName = "resource/cj13/C-small-attempt0.in";
        // String inFName = "resource/cj13/C-large-1.in";
        String outFName = "resource/cj13/C-small.out";
        // String outFName = "resource/cj13/C-large-1.out";

        PrintWriter out = new PrintWriter(new File(outFName));
        Scanner sc = new Scanner(new File(inFName));

        int testCases = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < testCases; ++t) {

            StringBuilder output = new StringBuilder();
            output.append("Case #" + (t + 1) + ": ");
            output.append("");
            System.out.println(output);
            out.println(output.toString().trim());

            sc.nextLine();
        }
        sc.close();

        out.flush();
        out.close();

    }

    public static void main(String[] args) {

        try {
            ProblemC.runIt();
        } catch (IOException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();

        } catch (Exception e) {

            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }
}
