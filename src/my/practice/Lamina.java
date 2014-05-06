package my.practice;

public class Lamina {

	public static int combinations(int tiles) {
		int count = 0;

		for (int y = 1; (4 * y * (1 + y)) <= tiles; ++y) {
			for (int x = 1; (4 * y * (x + y)) <= tiles; ++x) {
				++count;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		System.out.println(combinations(1));
		System.out.println(combinations(3));
		System.out.println(combinations(8));
		System.out.println(combinations(32));
		System.out.println(combinations(10));
		System.out.println(combinations(100));
		System.out.println(combinations(31));
		System.out.println(combinations(33));
		System.out.println(combinations(34));
		System.out.println(combinations(10000000));
	}
}