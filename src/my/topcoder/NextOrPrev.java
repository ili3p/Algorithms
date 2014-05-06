package my.topcoder;
public class NextOrPrev {

    public int getMinimum2(int nextCost, int prevCost, String start, String goal) {
        return 0;
    }

    public int getMinimum(int nextCost, int prevCost, String start, String goal) {
        if (start.equalsIgnoreCase(goal)) {
            return 0;
        }
        int a = 'a';
        char[] s = start.toCharArray();
        char[] g = goal.toCharArray();
        int c = 0;

        int[] d = new int[26];

        for (int i = 0; i < g.length; i++) {
            int ss = s[i] - a, gg = g[i] - a;
            int dif = Math.abs(ss - gg);
            c += ss - gg < 0 ? dif * nextCost : dif * prevCost;
            int dir = ss - gg < 0 ? 1 : -1;
            int st = dir < 0 ? gg : ss;
            int end = dir < 0 ? ss : gg;
System.out.println(ss);
System.out.println(gg);
System.out.println();
            for (int j = st; j <= end; ++j) {
                if (d[j] != 0 && d[j] != dir) {
                    return -1;
                } else {
                    d[j] = dir;
                }
            }
        }

        return c;
    }

}
