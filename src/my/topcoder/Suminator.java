package my.topcoder;
import java.util.*;

public class Suminator {

    public int findMissing(int[] program, int wantedResult) {
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < program.length; ++i) {
            if (program[i] == 0) {
                if (stack.isEmpty()) {
                    stack.push(0);
                } else {
                    int k = stack.pop();
                    if (stack.isEmpty()) {
                        stack.push(k);
                    } else {
                        int g = stack.pop();
                        stack.push(k + g);
                    }
                }
            } else {
                stack.push(program[i]);
            }
        }
        
        int e = stack.pop();
        return wantedResult-e-1;
    }

}
