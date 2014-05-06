package my.codejam.y11.qualification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ProblemB {

    static void runIt() throws IOException {

//        String inFName = "resource/B-small-attempt1.in";
         String inFName = "resource/B-large.in";
//        String outFName = "resource/B-small.out";
         String outFName = "resource/B-large.out";

        BufferedReader in = new BufferedReader(new FileReader(inFName));
        PrintWriter out = new PrintWriter(new File(outFName));

        int testCases = Integer.parseInt(in.readLine());
        final String baseElements = "QWERASDF";

        for (int i = 0; i < testCases; ++i) {

            String line = in.readLine();
            System.out.println(line);
            StringBuilder output = new StringBuilder();
            output.append("Case #" + (i + 1) + ": ");

            String[] t = line.split("\\d+");
            String combine = t[1].trim();
            String opposed = t[2].trim();
            char[] invoke = t[3].trim().toCharArray();
            
            Stack<Character> elementList = new Stack<Character>();

            for (int j = 0; j < invoke.length; j++) {
                char element = invoke[j];
                if (elementList.isEmpty()) {
                    elementList.push(element);
                    continue;
                }
                char prevElement = elementList.peek();
                int index = -1;
                if (baseElements.indexOf(prevElement) != -1) {
                    index = combine.indexOf(element + "" + prevElement);
                    if (index == -1) {
                        index = combine.indexOf(prevElement + "" + element);
                    }
                }
                if (index != -1) {
                    char combinedElement = combine.charAt(index + 2);
                    elementList.pop();
                    elementList.push(combinedElement);
                } else {
                    index = opposed.indexOf(element);
                    while (index != -1) {
                        char opposedElement =
                            (index + 1 < opposed.length() && opposed.charAt(index + 1) != ' ') ? opposed.charAt(index + 1) : opposed
                                .charAt(index - 1);
                        if (elementList.contains(opposedElement)) {
                            elementList.clear();
                            break;
                        }
                        index = opposed.indexOf(element, index+1);
                    }
                    if (index == -1) {
                        elementList.push(element);
                    }
                }
            }
            output.append(elementList.toString());
            System.out.println(output);
            out.println(output);
        }

        in.close();
        out.flush();
        out.close();
    }

    public static void main(String[] args) {

        try {
            ProblemB.runIt();
        } catch (IOException e) {

            System.out.println(e.getMessage());
            e.printStackTrace();

        } catch (Exception e) {

            System.out.println(e.getMessage());
            e.printStackTrace();

        }
    }
}
