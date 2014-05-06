package my.codefu.y11.online1;

import java.text.DecimalFormat;

public class Photographer {
    public static String getResolution(String[] pics) {
        double max = 0;
        for (String string : pics) {
            String[] t = string.split("x");
            int s = Integer.parseInt(t[0]) * Integer.parseInt(t[1]);
            if (max < s) {
                max = s;
            }
        }
        max = max / 1E6;

        DecimalFormat df = new DecimalFormat(".#");
        String s = df.format(max);

        return (s.equalsIgnoreCase(".0")) ? "0.0" : s;
    }
}