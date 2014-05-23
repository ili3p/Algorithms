package interview.google;

import java.util.Arrays;

public class Coins {
    public int find(int[] coins, int sum) {
        int[] sums = new int[sum + 1];
        Arrays.fill(sums, Integer.MAX_VALUE);
        sums[0] = 0;

        for (int i = 1; i < sums.length; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                int coin = coins[j];
                if (coin <= i) {
                    sums[i] = Math.min(sums[i], sums[i - coin] + 1);
                }
            }
        }
        return sums[sum];
    }
    
    public static void main(String[] args) {
        System.out.println(new Coins().find(new int[] {1,5,10},13));
    }
}
