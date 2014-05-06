package my.topcoder;
public class BallsSeparating {

	public int minOperations(int[] red, int[] green, int[] blue) {
		int numBoxes = red.length;

		int mR = -1, R;
		int mG = -1, G;
		int mB = -1, B;
		long sumR = 0, sumG = 0, sumB = 0;

		for (int i = 0; i < numBoxes; ++i) {
			sumR += red[i];
			sumG += green[i];
			sumB += blue[i];
			if (red[i] > mR) {
				mR = red[i];
				R = i;
			}
			if (green[i] > mG) {
				mG = green[i];
				G = i;
			}
			if (blue[i] > mB) {
				mB = blue[i];
				B = i;
			}
		}
		if (sumR > 0 && sumG > 0 && sumB > 0 && numBoxes < 3) {
			return -1;
		}

		if ((sumR > 0 && sumG > 0 || sumR > 0 && sumB > 0 || sumB > 0 && sumG > 0) && numBoxes < 2) {
			return -1;
		}

		int[] A = new int[numBoxes];
		A[0] = 0;

		int c = 0;
		boolean r = false, g = false, b = false;
		int[] rr = new int[numBoxes], gg = new int[numBoxes], bb = new int[numBoxes];
		for (int i = 0; i < numBoxes; ++i) {
			if (red[i] >= blue[i] && red[i] >= green[i]) {
				c += blue[i] + green[i];
				r = true;
				rr[i] = Integer.MAX_VALUE;
				gg[i] = red[i] - green[i];
				bb[i] = red[i] - blue[i];
			} else if (blue[i] >= red[i] && blue[i] >= green[i]) {
				c += red[i] + green[i];
				b = true;

				rr[i] = blue[i] - red[i];
				gg[i] = blue[i] - green[i];
				bb[i] = Integer.MAX_VALUE;
			} else if (green[i] >= red[i] && green[i] >= blue[i]) {
				c += blue[i] + red[i];
				g = true;

				rr[i] = green[i] - red[i];
				gg[i] = Integer.MAX_VALUE;
				bb[i] = green[i] - blue[i];
			}
		}

		if (!r) {
			int min = Integer.MAX_VALUE;

			for (int i = 0; i < numBoxes; ++i) {
				min = Math.min(rr[i], min);
			}
			c += min;
		}

		if (!b) {
			int min = Integer.MAX_VALUE;

			for (int i = 0; i < numBoxes; ++i) {
				min = Math.min(bb[i], min);
			}
			c += min;
		}
		if (!g) {
			int min = Integer.MAX_VALUE;

			for (int i = 0; i < numBoxes; ++i) {
				min = Math.min(gg[i], min);
			}
			c += min;
		}
		return c;

	}

}
