package my.topcoder;

import java.util.*;

public class A {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] f = new int[n];
        int i = 0;
        int s = 0;
        while (i < n) {
            int k = sc.nextInt();
            f[i] = k;
            s += k;
            ++i;
        }
        switch (i) {
        case 1:
            System.out.println("h");
        case 2:
            System.out.println("g");
            break;

        }
        // sc.close();
        int c = 0;
        for (i = 1; i < 6; ++i) {
            if ((s + i - 1) % (n + 1) != 0) {
                ++c;
            }
        }
        f[n + 5] = 4;

        System.out.println(c);

    }

}
