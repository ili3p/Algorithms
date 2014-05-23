package interview.google;

public class LNDS {
    //Given a sequence of N numbers - A[1] , A[2] , ..., A[N] . Find the length of the longest non-decreasing sequence.
    public int solve(int[] n) {
        int[] dp = new int[n.length];
        int current = 1;
        dp[0] = 1;
        for (int i = 1; i < n.length; ++i) {
            if (n[i] >= n[i - 1]) {
                current += 1;
            } else {
                current = 1;
            }
            dp[i] = Math.max(dp[i - 1], current);
        }

        return dp[n.length - 1];

    }

    public static void main(String[] args) {
        int[] n = new int[] { 3, 4, 5, 5, 6, //5
                3, 2, 3, 4, 3, 3, 4, 5, 6, 7, 8, //7
                2, 1, 3, 4 };
        System.out.println(new LNDS().solve(n));
        System.out.println(new LNDS().solve(new int[] {5, 3, 4, 8, 6, 7}));
    }
}
