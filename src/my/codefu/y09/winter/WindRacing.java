package my.codefu.y09.winter;

import java.text.DecimalFormat;

/*
 * Actually is from summer.
 */

public class WindRacing {
	public static String getSpeed(int n, int[] percentage, int t) {

		double initSpeed = 1000 /(double) t * (1 + Sum(percentage));

		if(initSpeed > 30)
		{
			return "IMPOSSIBLE";
		}

		return new DecimalFormat("0.000").format(initSpeed);
	}

	private static double Sum(int[] percentage) {

		double sum = 0;

		for (int i : percentage) {
			double f =((double)i / 100); 
			sum += 1 / (1 + f);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		int []p= {4,-22,25};
		System.out.println(getSpeed(4,p, 170));
	}
}