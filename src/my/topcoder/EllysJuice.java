package my.topcoder;
import java.util.*;

public class EllysJuice {

	public String[] getWinners(String[] players) {
	    int n = players.length;
        if (n == 1) {
            return players;
        }
        List<String> list = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();

        int[] c = new int[n];
        for (String string : players) {
            Integer val = map.get(string) == null ? 0 : map.get(string);
            ++val;
            map.put(string, val);
        }

        for (String s : map.keySet()) {
            if (map.get(s) > 1) {
                list.add(s);
            }
        }
        String[] res = list.toArray(new String[list.size()]);
        Arrays.sort(res);
        return res;
	}

}
