package my.topcoder;
import java.util.*;

public class CityMap {

    public String getLegend(String[] cityMap, int[] POIs) {

        int[] counts = new int[30];
        for (String string : cityMap) {
            char[] map = string.toCharArray();
            for (int i = 0; i < map.length; i++) {
                if (map[i] != '.') {
                    int c = map[i] - 'A';
                    ++counts[c];
                }
            }
        }
        char[] po = new char[2501];
        for (int i = 0; i < counts.length; i++) {
            int j = counts[i];
            if (j != 0) {
                po[counts[i]] =  (char)(i + 'A');
            }
        }

        StringBuilder sb = new StringBuilder(POIs.length);

        for (int i = 0; i < POIs.length; i++) {
            sb.append(""+po[POIs[i]]);

        }

        return sb.toString();
    }

}
