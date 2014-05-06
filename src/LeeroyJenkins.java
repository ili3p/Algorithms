import java.util.*;

public class LeeroyJenkins {
    static int mod = 1000007;

    public static int solve(int Start, int N, int M) {

        long[] coins = new long[N];
        coins[0] = Start;
        for (int i = 1; i < N; ++i) {
            long s = (coins[i - 1] * 1103515245L) + 12345;
            long d = s / 65536L;
            coins[i] = d % M;
            if (i > 3 && coins[i] == coins[i - 2]) {
                System.out.println("same " + i);
                break;
            }
        }

        long count = 0;
        Map<Long,Integer[]> map = new HashMap<Long,Integer[]>();
        
        for (int i = 0; i < N; ++i) {
            long num = coins[i];
            int c = 0;
            for (int j = i + 1; j < N; ++j) {
                if (num < coins[j]) {
                    ++c;
                }
            }
            count += (num * c % mod);
            count %= mod;
        }

        return (int) count;
    }

    public static void main(String[] args) {

        System.out.println(solve(7354, 6787, 90482));
    }
}
