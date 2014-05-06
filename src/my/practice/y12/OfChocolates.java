package my.practice.y12;
import java.util.*;
import java.math.*;

public class OfChocolates {
	HashMap<Integer, Integer> func = new HashMap<Integer, Integer>(10000);

	public int takeChocolates(int n) {
		func.put(0, 0);
		return best(n);
	}

	private int best(int n) {
		Integer r = func.get(n);
		if (r == null) {

			int n1 = Math.max(n / 2, best(n / 2));
			int n2 = Math.max(n / 4, best(n / 4));
			int n3 = Math.max(n / 6, best(n / 6));
			int n4 = Math.max(n / 8, best(n / 8));

			r = Math.max(n, sum(n1, n2, n3, n4));
			func.put(n, r);
		}
		return r;
	}

	private int sum(int n1, int n2, int n3, int n4) {
		return n1 + n2 + n3 + n4;
	}

	public static void main(String[] args) {
		System.out.println((new OfChocolates()).takeChocolates(264572649));
	}
}
