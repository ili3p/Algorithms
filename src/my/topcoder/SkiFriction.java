package my.topcoder;
public class SkiFriction {

	public int bestPosition(String skiFriction, String pathFriction) {
		int result = 0;
		if (skiFriction.length() == pathFriction.length()) {
			return 0;
		}
		char[] ski = skiFriction.toCharArray();
		char[] path = pathFriction.toCharArray();

		for (int i = 0; i < (path.length - ski.length); ++i) {
			int max = -1;
			for (int j = 0; j < ski.length; ++j) {
				int s = Integer.parseInt(Character.toString(ski[j]));
				int p = Integer.parseInt(Character.toString(path[i + j]));
				max = Math.max(max, s + p);
			}
			result += max;
		}

		return result;
	}

}
