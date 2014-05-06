package my.topcoder;

public class BitCleanup {
	public String cleanBits(String firstArray, String secondArray) {
		char[] a = firstArray.toCharArray();
		char[] b = secondArray.toCharArray();

		StringBuilder[] result = new StringBuilder[2];
		result[0] = new StringBuilder();
		result[1] = new StringBuilder();
		int i = 0, j = 0;
		boolean f = true;

		return "";
	}

	public static void main(String[] args) {
		BitCleanup b = new BitCleanup();
		System.out.println(b.cleanBits("0010", "1011"));
	}
}
