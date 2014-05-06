package my.codejam.y11.qualification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ProblemA {

    static void runIt() throws IOException {

//        String inFName = "resource/A-small-attempt1.in";
         String inFName = "resource/A-large.in";
//        String outFName = "resource/A-small.out";
         String outFName = "resource/A-large.out";

        BufferedReader in = new BufferedReader(new FileReader(inFName));
        PrintWriter out = new PrintWriter(new File(outFName));

        for(int i=0;i<1000;++i) {
            System.out.print("1000000 ");
        }
        int testCases = Integer.parseInt(in.readLine());

        for (int i = 0; i < testCases; ++i) {

//            String line = in.readLine();
//            System.out.println(line);
//            StringBuilder output = new StringBuilder();
//            output.append("Case #" + (i + 1) + ": ");
//
//            String[] n = line.split(" ");
//            int numberOfButtons = Integer.parseInt(n[0]);
//
//            int oPos = 1;
//            int oPrevNeed = 0;
//
//            int bPrevNeed = 0;
//            int bPos = 1;
//
//            int movesNeed = 0;
//
//            for (int k = 1; k <= numberOfButtons * 2; k += 2) {
//
//                int cTeam = n[k].charAt(0);
//                int position = Integer.parseInt(n[k + 1]);
//                int need = 0;
//                int prevNeed = 1;
//                if (cTeam == 'O') {
//                    need = Math.abs(oPos - position);
//                    oPos = position;
//                    prevNeed = bPrevNeed;
//                    if (prevNeed != 0) {
//                        bPrevNeed = 0;
//                    }
//                } else {
//                    need = Math.abs(bPos - position);
//                    bPos = position;
//                    prevNeed = oPrevNeed;
//                    if (prevNeed != 0) {
//                        oPrevNeed = 0;
//                    }
//                }
//                int addMoves = (need - prevNeed > 0) ? need - prevNeed : 0;
//                movesNeed += addMoves;
//
//                if (cTeam == 'O') {
//                    oPrevNeed += addMoves + 1;
//                } else {
//                    bPrevNeed += addMoves + 1;
//                }
//            }
//
//            output.append(String.valueOf(numberOfButtons + movesNeed));
//            System.out.println(output);
//            out.println(output);
        }

        in.close();
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
