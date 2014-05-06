package my.topcoder;
import java.util.*;

public class TeamContestEasy {

    public int worstRank(int[]strength){
//        int n = strength.length/3;
//        int mine =  st(strength[0],strength[1],strength[2]);
//        strength[0] = strength[1] = strength[2] = 0;
//        
//        int[] rest = new int[strength.length-3];
//        for(int i=0; i<rest.length;++i){
//            rest[i] = strength[i+3];
//        }
//        
//        Arrays.sort(rest);
//        int avg = mine/2;
//        int res = 0,worse=0;
//        int[] teams = new int[n-1];
//        boolean[] done = new boolean[n-1];
//        int started =0;
//        for(int i=rest.length-1;i>=0;i--){
//            if(rest[i] > avg && started<n-1){
//                teams[started++] = rest[i];
//            }else{
//                boolean used = false;
//                for(int j=started-1;j>=0;j--){
//                    if((rest[i]+teams[j])>mine && !done[j]){
//                        done[j] = true;
//                        res++;
//                        used=true;
//                        break;
//                    }
//                }
//                if(!used) worse++;
//            }
//        }
//        int not_done = started-res;
//        return res +(not_done/2)+1;
////        int n = strength.length;
////        for(int i=3;i<n-1;++i)
////            for(int j=i+1;j<n;++j){
////                if(strength[i]>strength[j]){
////                    int buf = strength[i];
////                    strength[i] = strength[j];
////                    strength[j] = buf;
////                }
////            }
////        int m = n/3;
////        int i= 2+m;
////        int j = n-1;
////        int res = 1;
////        while(i<j){
////            while((strength[i] + strength[j] <= min) && (i<j))++i;
////            if(i<j)res++;
////            i++;j--;
////        }
////        int s =  st(strength[0],strength[1],strength[2]);
////        int[] str = new int[strength.length-3];
////        System.arraycopy(strength, 3, str, 0, strength.length-3);
////        Arrays.sort(str);
////        int ret = 1;
////        for(int x=0;x<str.length/3;++x){
////            int n = 0;
////            for(int i=0; i<str.length;++i){
////                if(str[str.length-i-1] != -1){
////                    n = str[str.length-i-1];
////                    str[str.length-i-1] =-1;
////                    break;
////                }
////            }
////            boolean fo = false;
////            for(int i=0; i<str.length;++i){
////                if(str[i] != -1 && n+str[i]>s){
////                    ret++;
////                    str[i] = -1;
////                    fo= true;
////                    break;
////                }
////            }
////            if(!fo)break;
////        }
//        int cou
//        int mySc = st(s[0], s[1], s[2]);
//        int[] others = new int[s.length-3];
//        for (int i=3;i<s.length;++i){
//            others[i-3] = s[i];
//        }
//        Arrays.sort(others);
//        for(int i=0;i<others.length/3;++i){
//            others[i] = 0;
//        }
//        
//        for(int i=0; i<others.length;++i){
//            int max = others[others.length-1];
//            for(int j=0;j<others.length-1;j++){
//                if(max+others[j]>mySc){
//                    ++count;
//                    others[others.length-1] = 0;
//                    others[j] = 0;
//                    Arrays.sort(others);
//                    break;
//                }
//            }
//        }
        return 0;
    }
    
    public int worstRank2(int[] s) {
        int N = s.length;
        if (N == 3) {
            return 1;
        }
        long ourSt = st(s[0], s[1], s[2]);
        int rank = 0;

        int[] subset = new int[] { 0, 1, 2 };
        List<int[]> list = new ArrayList<int[]>(3000);

        while (subset != null) {
            long tSt = st(s[3 + subset[0]], s[3 + subset[1]], s[3 + subset[2]]);
            if (tSt > ourSt) {
                list.add(subset);
            }
//            System.out.println(Arrays.toString(subset));
            subset = nextSubset(N - 3 -1, subset);
        }

        for (int[] sss : list) {
            boolean[] taken = new boolean[N];
            taken[sss[0]] = true;
            taken[sss[1]] = true;
            taken[sss[2]] = true;
            int r = 1;
            for (int[] ss : list) {
                if (!taken[ss[0]] && !taken[ss[1]] && !taken[ss[2]]) {
                    taken[ss[0]] = true;
                    taken[ss[1]] = true;
                    taken[ss[2]] = true;
                    ++r;
//                    if(r== 4){
//                        System.out.println("stop");
//                    }
                }
            }
            rank = Math.max(rank, r);
        }

        return 1+rank;
    }

    private int st(int i, int j, int k) {
        return i + j + k - Math.min(i, Math.min(j, k));
    }

    private static int[] nextSubset(int n, int[] subset) {
        int l = subset.length;
        int[] result = copyArray(subset);
        boolean newSubset = false;

        for (int k = l - 1; k > -1; --k) {
            int d = l - 1 - k;
            int a = subset[k];
            if (a + 1 <= (n - d)) {
                int j = 1;
                for (int i = k; i < l; ++i) {
                    result[i] = a + j;
                    ++j;
                    newSubset = true;
                }
                break;
            }
        }
        return newSubset ? result : null;
    }

    private static int[] copyArray(int[] subset) {
        int[] result = new int[subset.length];
        for (int i = 0; i < subset.length; ++i) {
            result[i] = subset[i];
        }
        return result;
    }

}
