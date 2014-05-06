package my.codejam.y13.qualification;

import java.io.*;
import java.util.*;

public class ProblemA {

    static void runIt() throws IOException {

//        String inFName = "resource/cj13/A-small-attempt0.in";
         String inFName = "resource/cj13/A-large.in";
//        String outFName = "resource/cj13/A-small.out";
         String outFName = "resource/cj13/A-large.out";

        PrintWriter out = new PrintWriter(new File(outFName));
        Scanner sc = new Scanner(new File(inFName));

        String xWon = "X won";
        String oWon = "O won";
        String draw = "Draw";
        String notComplete = "Game has not completed";
        String result = null;
        int testCases = Integer.parseInt(sc.nextLine());

        for (int t = 0; t < testCases; ++t) {
            boolean notDraw = false;
            char[][] board = new char[4][4];
            for (int j = 0; j < 4; ++j) {
                board[j] = sc.nextLine().toCharArray();
            }

            // check horizontal
            for (int i = 0; i < 4; ++i) {
                char last = board[i][0];
                notDraw |= last == '.';
                boolean ok = last != '.';
                for (int j = 1; j < 4 && ok; ++j) {
                    char c = board[i][j];
                    notDraw |= c == '.';
                    if (last == 'T' && c != '.') {
                        last = c;
                    } else if (c != 'T' && last != c) {
                        ok = false;
                    }
                }
                if (ok) {
                    if (last == 'X') {
                        result = xWon;
                    } else if (last == 'O') {
                        result = oWon;
                    } else {
                        System.out.println("ERROR");
                    }
                    break;
                }
            }
            // check vertical
            for (int i = 0; i < 4; ++i) {
                char last = board[0][i];
                notDraw |= last == '.';
                boolean ok = last != '.';
                for (int j = 1; j < 4 && ok; ++j) {
                    char c = board[j][i];
                    notDraw |= c == '.';
                    if (last == 'T' && c != '.') {
                        last = c;
                    } else if (c != 'T' && last != c) {
                        ok = false;
                    }
                }
                if (ok) {
                    if (last == 'X') {
                        result = xWon;
                    } else if (last == 'O') {
                        result = oWon;
                    } else {
                        System.out.println("ERROR");
                    }
                    break;
                }
            }
            // check diagonal
            char last = board[0][0];
            notDraw |= last == '.';
            boolean ok = last != '.';
            for (int j = 1; j < 4 && ok; ++j) {
                char c = board[j][j];
                notDraw |= c == '.';
                if (last == 'T' && c != '.') {
                    last = c;
                } else if (c != 'T' && last != c) {
                    ok = false;
                }
            }
            if (ok) {
                if (last == 'X') {
                    result = xWon;
                } else if (last == 'O') {
                    result = oWon;
                } else {
                    System.out.println("ERROR");
                }
            }

            // check diagonal
            last = board[0][3];
            notDraw |= last == '.';
            ok = last != '.';
            for (int j = 1; j < 4 && ok; ++j) {
                char c = board[j][3 - j];
                notDraw |= c == '.';
                if (last == 'T' && c != '.') {
                    last = c;
                } else if (c != 'T' && last != c) {
                    ok = false;
                }
            }
            if (ok) {
                if (last == 'X') {
                    result = xWon;
                } else if (last == 'O') {
                    result = oWon;
                } else {
                    System.out.println("ERROR");
                }
            }

            if (result == null) {
                if (notDraw) {
                    result = notComplete;
                } else {
                    result = draw;
                }
            }

            StringBuilder output = new StringBuilder();
            output.append("Case #" + (t + 1) + ": ");
            output.append(result);
            System.out.println(output);
            out.println(output.toString().trim());
            result = null;
            sc.nextLine();
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
