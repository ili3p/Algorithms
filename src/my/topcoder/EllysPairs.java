package my.topcoder;
import java.util.*;

public class EllysPairs {

    public  int getDifference(int[] knowledge) {
        Arrays.sort(knowledge);
        int kl = knowledge.length;
        int[] g = new int[kl/2];
        for(int k=0; k<kl/2;++k){
            g[k] = knowledge[k]+knowledge[kl-k-1];
        }
        
        Arrays.sort(g);
        return g[kl/2-1]-g[0];
    }

    public static void main(String[] args) {
        int a[] = { 914, 383, 342, 797, 7, 157, 211, 384, 839, 730, 940, 151,
                6, 861, 186, 93, 862, 524, 992, 764, 764, 125, 440, 459, 890,
                515, 640, 484, 103, 538, 665, 177, 209, 547, 244, 949, 669,
                175, 444, 855, 262, 416, 339, 845, 491, 956, 644, 161, 524, 572 };

        EllysPairs ep = new EllysPairs()
        ;
        long t = System.nanoTime();
        System.out.println(ep.getDifference(a));
        System.out.println((System.nanoTime() - t) / 1e6 + "ms");
        t = System.nanoTime();
        System.out.println(ep.getDifference(a));
        System.out.println((System.nanoTime() - t) / 1e6 + "ms");
    }

}
