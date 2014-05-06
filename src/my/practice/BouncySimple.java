package my.practice;

public class BouncySimple {
	public static int count(int start, int end) {

		int bouncy = 0;
		out: for (int i = start; i <= end; ++i) {
			int number = i;
			int fstD = number % 10;
			int sndD;
			int d = 0;
			number /= 10;
			while (number != 0) {
				sndD = number % 10;
				if (fstD == sndD) {
					fstD = sndD;
					number /= 10;
					continue;
				}
				if (d == 0) {
					if (fstD > sndD) {
						d = 1;
					} else {
						d = -1;
					}
				} else if ((d == 1 && fstD < sndD) || (d == -1 && fstD > sndD)) {
					bouncy++;
					continue out;
				}
				fstD = sndD;
				number /= 10;
			}
		}
		return end - start + 1 - bouncy;
	}

	public static void main(String[] args) {
		System.out.println(count(1, 1000000));
	}
}