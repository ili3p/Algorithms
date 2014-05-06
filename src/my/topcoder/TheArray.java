package my.topcoder;
public class TheArray {
    public int find(int n, int d, int f, int l) {
        double N = n, D = d, F = f, L = l;
        if (d == 0) {
            return f;

        }
        if (n == 2)
            return Math.max(f, l);
        if (N - 1 - (F - L) / D < 1)
            return f;
        if (N - 1 - (L - F) / D < 1)
            return l;
        F = Math.min(l, f);
        L = Math.max(l, f);
        int rem = n - 1 - (int) ((L - F) / D);
        rem /= 2;
        return Math.min(rem * d + (int) L, (n - 1 - rem) * d + (int) F);
    }

    public int find2(int n, int d, int first, int last) {
        int res = 0;
        if (n == 2) {
            res = Math.max(first, last);
        } else if (d == 0) {
            res = Math.max(first, last);
        } else if (first == last) {
            res = (n - 1) / 2 * d + first;
        } else if (first > last) {
            if (first == ((n - 1) * d + last)) {
                res = first;
            } else {
                for (int i = 1; i < n - 1; ++i) {
                    int t = i * d + last;
                    int e = t - (n - 1 - i) * d;
                    if (first > e) {
                        res = t;
                    } else {
                        int k = e - first;
                        if (d - k > 0) {
                            res += d - k;
                        }
                        break;
                    }
                }
            }
            res = Math.max(res, first);
        } else if (first < last) {
            if (last == ((n - 1) * d + first)) {
                res = last;
            } else {
                for (int i = 1; i < n - 1; ++i) {
                    int t = i * d + first;
                    int e = t - (n - 1 - i) * d;
                    if (last > e) {
                        res = t;
                    } else {
                        int k = e - last;
                        if (d - k > 0) {
                            res += d - k;
                        }
                        break;
                    }
                }

            }
            res = Math.max(res, last);
        }
        return res;
    }

}
