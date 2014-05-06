import java.util.*;

public class Cuts {
    public static int getMax(String numbers, int k) {
        int l = numbers.length();
        if (k == 0) {
            return Integer.parseInt(numbers);
        }
        if (l % (k + 1) == 0) {
            int nl = l / (k + 1);
            long[] d = new long[k + 1];
            for (int i = 0; i <= k; ++i) {
                d[i] = Long.parseLong(numbers.substring(i * nl, i * nl + nl));
            }

            Arrays.sort(d);

            return (int) d[d.length - 1];
        } else {
            int nl = l / (k + 1) + 1;
            int left = l % (k + 1);
            if (left == 1) {
                int min = Integer.MAX_VALUE;

                for (int i = 0; i <= k; ++i) {

                    String num = numbers.substring(i * (nl - 1), i * (nl - 1)
                            + nl);
                    min = Math.min(min, Integer.parseInt(num));
                }
                return min;
            } else {

                int min = Integer.MAX_VALUE;
                for (int i = 0; k - i - 1 > -1; ++i) {

                    String num = numbers.substring(i * (nl - 1), i * (nl - 1)
                            + nl);
                    min = Math.min(min, Math.max(
                            Integer.parseInt(num),
                            getMax(numbers.substring(i * (nl - 1) + nl), k - i
                                    - 1)));
                }
                return min;
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(getMax("1234567899", 3) + "= 123");
        System.out.println(getMax("123456789", 2) + "= 789");
        System.out.println(getMax("13113314553176", 3) + "= 3176");
        ;
        System.out.println(getMax("135672242617", 1) + "= 242617");
        System.out
                .println(getMax(
                        "68883985971589478494434300509919666397564218333837575157371807879413155054259037137655358",
                        40)
                        + "= 183");
    }
}
