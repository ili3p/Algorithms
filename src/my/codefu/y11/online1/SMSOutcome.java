package my.codefu.y11.online1;

public class SMSOutcome {

    public String getSequence(String sentence) {
        StringBuilder sb = new StringBuilder(sentence.length() * 3);
        for (char c : sentence.toCharArray()) {
            String b = "";
            if (c == 'a')
                b = "2";
            if (c == 'b')
                b = "22";
            if (c == 'c')
                b = "222";
            if (c == 'd')
                b = "3";
            if (c == 'e')
                b = "33";
            if (c == 'f')
                b = "333";
            if (c == 'g')
                b = "4";
            if (c == 'h')
                b = "44";
            if (c == 'i')
                b = "444";
            if (c == 'j')
                b = "5";
            if (c == 'k')
                b = "55";
            if (c == 'l')
                b = "555";
            if (c == 'm')
                b = "6";
            if (c == 'n')
                b = "66";
            if (c == 'o')
                b = "666";
            if (c == 'p')
                b = "7";
            if (c == 'q')
                b = "77";
            if (c == 'r')
                b = "777";
            if (c == 's')
                b = "7777";
            if (c == 't')
                b = "8";
            if (c == 'u')
                b = "88";
            if (c == 'v')
                b = "888";
            if (c == 'w')
                b = "9";
            if (c == 'x')
                b = "99";
            if (c == 'y')
                b = "999";
            if (c == 'z')
                b = "9999";
            if (c == ' ')
                b = "0";
            sb.append(b);
        }
        return new String(sb);
    }
}
