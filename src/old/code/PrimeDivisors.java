package old.code;

import java.util.*;

/*
 * jazoo_400
 */
public class PrimeDivisors {
	public static boolean[] flag = new boolean[500000];
	public static ArrayList<Integer> primes = new ArrayList<Integer>();
	public static Map<Integer, Integer> gotov = new HashMap<Integer, Integer>();

	public static void genPrimes() {
		int i, j, d;
		d = 100000; /* from range L to U, we have d=U-L+1 numbers. */
		/* use flag[i] to mark whether (L+i) is a prime number or not. */

		for (i = 0; i < d; i++)
			flag[i] = true; /* default: mark all to be true */
		for (i = 1; i < d; i += 2)
			flag[i] = false;
		/* sieve by prime factors staring from 3 till sqrt(U) */
		for (i = 3; i <= 1000; i += 2) {
			if (i > 1 && !flag[i - 1])
				continue;
			/*
			 * choose the first number to be sieved -- >=L, divisible by i, and
			 * not i itself!
			 */
			j = 1 / i * i;
			if (j < 1)
				j += i;
			if (j == i)
				j += i; /*
						 * if j is a prime number, have to start form next one
						 */
			j -= 1; /* change j to the index representing j */
			for (; j < d; j += i)
				flag[j] = false;
		}
		if (1 <= 1)
			flag[1 - 1] = false;
		if (1 <= 2)
			flag[2 - 1] = true;
		for (int n = 0; n < d; ++n) {
			if (flag[n])
				primes.add(n + 1);
		}

	}

	public static int[] prosti = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37,
			41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107,
			109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173 };

	public static int getIt(int n) {
		int c = 0;
		ArrayList<Integer> pr = new ArrayList<Integer>();
		// int i=(int)Math.sqrt(n);
		int m = n;
		int i = n / 2;
		while (i > 0) {

			if (n % i == 0) {
				int tmp;
				tmp = n / i;
				if (!pr.contains(tmp)) {
					++c;
					pr.add(tmp);
				}

				n = i;
				i = (n / 2 + 1);

			}

			if (i % 2 == 1)
				i -= 2;
			else
				--i;
		}
		// for(Integer c1:pr)
		// System.out.print(c1+", ");
		gotov.put(m, c);
		return c;
	}

	public static int biggest(int start, int end) {
		int max = 0;
		int num = 0;
		int max_num = 0;
		int granica = start;
		long temp = prosti[0];
		for (int i = end; i >= granica; --i) {
			if (i == 1) {
				if (num < 1)
					max_num = 1;
				max = i;
				continue;
			}
			boolean f = false;
			num = 0;
			int tmp = i;
			if (i % 2 == 0) {
				num = 1;
				tmp = i;
				while (tmp % 2 == 0) {
					tmp /= 2;
					if (tmp % 2 == 0 && tmp > start) {
						f = true;
						break;
					}
				}
				if (tmp == max) {
					max = i;
					continue;
				} else if (f)
					continue;
			}

			if (tmp % 5 == 0) {
				++num;
				while (tmp % 5 == 0) {
					tmp /= 5;
					if (tmp % 5 == 0 && tmp > start) {
						f = true;
						break;
					}
				}
				if (tmp == max) {
					max = i;
					continue;
				} else if (f)
					continue;
			}

			if (num != 0) {
				if (!gotov.containsKey(tmp))
					num += getIt(tmp);
				else
					num += gotov.get(tmp);
			} else {
				if (gotov.containsKey(i))
					num = gotov.get(i);
				else
					num = getIt(i);
			}

			if (num > max_num) {
				max_num = num;
				max = i;
				temp = prosti[0];

				int j = 1;
				int k = 39;
				for (j = 1; j <= max_num && k > 0; ++j) {

					temp *= prosti[k];
					if (temp > end)
						temp /= prosti[k];
					--k;

				}
				if (temp > granica) {
					granica = (int) temp;

					while (temp < end) {
						/*
						 * if(j<40){ temp/=prosti[j-1]; temp*=prosti[j]; ++j;
						 * }else{
						 */
						temp *= prosti[0];
						// }
						if (temp < end)
							granica = (int) temp;
					}
				}
			}
			System.out.println("Current max is: " + max + " with max_num: "
					+ max_num + " current \"i\" is " + i + " temp is: " + temp
					+ " and granica is:" + granica);
		}
		return max;
	}

	public static long time = 0;

	public static void main(String[] args) {
		time = System.nanoTime();
		System.out.print(biggest(1, 1000000));
		time = System.nanoTime() - time;
		time /= 1000000;
		System.out.print("\t and it took me " + time + "ms");
		// genPrimes();
		// System.out.print("Vkupno: "+getIt(930930));
		// if(primes.contains(85))System.out.print("\nYES");
		/*
		 * for(int i=1;i<11;i++) {
		 * //System.out.println("3^"+i+"="+(int)Math.pow(3, i)%10);
		 * //System.out.println("7^"+i+"="+(int)Math.pow(3, i)%10);
		 * //System.out.println("11^"+i+"="+(int)Math.pow(3, i)%10);
		 * //System.out.println("13^"+i+"="+(int)Math.pow(3, i)%10); }
		 */
	}

}
