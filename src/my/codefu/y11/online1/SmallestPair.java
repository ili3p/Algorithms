package my.codefu.y11.online1;

public class SmallestPair {

    public int smallest(int[] numbers) {
        int prev = numbers[0];
        int sum, minsum = 10001;
        for (int i = 1; i < numbers.length; i++) {
            int num = numbers[i];
            sum = num + prev;
            if (sum < minsum) {
                minsum = sum;
            }
            prev = num;
        }
        return minsum;
    }
}
