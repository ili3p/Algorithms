package my.topcoder;

public class MultiNumber {

	public String check(int number) {

		if (number < 10)
			return "NO";

		String numbers = String.valueOf(number);

		for (int i = 1; i < numbers.length(); ++i) {

			String left = numbers.substring(0, i);
			String right = numbers.substring(i, numbers.length());

			long l = getSum(left);
			if (l == getSum(right))
				return "YES";
		}

		return "NO";
	}

	private long getSum(String number) {

		long sum=1; 
		for(int i=0; i<number.length(); ++i){
			
			char c = number.charAt(i);
			sum*=Long.parseLong(String.valueOf(c));
		}
		return sum;
	}
}
