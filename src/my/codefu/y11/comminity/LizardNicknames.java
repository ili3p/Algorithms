package my.codefu.y11.comminity;
//Shortest in java
public class LizardNicknames {
    public String getBestName(String[] n) {
        java.util.Arrays.sort(n);
        for (String x : n) 
            if (x.length() > n[0].length())
                n[0] = x;
        
        return n[0];
    }
}
