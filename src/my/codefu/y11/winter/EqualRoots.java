package my.codefu.y11.winter;

public class EqualRoots {

	public static int getTurnSum(int start, int end) {

		int bigSum = 0;
		boolean f = true;
		for (int index = start; index <= end; ++index) {
			int temp = index;
			char[] digs = String.valueOf(index).toCharArray();
			int sum = 0;
			int step = 0;
			f = false;
			while (temp != 1) {
				++step;
				sum = 0;
				temp = (int) Math.sqrt(temp);
				for (char c : digs) {
					sum += (c - 48);
				}
				digs = String.valueOf(sum).toCharArray();
				if (sum == temp) {
					f = true;
					break;
				}
			}
			if (f) {
				bigSum += step;
			}
		}

		return bigSum;
	}

	public static void main(String[] args) {
		// for (int i = 0; i < 10; ++i) {
		// char s = String.valueOf(i).toCharArray()[0];
		// int m = s - 48;
		// System.out.println(m);
		// }
		System.out.println(getTurnSum(42, 48));
		System.out.println(getTurnSum(1,100000));
		// System.out.println((int) Math.sqrt(2));
	}
}
