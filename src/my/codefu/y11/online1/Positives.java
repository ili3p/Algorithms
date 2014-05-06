package my.codefu.y11.online1;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Positives {
    private static final int MINUS = 0;
    private static final int PLUS = 1;
    private Object[][] numMax;
    private Set<Long> c;

    public int getPositiveCount(int[] numbers) {
        System.out.println(numbers.length);
        numMax = new Object[numbers.length][2];
        long max = 0;
        for (int j = 0; j < numMax.length; j++) {
            max += numbers[j];
            numMax[j][0] = numbers[j];
            numMax[j][1] = max;
        }
c = new HashSet<Long>(numbers.length*3000);
        getSub(0, MINUS, 0);
        getSub(0, PLUS, 0);
        return c.size();
    }

    private void getSub(int position, int sign, long scoreSoFar) {
        Integer currentNumber = (Integer) numMax[position][0];
        ++position;
        long newScore = scoreSoFar;
        if (sign == MINUS) {
            newScore = scoreSoFar - currentNumber;
        } else if (sign == PLUS) {
            newScore = scoreSoFar + currentNumber;
        }

        if (position < numMax.length) {
            if ((newScore + (Long) numMax[position][1]) > -1) {
                getSub(position, PLUS, newScore);
                getSub(position, MINUS, newScore);
            }
            
        } else {
            if (newScore > -1) {
                c.add(newScore);
            }
            // System.out.println("New score:" + newScore);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Positives().getPositiveCount(new int[] {9,18,19,13,17,2,10,4,11,6,9,18,19,13,17,2,10,4,11,6,9,18,19,13,17,2,10,4,11,6,9,18,19,13,17,2,10,4,11,6,9,18,19,13,17,2,10,4,11,6}));
    }
}
