package my.codeforces;

import java.util.*;

public class AA {

    public static int binarySearch(int[] array, int element) {
        Arrays.sort(array);

        int low = 0;
        int high = array.length - 1;
        int k = -20;
        k = k >>> 2;
        while (low <= high) {

            int mid = (low + high) >>> 1;
            int midVal = array[mid];
            System.out.print(midVal + " ");
            if (midVal < element) {
                low = mid + 1;
            } else if (midVal > element) {
                high = mid - 1;
            } else {
                return mid;
            }
        }

        return -(low + 1);
    }

    public static void main(String[] args) {
        // int[] array = new int[] { 1, 7, 9, 11, 24, 35, 49, 58, 63, 79, 87 };
        // int element = 49;
        int[] array = new int[] { 14, 15, 19, 22, 24, 33, 39, 44, 62, 66, 71,
                76, 77, 88, 93 };
        int element = 17;
        binarySearch(array, element);
        // System.out.println(Arrays.binarySearch(array, element));
        // System.out.println(binarySearch(array, element));

        // Scanner sc = new Scanner(System.in);
        //
        // char[][] map = new char[4][4];
        //
        // for (int i = 0; i < map.length; ++i) {
        // map[i] = sc.nextLine().toCharArray();
        // }
        // sc.close();
        // boolean hasSquare = false;
        //
        // for (int ii = 0; ii < map.length - 1 && !hasSquare; ++ii) {
        // for (int jj = 0; jj < map.length - 1 && !hasSquare; ++jj) {
        // hasSquare = (map[ii][jj] == map[ii + 1][jj + 1])
        // && (map[ii][jj] == map[ii][jj + 1])
        // && (map[ii][jj] == map[ii + 1][jj]);
        // if (hasSquare) {
        // System.out.println("YES");
        //
        // }
        // }
        // }
        // if (!hasSquare) {
        // for (int i = 0; i < map.length && !hasSquare; ++i) {
        // for (int j = 0; j < map.length && !hasSquare; ++j) {
        //
        // map[i][j] = (map[i][j] == '.') ? '#' : '.';
        //
        // for (int ii = 0; ii < map.length - 1 && !hasSquare; ++ii) {
        // for (int jj = 0; jj < map.length - 1 && !hasSquare; ++jj) {
        // hasSquare = (map[ii][jj] == map[ii + 1][jj + 1])
        // && (map[ii][jj] == map[ii][jj + 1])
        // && (map[ii][jj] == map[ii + 1][jj]);
        // if (hasSquare) {
        // System.out.println("YES");
        // }
        // }
        // }
        // map[i][j] = (map[i][j] == '.') ? '#' : '.';
        //
        // }
        // }
        // }
        // if (!hasSquare) {
        // System.out.println("NO");
        // }

    }
}
