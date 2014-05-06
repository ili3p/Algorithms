package my.codefu.y11.comminity;

public class BinaryGame {
    public static int getMaxProduct(String binaryNumber) {
        int max = 0;

        for (int i = 1; i < binaryNumber.length() - 1; ++i) {
            for (int j = i + 1; j < binaryNumber.length(); ++j) {
                String num1 = binaryNumber.substring(0, i);
                String num2 = binaryNumber.substring(i, j);
                String num3 = binaryNumber.substring(j);
                int cur = Integer.parseInt(num1, 2) * Integer.parseInt(num2, 2) * Integer.parseInt(num3, 2);
                if(cur > max) {max =cur;}
            }
        }

        return max;
    }

}