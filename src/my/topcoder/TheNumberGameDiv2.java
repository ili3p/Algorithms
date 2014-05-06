package my.topcoder;
import java.util.*;

public class TheNumberGameDiv2 {

    private class Move implements Comparable<Move> {
        int m;
        StringBuilder number;

        public Move(StringBuilder reverse, int i) {
            number = new StringBuilder(reverse);
            m = i;
        }

        @Override
        public boolean equals(Object obj) {
            Move mm = (Move) obj;
            return number.equals(mm.number);
        }

        public int compareTo(Move o) {
            return m - o.m;
        }

        @Override
        public String toString() {
            return "N: " + number + " M: " + m;
        }
    }

    public int minimumMoves(int A, int B) {
        Queue<String> stack = new LinkedList<String>();

        StringBuilder a = new StringBuilder(String.valueOf(A));
        String b = String.valueOf(B);
        stack.add(a + ":0");
        stack.add(a.reverse() + ":1");
        while (!stack.isEmpty()) {
            String[] test = stack.poll().split(":");
            int m = Integer.parseInt(test[1]);
            if (test[0].equalsIgnoreCase(b)) {
                return m;
            } else {

                StringBuilder t = new StringBuilder(test[0].substring(0,
                        test[0].length() - 1));
                if (t.length() > 0) {
                    stack.add(t + ":" + (m + 1));
                    if (t.length() > 1) {
                        stack.add(t.reverse() + ":" + (m + 2));
                    }
                }
            }

        }

        return -1;
    }

    public int minimumMoves2(int A, int B) {
        Queue<Move> stack = new PriorityQueue<Move>();
        String b = String.valueOf(B);
        StringBuilder a = new StringBuilder(String.valueOf(A));
        stack.add(new Move(a, 0));
        stack.add(new Move(a.reverse(), 1));

        while (!stack.isEmpty()) {
            Move move = stack.poll();
            if (move.number.toString().equalsIgnoreCase(b)) {
                return move.m;
            } else {
                if (move.number.length() > 1) {
                    move.number.deleteCharAt(move.number.length() - 1);
                    stack.add(new Move(move.number, move.m + 1));
                    if (move.number.length() > 1) {
                        stack.add(new Move(move.number.reverse(), (move.m + 2)));
                    }
                }
            }

        }

        return -1;
    }
}
