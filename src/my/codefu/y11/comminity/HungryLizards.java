package my.codefu.y11.comminity;

public class HungryLizards {
    public static int getTotalValue(String[] days) {
        int[][] g = new int[days.length][3];
        String[] f = days[0].split(" ");
        for (int i = 0; i < f.length; ++i) {
            g[0][i] = Integer.parseInt(f[i]);
        }
        for (int l = 1; l < days.length; ++l) {
            String d[] = days[l].split(" ");
            for (int i = 0; i < d.length; ++i) {
                g[l][i] = Integer.parseInt(d[i]);
            }    
            g[l][0] = (g[l - 1][1] > g[l - 1][2]) ? g[l - 1][1] + g[l][0] : g[l - 1][2] + g[l][0];
            g[l][1] = (g[l - 1][0] > g[l - 1][2]) ? g[l - 1][0] + g[l][1] : g[l - 1][2] + g[l][1];
            g[l][2] = (g[l - 1][1] > g[l - 1][0]) ? g[l - 1][1] + g[l][2] : g[l - 1][0] + g[l][2];
        }
        int max=0;
        for(int i=0;i<g[days.length-1].length;++i ) {
            max = (g[days.length-1][i]>max)?g[days.length-1][i]:max;
        }
        return max;
    }
}
