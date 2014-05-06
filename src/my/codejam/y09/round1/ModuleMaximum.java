package my.codejam.y09.round1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ModuleMaximum {
	static class nums {
		public int n;
		public int modulo;

		public nums(int n, int modulo) {
			super();
			this.n = n;
			this.modulo = n % modulo;
		}

	}

	static public int getMaximum(int[] numbers, int m) {

		List<nums> n = new ArrayList<nums>();
		for(int k:numbers){
			n.add(new nums(k,m));
		}
		Collections.sort(n, new Comparator<nums>() {
			public int compare(nums n1, nums n2) {
				int m = n2.modulo - n1.modulo;
				if(m==0){
					m = n1.n - n2.n;
				}
				return m;
			}
		});

		return n.get(0).n;
	}
public static void main(String[] args) {
	int [] a = {11,42,24,20,21,74,88,14,53,62,100,65,100,27,40,93,49,50,20};
	System.out.println(getMaximum(a, 21));
}
}
