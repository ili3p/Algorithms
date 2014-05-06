package my.codefu.y09.winter;

public class RollingDice {
	public static int getTop(String rolls) {

		int[] a = { 2, 1, 5, 6 };
		int[] b = { 4, 1, 3, 6 };
		char[] charRolls = rolls.toCharArray();

		for (char roll : charRolls) {

			switch (roll) {

			case 'E':
				goEast(a, b);
				break;
			case 'S':
				goSouth(a, b);
				break;
			case 'N':
				goNorth(a, b);
				break;
			case 'W':
				goWest(a, b);
				break;
			}
		}

		return a[3];
	}

	public static void goNorth(int[] a, int[] b) {
		goWest(b, a);
	}

	public static void goSouth(int[] a, int[] b) {
		goEast(b, a);
	}

	public static void goEast(int[] a, int[] b) {

		int temp = a[0];
		a[0] = a[1];
		b[1] = a[1] = a[2];
		a[2] = a[3];
		b[3] = a[3] = temp;
	}

	public static void goWest(int[] a, int[] b) {

		int temp = a[3];
		b[3] = a[3] = a[2];
		a[2] = a[1];
		b[1] = a[1] = a[0];
		a[0] = temp;
	}

	public static void main(String[] args) {
		System.out.println(getTop("NWSE"));
	}
}
