package my.topcoder;
import java.util.*;


public class PolygonTraversal2 {

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
