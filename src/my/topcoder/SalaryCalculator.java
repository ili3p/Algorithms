package my.topcoder;

public class SalaryCalculator {

	public double calcHours(int P1, int P2, int salary) {
		double s = salary*1.0;
		double d = Math.min(200, s/P1);
		double s1 = (s-(d*P1))/P2;
		return d+s1;
	}

}
