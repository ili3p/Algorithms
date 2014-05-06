package my.topcoder;

import java.util.ArrayList;
import java.util.List;

public class TheSimilarNumbers {

	public int find(int lower, int upper) {
		int a, b;
		int c = 1;
		List<Integer> sim = new ArrayList<Integer>();
		sim.add(lower);
		for (int i = lower + 1; i <= upper; ++i) {
			boolean f = false;
			for (int k : sim) {
				if (!similar(i, k)) {
					f=true;
				}else{
					f=false;
					break;
				}
			}
			if(f){
				sim.add(i);
			}
		}
		return sim.size();
	}

	private boolean similar(int a, int b) {
		return a <= 10 * b && b <= 10 * a;
	}

}
