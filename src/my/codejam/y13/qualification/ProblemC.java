package my.codejam.y13.qualification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.*;
import java.util.*;

public class ProblemC {

    static void runIt() throws IOException {

        // String inFName = "resource/cj13/C-small-attempt0.in";
        // String inFName = "resource/cj13/C-large-1.in";
        String inFName = "resource/cj13/C-large2.in";
        // String outFName = "resource/cj13/C-small.out";
        String outFName = "resource/cj13/C-large-1.out";

        BufferedReader in = new BufferedReader(new FileReader(inFName));
        PrintWriter out = new PrintWriter(new File(outFName));

        int testCases = Integer.parseInt(in.readLine());

        BigInteger[][] tests = new BigInteger[testCases][2];
        BigInteger max = new BigInteger("0");
        for (int t = 0; t < testCases; ++t) {

            String[] line = in.readLine().split(" ");

            BigInteger A = new BigInteger(line[0]);
            BigInteger B = new BigInteger(line[1]);

            tests[t][0] = A;
            tests[t][1] = B;
            max = max.max(B);
        }

        List<Long> nums = new ArrayList<Long>(39);
        List<String> ses = new ArrayList<String>();
        List<String> kes = new ArrayList<String>();

        long num = 1;
        long[] count = new long[testCases];
        long t = System.nanoTime();
        while (true) {
            // if (num % 100000 == 0) {
            // System.out.println(num);
            // }
            String p = Long.toString(num, 3);
            
            // System.out.println(p.length());
            // System.out.println("0s: " + count(ppp, '0'));
            // System.out.println("1s: " + count(ppp, '1'));
//            if (num < 1594324 && count(p.toCharArray(), '2') > 1) {
//                continue;
//            }
            StringBuilder sb = new StringBuilder(p).reverse();
            BigInteger s = new BigInteger(p.toString() + sb);
            BigInteger s1 = new BigInteger(p + sb.substring(1));
            BigInteger k = s.multiply(s);
            BigInteger k1 = s1.multiply(s1);

            for (int i = 0; i < tests.length; ++i) {

                if (k.compareTo(tests[i][0]) >= 0) {
                    if (k.compareTo(tests[i][1]) <= 0) {
                        if (isPalin(k.toString().toCharArray())) {
                             out.print(num + " ");
                             out.print(p + " ");
                            // out.print(p.length()+" ");
                            // out.print("0s: " + count(ppp, '0')+" ");
                            // out.print("1s: " + count(ppp, '1')+" ");
                            // out.print("2s: " + count(ppp, '2')+" ");
                             out.print(s + "\t -> ");
                             out.println(k);
                            ++count[i];
                        }
                    }
                }

                if (k1.compareTo(tests[i][0]) >= 0) {
                    if (k1.compareTo(tests[i][1]) <= 0) {
                        if (isPalin(k1.toString().toCharArray())) {
                             out.print(num + " ");
                             out.print(p + " ");
                            // out.print(p.length()+" ");
                            // out.print("0s: " + count(ppp, '0')+" ");
                            // out.print("1s: " + count(ppp, '1')+" ");
                            // out.print("2s: " + count(ppp, '2')+" ");
                             out.print(s1 + "\t -> ");
                             out.println(k1);
                            ++count[i];
                        }
                    }
                }
            }

            if (k1.compareTo(max) > 0) {
                break;
            }

            ++num;
        }
        System.out.println(num);
        System.out.println((System.nanoTime() - t) / 1e6 + " ms");

        BigInteger k = new BigInteger("9");

        for (int i = 0; i < tests.length; ++i) {
            if (k.compareTo(tests[i][0]) >= 0) {
                if (k.compareTo(tests[i][1]) <= 0) {
                    ++count[i];
                }
            }
        }

        for (int i = 0; i < count.length; ++i) {
            StringBuilder output = new StringBuilder();
            output.append("Case #" + (i + 1) + ": ");
            output.append(count[i]);
            System.out.println(output);
            out.println(output);
            // System.out.println((System.nanoTime() - time) / 1e6 + " ms");
        }
        in.close();
        out.flush();
        out.close();

        // Collections.sort(ses);
        // Collections.sort(kes);
        // Collections.sort(nums);
        // System.out.println("ses: ");
        // for (String string : ses) {
        // System.out.println(string);
        // }
        //
        // System.out.println("kes: ");
        // for (String string : kes) {
        // System.out.println(string);
        // }
        //
        // System.out.println("nums: ");
        // for (Long string : nums) {
        // System.out.println(string);
        // }

    }

    private static int count(char[] ppp, char c) {
        int cr = 0;
        for (int i = 0; i < ppp.length; i++) {
            char sc = ppp[i];
            if (sc == c) {
                ++cr;
            }
        }
        return cr;
    }

    public static void check() {
        long count = 0;
        long A = 1, B = 100000000000000000L;
        long number = (long) Math.floor(Math.sqrt(A));
        long d = number * number;
        for (; d <= B; ++number) {
            d = number * number;
            if (d >= A && d <= B) {
                boolean isPalin = isPalin(number) && isPalin(d);
                if (isPalin) {
                    ++count;
                }
            }
        }

        System.out.println(count);
    }

    /**
     * }
     * }
     * }
     * @param number
     * @return
     */

    private static boolean isPalin(long number) {
        return isPalin(String.valueOf(number).toCharArray());
    }

    private static boolean isPalin(char[] num) {

        int l = num.length;
        if (l == 1) {
            return true;
        }
        for (int i = 0; i < l; ++i) {
            if (num[i] != num[l - 1 - i]) {
                return false;
            } else if (i > l - 1 - i) {
                return true;
            }
        }
        return false;
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
