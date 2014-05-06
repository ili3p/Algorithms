package my.topcoder;

public class Cryptography {

	public long encrypt(int[] numbers) {
		long product = Long.MIN_VALUE;
		for (int i = 0; i < numbers.length; ++i) {
			long local = 1;
			for (int j = 0; j < numbers.length; ++j) {
				local *= numbers[j] + (i == j ? 1 : 0);
			}
			product = Math.max(product, local);
		}
		return product;
	}

}
