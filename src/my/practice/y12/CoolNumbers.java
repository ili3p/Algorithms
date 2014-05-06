package my.practice.y12;
public class CoolNumbers {
	public int countCoolNumbers(String superCoolNumber) {

		char c[] = superCoolNumber.toCharArray();
		int n = c.length;

		if (n == 1) {
			return 8;
		}
		int sum = 0;

		if (c[0] == c[1]) {
			sum += 8;
		} else {
			sum += 7;
		}
		if (c[n - 1] == c[n - 2]) {
			sum += 8;
		} else {
			sum += 7;
		}

		for (int i = 1; i < n - 1; i++) {
			int dif = 8;
			if (c[i] != c[i - 1]) {
				--dif;
			}
			if (c[i] != c[i + 1]) {
				--dif;
			}
			sum += dif;
		}

		return sum;
	}

	public static void main(String[] args) {
		System.out.println((new CoolNumbers()).countCoolNumbers("72697996") );
	}
}
