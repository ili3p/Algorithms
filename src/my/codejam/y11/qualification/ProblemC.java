package my.codejam.y11.qualification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ProblemC {

    static void runIt() throws IOException {

//        String inFName = "resource/C-small-attempt0.in";
         String inFName = "resource/C-large.in";
//        String outFName = "resource/C-small.out";
         String outFName = "resource/C-large.out";

        BufferedReader in = new BufferedReader(new FileReader(inFName));
        PrintWriter out = new PrintWriter(new File(outFName));

        int testCases = Integer.parseInt(in.readLine());

        for (int i = 0; i < testCases; ++i) {

            String line = in.readLine();
            StringBuilder output = new StringBuilder();
            output.append("Case #" + (i + 1) + ": ");

            String[] candies = in.readLine().split(" ");
            int[] bitCount = new int[20];
            int totalCandies = 0, min = Integer.MAX_VALUE;
            for (int j = 0; j < candies.length; j++) {
                int currentCandy = Integer.parseInt(candies[j]);
                if (currentCandy < min) {
                    min = currentCandy;
                }
                totalCandies += currentCandy;

                char[] binary = Integer.toBinaryString(currentCandy).toCharArray();

                for (int k =0; k < binary.length ; ++k) {
                    char c = binary[k];
                    if (c == '1') {
                        ++bitCount[20 - binary.length + k];
                    }
                }
            }
            boolean isEven = true;
            for (int j = 0; j < bitCount.length && isEven; j++) {
                int k = bitCount[j];
                isEven = (k % 2 == 0 || k == 0);
            }
            if (isEven) {
                output.append(totalCandies - min);
            } else {
                output.append("NO");
            }
            System.out.println(output);
            out.println(output);
        }

        in.close();
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
