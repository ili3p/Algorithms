package my.topcoder;
public class RobotHerbDiv2 {

	public int getdist(int T, int[] a) {
		long x = 0, y = 0;
		int direction = 0;

		for (int i = 0; i < T; ++i) {
			for (int j = 0; j < a.length; j++) {
				int move = a[j];
				switch (direction) {
				case 0: {
					y += move;
					break;
				}
				case 1: {
					x += move;
					break;
				}
				case 2: {
					y -= move;
					break;
				}
				case 3: {
					x -= move;
					break;
				}
				}
				direction = (direction + move) % 4;
			}
		}

		return (int) (Math.abs(x) + Math.abs(y));
	}

}
