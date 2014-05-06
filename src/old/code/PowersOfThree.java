package old.code;

public class PowersOfThree {
	public int nthElement(int N) {
		String aa = Integer.toBinaryString(N);
		int broj = 0;
		for (int i = 1; i <= aa.length(); i++) {
			int pow = (int) Math.pow(3, (i - 1));
			if (aa.charAt(aa.length() - i) == '1')
				broj += pow;

		}
		return broj;
	}

	public static void main(String[] args) {
		System.out.println((new PowersOfThree()).nthElement(5));
	}
}
