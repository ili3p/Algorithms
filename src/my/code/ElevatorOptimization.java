package my.code;

public class ElevatorOptimization {
	private static final int NFLOORS = 10;
	private static final int MAX_RIDERS = 10;
	private int[][] m;
	private int[][] p;
	private int[] stops;
	private int nriders;
	private int nstops;

	public static void main(String[] args) {

		int[] st = {0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		ElevatorOptimization ed = new ElevatorOptimization(st);
		System.out.println(ed.optimizeFloors());
	}

	ElevatorOptimization(int[] st) {

		m = new int[NFLOORS + 1][MAX_RIDERS + 1];
		p = new int[NFLOORS + 1][MAX_RIDERS + 1];
		stops = st;
	    nriders = 10;
	    nstops = 10;
	}

	public int optimizeFloors() {

		int i = 1, j = 1, k; // counters
		int cost;// cost of the three options
		int lastStop;

		for (i = 0; i <= NFLOORS; ++i) {
			m[i][0] = floorsWalked(0, Integer.MAX_VALUE);
			p[i][0] = -1;
		}

		for (j = 1; j <= nstops; ++j) {
			for (i = 1; i <= NFLOORS; ++i) {

				m[i][j] = Integer.MAX_VALUE;

				for (k = 0; k <= i; k++) {

					cost = m[k][j - 1] - floorsWalked(k, Integer.MAX_VALUE)
							+ floorsWalked(k, i)
							+ floorsWalked(i, Integer.MAX_VALUE);
					if (cost < m[i][j]) {
						m[i][j] = cost;
						p[i][j] = k;
					}

				}
			}
		}
		lastStop = 0;
		for (i = 1; i <= NFLOORS; ++i) {
			if (m[i][nstops] < m[lastStop][nstops]) {
				lastStop = i;
			}

		}
		return lastStop;
	}

	private int floorsWalked(int prev, int curr) {
		int nsteps = 0;
		int i;

		for (i = 1; i <= nriders; ++i)
			if ((stops[i] > prev) && (stops[i] <= curr)) {
				nsteps += Math.min(stops[i] - prev, curr - stops[i]);
			}
		return nsteps;
	}

}
