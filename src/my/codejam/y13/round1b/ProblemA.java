package my.codejam.y13.round1b;

import java.io.*;
import java.util.*;

public class ProblemA {

    static void runIt() throws IOException {

        String inFName = "resource/cj13/A-small-attempt1.in";
        // String inFName = "resource/cj13/A-large.in";
        String outFName = "resource/cj13/A-small.out";
        // String outFName = "resource/cj13/A-large.out";

        PrintWriter out = new PrintWriter(new File(outFName));
        Scanner sc = new Scanner(new File(inFName));

        int testCases = Integer.parseInt(sc.nextLine());

        for (int T = 0; T < testCases; ++T) {

            long A = sc.nextInt();
            int N = sc.nextInt();
            int[] motes = new int[N];

            for (int i = 0; i < N; ++i) {
                motes[i] = sc.nextInt();
            }

            Arrays.sort(motes);
            long count = 0;
            for (int i = 0; i < N; ++i) {
                int mot = motes[i];
                if (A > motes[i]) {
                    A += motes[i];
                } else {
                    if ((A + (A - 1)) > motes[i]) {
                        ++count;
                        A = A + (A - 1) + motes[i];
                    } else {
                        count += (N - i);
                        break;
                    }
                }
            }

            StringBuilder output = new StringBuilder();
            output.append("Case #" + (T + 1) + ": ");
            output.append(count);
            System.out.println(output);
            out.println(output.toString().trim());
        }

        sc.close();
        out.flush();
        out.close();
    }

    public static void main(String[] args) {

        try {
            ProblemA.runIt();
        } catch (IOException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();

        } catch (Exception e) {

            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }
}
