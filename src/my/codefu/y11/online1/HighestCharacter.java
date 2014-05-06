package my.codefu.y11.online1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HighestCharacter {
    public static String highest(String[] strings) {

        char[][] ch = new char[50][20];
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            char[] t = string.toCharArray();
            Arrays.sort(t);
            ch[i] = t;
        }

        int larg = 0;
        int str = 0;
        for (int i = 0; i < strings.length; i++) {
            char[] cs = ch[i];
            int of = 1;
            char t = cs[cs.length - of];
            if (t > larg) {
                larg = t;
                str = i;
            }
        }
        List<Integer> toBe = new ArrayList<Integer>(50);
        for (int i = 0; i < strings.length; i++) {
            char[] cs = ch[i];
            int of = 1;
           
            char t = cs[cs.length - of];
            if (t == larg) {
                toBe.add(i);
            }
        }
        int of = 1;

        while (toBe.size() > 1) {
            ++of;
            larg = 0;

            for (Integer i : toBe) {
                char[] cs = ch[i];
                if (cs.length - of < 0) {
                    continue;
                }
                char t = cs[cs.length - of];
                if (t > larg) {
                    larg = t;
                    str = i;
                }
            }
            List<Integer> ten = new ArrayList<Integer>();
            for (Integer i : toBe) {
                char[] cs = ch[i];
                if (cs.length - of < 0) {
                    continue;
                }
                char t = cs[cs.length - of];
                if (t == larg) {
                    ten.add(i);
                }
            }
            if(ten.size()==0) {
                List<String> winners= new ArrayList<String>();
                for (Integer integer : toBe) {
                    winners.add(strings[integer]);
                }
                Collections.sort(winners);
                return winners.get(0);
            }
            
            toBe.clear();
            toBe.addAll(ten);
        }
        return strings[str];
    }

    public static void main(String[] args) {
        System.out.println(highest(new String[] { "ba", "ab" }));
    }
}
