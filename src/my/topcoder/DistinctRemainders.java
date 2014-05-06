package my.topcoder;
public class DistinctRemainders {

    public int howMany(long N, int M) {
        long mod = 1000000007;
        if (M == 1 || (M == 2 && N % 2 == 0)) {
            return 1;
        }
        if (M == 2 && N % 2 == 1) {
            long div = (N + 1);
            div %= mod;
            return (int) (div) + 1;
        }
        long c = 0;
        long d = N-M;
        
        if(d%(M*M) == 0){
            
        }
        long da = 980000000000000000L;
        int ds = 50;
        System.out.println(da%ds);
        //50
        return 0;
    }

}
