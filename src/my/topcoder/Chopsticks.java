package my.topcoder;
import java.util.*;

public class Chopsticks {

	public int getmax(int[] length) {
		Set<Integer> set = new HashSet<Integer>();
		int c = 0;
		for (int i = 0; i < length.length; i++) {
			int chop = length[i];
			if (set.contains(chop)) {
				++c;
				set.remove(chop);
			} else {
				set.add(chop);
			}
		}
		return c;
	}

}
