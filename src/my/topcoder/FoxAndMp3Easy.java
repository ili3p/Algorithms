package my.topcoder;
import java.util.*;

import org.junit.*;

public class FoxAndMp3Easy {

    public String[] playList(int n) {
        int size = n;
        if (size > 50) {
            size = 50;
        }

        int current = 0;
        String[] result = new String[size];
        for (int i = 1; i <= 9 && current < size && i <= n; ++i) {
            result[current] = i + ".mp3";
            current++;
            if (n > 10)
                for (int j = i * 10; j < ((i + 1) * 10) && current < size
                        && j <= n; j++) {
                    if (j <= n) {
                        result[current] = j + ".mp3";
                        current++;
                    }

                    if (n > 100)
                        for (int k = j * 10; k < ((k + 1) * 10)
                                && current < size && k <= n; k++) {
                            if (k <= n) {
                                result[current] = k + ".mp3";
                                current++;
                            }
                        }

                }
            if (current > size) {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        FoxAndMp3Easy m = new FoxAndMp3Easy();
        for (int i = 1000; i > 0; --i) {
            System.out.println(i);
            Assert.assertArrayEquals(m.playList(i), m.playList2(i));
        }
    }

    public String[] playList2(int n) {
        String[] ar = new String[n];
        for (int i = 1; i <= n; ++i) {
            ar[i - 1] = i + ".mp3";
        }
        Arrays.sort(ar);
        String[] a = new String[Math.min(50, n)];
        for (int i = 0; i < a.length; ++i) {
            a[i] = ar[i];
        }

        return a;
    }
}
