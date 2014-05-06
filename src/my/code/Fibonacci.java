package my.code;

public class Fibonacci {
	
	public static void main(String[] args) {

		long t = System.nanoTime();
		recursive(5);
		System.out.println(System.nanoTime()-t);
		t = System.nanoTime();
		recursive(5);
		System.out.println(System.nanoTime()-t);
		t = System.nanoTime();
		recursive(5);
		System.out.println(System.nanoTime()-t);
		t = System.nanoTime();
		recursive(5);
		System.out.println(System.nanoTime()-t);
	}

	public static int recursive(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return recursive(n - 1) + recursive(n - 2);
	}
}
